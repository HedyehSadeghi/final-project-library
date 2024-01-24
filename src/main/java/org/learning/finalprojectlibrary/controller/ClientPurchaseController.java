package org.learning.finalprojectlibrary.controller;

import jakarta.validation.Valid;
import org.learning.finalprojectlibrary.model.ClientPurchase;
import org.learning.finalprojectlibrary.repository.BookRepository;
import org.learning.finalprojectlibrary.repository.ClientPurchaseRepository;
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
        return "clients/purchases-list";
    }

    @GetMapping("/create-purchase")
    public String create(Model model) {
        ClientPurchase clientPurchase = new ClientPurchase();
        model.addAttribute("clientPurchase", clientPurchase);
        return "clients/purchase-form";
    }

    @PostMapping("/create-purchase")
    public String store(@Valid @ModelAttribute("clientPurchase") ClientPurchase formClientPurchase, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "clients/purchase-form";
        }
        ClientPurchase savedClientPurchase = clientPurchaseRepository.save(formClientPurchase);
        return "redirect:/clients/purchases";
    }


    @GetMapping("/edit-purchase/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        Optional<ClientPurchase> result = clientPurchaseRepository.findById(id);
        if (result.isPresent()) {
            model.addAttribute("clientPurchase", result.get());
            return "clients/purchase-form";
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "purchase with id " + id + " not found");
        }
    }

    @PostMapping("/edit-purchase/{id}")
    public String update(@PathVariable Integer id, @Valid @ModelAttribute("clientPurchase") ClientPurchase clientPurchaseForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "clients/purchase-form";
        }
        clientPurchaseRepository.save(clientPurchaseForm);
        return "redirect:/clients/purchases";

    }

    @PostMapping("/delete-purchase/{id}")
    public String delete(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        Optional<ClientPurchase> result = clientPurchaseRepository.findById(id);
        if (result.isPresent()) {
            ClientPurchase clientPurchaseToDelete = result.get();
            clientPurchaseRepository.delete(clientPurchaseToDelete);
            redirectAttributes.addFlashAttribute("redirectMessage", "purchase with id  " + id + " deleted");
            return "redirect:/clients/purchases";
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "purchase with id " + id + " not found");
        }

    }


}
