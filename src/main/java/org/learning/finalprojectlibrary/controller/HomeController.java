package org.learning.finalprojectlibrary.controller;

import org.learning.finalprojectlibrary.model.Book;
import org.learning.finalprojectlibrary.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private BookRepository bookRepository;


    @GetMapping()
    private String index(Model model) {
        List<Book> bookList = bookRepository.findAll(Sort.by("ClientPurchases").descending());

        model.addAttribute("bookList", bookList);

        return "home/landing-page";
    }

    @GetMapping("contacts")
    private String contacts() {
        return "home/contacts";
    }

}
