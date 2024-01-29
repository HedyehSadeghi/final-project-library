package org.learning.finalprojectlibrary.controller;

import jakarta.validation.Valid;
import org.learning.finalprojectlibrary.model.Book;
import org.learning.finalprojectlibrary.model.Category;
import org.learning.finalprojectlibrary.model.ClientPurchase;
import org.learning.finalprojectlibrary.repository.BookRepository;
import org.learning.finalprojectlibrary.repository.CategoryRepository;
import org.learning.finalprojectlibrary.repository.ClientPurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/shop")
public class ShopController {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ClientPurchaseRepository clientPurchaseRepository;

    @GetMapping
    public String shop(@RequestParam(name = "keyword", required = false) String searchKeyword, @RequestParam(name = "category", required = false) List<Category> categories, Model model) {
        List<Book> shopList = new ArrayList<>();
        if (searchKeyword != null && categories == null) {
            shopList = bookRepository.findByTitleContaining(searchKeyword);
        } else if (searchKeyword == null && categories == null) {
            shopList = bookRepository.findAll();
        } else if (searchKeyword == null && (categories != null)) {
            shopList = bookRepository.findAll();
            List<Book> filteredList = new ArrayList<>();

            if (!(categories.isEmpty())) {
                for (Book book : shopList) {
                    for (Category cat : book.getCategoryList()) {
                        if (categories.contains(cat)) {
                            filteredList.add(book);
                        }
                    }
                }

            }
            shopList = filteredList;
        }

        model.addAttribute("shopList", new HashSet<>(shopList));
        model.addAttribute("categoryList", categoryRepository.findAll());
        return "shop/list";
    }


    @GetMapping("/show/{id}")
    public String show(@PathVariable Integer id, Model model) {
        Optional<Book> result = bookRepository.findById(id);
        if (result.isPresent()) {
            model.addAttribute("book", result.get());
            return "shop/show";

        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book with id " + id + " not found");
        }
    }

    @GetMapping("/buy/{id}")
    public String buyNow(@PathVariable("id") Integer bookId, Model model) {
        ClientPurchase clientPurchase = new ClientPurchase();
        Optional<Book> result = bookRepository.findById(bookId);
        if (result.isPresent()) {
            Book book = result.get();
            clientPurchase.setBook(book);
            clientPurchase.setAmount(1);
            clientPurchase.setDate(LocalDate.now());
            model.addAttribute("clientPurchase", clientPurchase);
            return "shop/buy-now";
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book with id " + bookId + " not found");
        }


    }

    @PostMapping("/buy")
    public String storePurchase(@Valid @ModelAttribute ClientPurchase clientPurchaseForm, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "shop/buy-now";
        }

        clientPurchaseRepository.save(clientPurchaseForm);
        redirectAttributes.addFlashAttribute("redirectMessage", "Congratz, you successfully bought " + clientPurchaseForm.getAmount() + " copies of " + clientPurchaseForm.getBook().getTitle());
        return "redirect:/shop";
    }
}
