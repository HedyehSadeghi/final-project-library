package org.learning.finalprojectlibrary.controller;

import org.learning.finalprojectlibrary.model.Book;
import org.learning.finalprojectlibrary.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private BookRepository bookRepository;


    @GetMapping()
    private String index(@RequestParam(name = "keyword", required = false) String searchKeyword, Model model) {
        List<Book> bookList;

        if (searchKeyword != null) {
            bookList = bookRepository.findByTitleContaining(searchKeyword);
        } else {
            bookList = bookRepository.findAll(Sort.by("ClientPurchases").descending());
        }
        model.addAttribute("bookList", bookList);
        model.addAttribute("preloadSearch", searchKeyword);

        return "home/landing-page";
    }

    @GetMapping("contacts")
    private String contacts() {
        return "home/contacts";
    }

}
