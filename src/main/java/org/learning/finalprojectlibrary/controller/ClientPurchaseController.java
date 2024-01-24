package org.learning.finalprojectlibrary.controller;

import jakarta.validation.Valid;
import org.learning.finalprojectlibrary.model.ClientPurchase;
import org.learning.finalprojectlibrary.repository.BookRepository;
import org.learning.finalprojectlibrary.repository.ClientPurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/clients")
public class ClientPurchaseController {
    @Autowired
    private ClientPurchaseRepository clientPurchaseRepository;
    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/purchases")
    public String index(Model model) {
        List<ClientPurchase> clientPurchaseList = clientPurchaseRepository.findAll();
        model.addAttribute("clientPurchaseList", clientPurchaseList);
        return "clients/purchaseslist";
    }

    @GetMapping("/create")
    public String create(Model model) {
        ClientPurchase clientPurchase = new ClientPurchase();
        model.addAttribute("clientPurchase", clientPurchase);
        return "clients/create";
    }

    @PostMapping("/create")
    public String store(@Valid @ModelAttribute("clientPurchase") ClientPurchase formClientPurchase, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "clients/create";
        }
        ClientPurchase savedClientPurchase = clientPurchaseRepository.save(formClientPurchase);
        return "redirect:/clients/purchaseslist";
    }
}
