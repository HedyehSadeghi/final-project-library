package org.learning.finalprojectlibrary.controller;

import org.learning.finalprojectlibrary.comparator.BookPurchaseComparator;
import org.learning.finalprojectlibrary.model.Book;
import org.learning.finalprojectlibrary.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private BookRepository bookRepository;


    @GetMapping()
    private String index(Model model) {
        //top5 ever
        List<Book> bookListTop5 = bookRepository.findAll();
        Collections.sort(bookListTop5, Collections.reverseOrder(new BookPurchaseComparator()));
        bookListTop5 = bookListTop5.subList(0, 5);


        //top5 last month
        LocalDate firstDayOfPreviousMonth = LocalDate.now().minusMonths(1).with(TemporalAdjusters.firstDayOfMonth());
        LocalDate lastDayOfPreviousMonth = LocalDate.now().minusMonths(1).with(TemporalAdjusters.lastDayOfMonth());


        //top5 horror
        List<Book> books = bookRepository.findAll();
        Collections.sort(books, Collections.reverseOrder(new BookPurchaseComparator()));
        // Filtra i libri horror usando un predicato
        Predicate<Book> isHorror = book -> book.getCategoryList().stream().anyMatch(category -> category.getName().equals("Horror"));
        List<Book> horrorTop5 = books.stream().filter(isHorror).collect(Collectors.toList());
        horrorTop5 = horrorTop5.subList(0, 5);

        //top5 fantasy
        List<Book> books1 = bookRepository.findAll();
        Collections.sort(books1, Collections.reverseOrder(new BookPurchaseComparator()));
        Predicate<Book> isFantasy = book -> book.getCategoryList().stream().anyMatch(category -> category.getName().equals("Fantasia e Fantascienza"));
        List<Book> fantasyTop5 = books1.stream().filter(isFantasy).collect(Collectors.toList());
        fantasyTop5 = fantasyTop5.subList(0, 5);

        //top5 narrativa
        List<Book> books2 = bookRepository.findAll();
        Collections.sort(books2, Collections.reverseOrder(new BookPurchaseComparator()));
        Predicate<Book> isFiction = book -> book.getCategoryList().stream().anyMatch(category -> category.getName().equals("Narrativa Straniera"));
        List<Book> fictionTop5 = books2.stream().filter(isFiction).collect(Collectors.toList());
        fictionTop5 = fictionTop5.subList(0, 5);

        //top5 psicologia
        List<Book> books3 = bookRepository.findAll();
        Collections.sort(books3, Collections.reverseOrder(new BookPurchaseComparator()));
        Predicate<Book> isPsychology = book -> book.getCategoryList().stream().anyMatch(category -> category.getName().equals("Psicologia"));
        List<Book> psychologyTop5 = books3.stream().filter(isPsychology).collect(Collectors.toList());
        psychologyTop5 = psychologyTop5.subList(0, 5);


        model.addAttribute("bookListTop5", bookListTop5);
        model.addAttribute("horrorTop5", horrorTop5);
        model.addAttribute("fantasyTop5", fantasyTop5);
        model.addAttribute("fictionTop5", fictionTop5);
        model.addAttribute("psychologyTop5", psychologyTop5);

        return "home/landing-page";
    }

    @GetMapping("contacts")
    private String contacts() {
        return "home/contacts";
    }

}
