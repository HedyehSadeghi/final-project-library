package org.learning.finalprojectlibrary.controller;

import org.learning.finalprojectlibrary.model.Book;
import org.learning.finalprojectlibrary.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private BookRepository bookRepository;


    @GetMapping()
    private String index(Model model) {
        //top5 ever
        List<Book> bookListTop5 = bookRepository.findAll(Sort.by("ClientPurchases").descending());
        bookListTop5 = bookListTop5.subList(0, 5);

        //top5 last month
        LocalDate firstDayOfPreviousMonth = LocalDate.now().minusMonths(1).with(TemporalAdjusters.firstDayOfMonth());
        LocalDate lastDayOfPreviousMonth = LocalDate.now().minusMonths(1).with(TemporalAdjusters.lastDayOfMonth());
        
        //top5 horror
        List<Book> horrorTop5 = bookRepository.findBestSellersByCategory("Horror");

        model.addAttribute("bookListTop5", bookListTop5);

        model.addAttribute("horrorTop5", horrorTop5);

        return "home/landing-page";
    }

    @GetMapping("contacts")
    private String contacts() {
        return "home/contacts";
    }

}
