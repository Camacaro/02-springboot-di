package com.jesus.cources.springboot.di.springbootdi.controllers;

import com.jesus.cources.springboot.di.springbootdi.models.domain.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/invoice")
public class InvoiceController {

    private final Invoice invoice;

    @Autowired
    public InvoiceController(Invoice invoice) {
        this.invoice = invoice;
    }

    @GetMapping("/show")
    public String show(Model model) {
        model.addAttribute("invoice", invoice);
        model.addAttribute("title", "Ejemplo Factura con inyección de dependencia");
        return "invoice/show";
    }
}
