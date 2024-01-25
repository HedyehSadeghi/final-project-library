package org.learning.finalprojectlibrary.controller;

import jakarta.validation.Valid;
import org.learning.finalprojectlibrary.model.Category;
import org.learning.finalprojectlibrary.model.SupplierBookPurchase;
import org.learning.finalprojectlibrary.repository.BookRepository;
import org.learning.finalprojectlibrary.repository.SupplierBookPurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
@RequestMapping("/suppliers")
public class SupplierBookPurchaseController {
    @Autowired
    private SupplierBookPurchaseRepository supplierBookPurchaseRepository;
    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/purchases")
    public String index(Model model) {
        List<SupplierBookPurchase> supplierpurchases = supplierBookPurchaseRepository.findAll(Sort.by("date").descending());
        model.addAttribute("supplierPurchases", supplierpurchases);
        return "suppliers/purchases";
    }

    @PostMapping("/delete-purchase/{id}")
    public String delete(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        Optional<SupplierBookPurchase> result = supplierBookPurchaseRepository.findById(id);
        if (result.isPresent()) {
            supplierBookPurchaseRepository.deleteById(id);
            redirectAttributes.addFlashAttribute("redirectMessage", "purchase with id  " + id + " deleted");
            return "redirect:/suppliers/purchases";
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Supplier purchase with id" + id + " not found");
        }
    }

    @GetMapping("/create-purchase")
    public String create(Model model) {
        model.addAttribute("formSupp", new SupplierBookPurchase());
        model.addAttribute("bookList", bookRepository.findAll());
        return "suppliers/form";
    }

    @PostMapping("/create-purchase")
    public String store(@Valid @ModelAttribute("formSupp") SupplierBookPurchase formSupp, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("bookList", bookRepository.findAll());
            return "suppliers/form";
        }
        supplierBookPurchaseRepository.save(formSupp);
        return "redirect:/suppliers/purchases";
    }
}
