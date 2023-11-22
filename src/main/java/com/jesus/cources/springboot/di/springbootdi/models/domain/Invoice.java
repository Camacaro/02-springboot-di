package com.jesus.cources.springboot.di.springbootdi.models.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Invoice {

    @Value("${invoice.description}")
    private String description;
    private Client client;
    private List<ItemInvoice> items;

    /**
     * Vienen de AppConfig como been y es inyectado como dependencia
     * @param client Client
     * @param items List<ItemInvoice>
     *
     * Ahora si existe más de un List<ItemInvoice> hay que especificar cuál usar
     * usando el @Qualifier("itemsInvoiceOffice")
     */
    @Autowired
    public Invoice(Client client, @Qualifier("itemsInvoiceOffice") List<ItemInvoice> items) {
        this.client = client;
        this.items = items;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<ItemInvoice> getItems() {
        return items;
    }

    public void setItems(List<ItemInvoice> items) {
        this.items = items;
    }
}
