package org.learning.finalprojectlibrary.controller;

import org.learning.finalprojectlibrary.model.Book;
import org.learning.finalprojectlibrary.model.ClientPurchase;
import org.learning.finalprojectlibrary.repository.BookRepository;
import org.learning.finalprojectlibrary.repository.CategoryRepository;
import org.learning.finalprojectlibrary.repository.ClientPurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

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
    public String shop(Model model) {
        List<Book> shopList = bookRepository.findAll();
        model.addAttribute("shopList", shopList);
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
            clientPurchase.setPrice(book.getPrice());
            model.addAttribute("clientPurchase", clientPurchase);
            return "shop/buy-now";
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book with id " + bookId + " not found");
        }


    }

    @PostMapping("")
    public String storePurchase() {


        return "";
    }


}
