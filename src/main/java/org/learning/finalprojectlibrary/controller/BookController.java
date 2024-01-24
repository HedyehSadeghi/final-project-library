package org.learning.finalprojectlibrary.controller;

import jakarta.validation.Valid;
import org.learning.finalprojectlibrary.model.Book;
import org.learning.finalprojectlibrary.repository.BookRepository;
import org.learning.finalprojectlibrary.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping
    private String index(Model model) {
        List<Book> bookList = bookRepository.findAll();
        model.addAttribute("bookList", bookList);
        return "books/list";
    }


    @GetMapping("/create")
    public String create(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
        return "books/create";
    }


    @PostMapping("/create")
    public String store(@Valid @ModelAttribute("book") Book formBook, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("categoryList", categoryRepository.findAll());
            return "books/create";
        }
        Book savedBook = bookRepository.save(formBook);
        return "redirect:/books";

    }


    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        Optional<Book> result = bookRepository.findById(id);
        if (result.isPresent()) {
            model.addAttribute("book", result.get());
            model.addAttribute("categoryList", categoryRepository.findAll());
            return "books/edit";
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book with id " + id + " not found");
        }
    }

    @PostMapping("/edit/{id}")
    public String update(@PathVariable Integer id, @Valid @ModelAttribute("book") Book formBook, BindingResult bindingResult) {
        Optional<Book> result = bookRepository.findById(id);
        if (result.isPresent()) {
            Book bookToEdit = result.get();
            if (bindingResult.hasErrors()) {
                return "books/edit";
            }
            Book savedBook = bookRepository.save(formBook);
            return "redirect:/books";
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book with id " + id + " not found");
        }
    }


    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        Optional<Book> result = bookRepository.findById(id);
        if (result.isPresent()) {
            bookRepository.deleteById(id);
            redirectAttributes.addFlashAttribute("redirectMessage", "Book " + result.get().getTitle() + " deleted!");
            return "redirect:/books";
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book with di " + id + " not found");
        }
    }


    @GetMapping("/warehouse")
    public String warehouse(Model model) {
        List<Book> totalBooksList = bookRepository.findAll();
        List<Book> bookList = new ArrayList<>();
        for (Book book : totalBooksList) {
            if (book.getWarehouse() > 0) {
                bookList.add(book);
            }
        }
        model.addAttribute("bookList", bookList);
        return "books/warehouse";
    }


}
