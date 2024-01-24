package org.learning.finalprojectlibrary.controller;

import jakarta.validation.Valid;
import org.learning.finalprojectlibrary.model.Category;
import org.learning.finalprojectlibrary.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping
    private String index(Model model) {
        List<Category> categoryList = categoryRepository.findAll();
        model.addAttribute("categoryList", categoryList);
        return "categories/list";

    }


    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("formCategory", new Category());
        return "categories/form";
    }

    @PostMapping("/create")
    public String store(@Valid @ModelAttribute("formCategory") Category formCategory, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "categories/form";
        }
        categoryRepository.save(formCategory);

        return "redirect:/categories";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        Optional<Category> result = categoryRepository.findById(id);
        if (result.isPresent()) {
            model.addAttribute("formCategory", result.get());
            return "categories/form";
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "category with id " + id + " not found");
        }
    }

    @PostMapping("/edit/{id}")
    public String update(@Valid @ModelAttribute("formCategory") Category formCategory, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "categories/form";
        }
        categoryRepository.save(formCategory);
        return "redirect:/categories";

    }


    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        Optional<Category> result = categoryRepository.findById(id);
        if (result.isPresent()) {
            categoryRepository.deleteById(id);
            redirectAttributes.addFlashAttribute("redirectMessage",
                    "category " + result.get().getName() + " deleted!");
            return "redirect:/categories";
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category with id" + id + " not found");
        }
    }


}
