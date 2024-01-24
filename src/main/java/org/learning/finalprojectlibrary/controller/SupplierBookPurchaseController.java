package org.learning.finalprojectlibrary.controller;

import org.learning.finalprojectlibrary.model.SupplierBookPurchase;
import org.learning.finalprojectlibrary.repository.SupplierBookPurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/supplierpurchase")
public class SupplierBookPurchaseController {
    @Autowired
    private SupplierBookPurchaseRepository supplierBookPurchaseRepository;
    @GetMapping
    public String index(Model model){
        List<SupplierBookPurchase> supplierpurchases = supplierBookPurchaseRepository.findAll();
        model.addAttribute("supplierPurchases", supplierpurchases);
        return "suppliers/purchases";
    }
}
