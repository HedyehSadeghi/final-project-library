package org.learning.finalprojectlibrary.controller;

import org.learning.finalprojectlibrary.model.Book;
import org.learning.finalprojectlibrary.repository.BookRepository;
import org.learning.finalprojectlibrary.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/shop")
public class ShopController {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping
    private String shop(Model model) {
        List<Book> shopList = bookRepository.findAll();
        model.addAttribute("shopList", shopList);
        return "shop/list";
    }
}
