package com.jesus.cources.springboot.di.springbootdi.models.domain;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

/**
 * Los Scope de componente
 * por defecto son de tipo singleton por lo que cualquiera (petición http)
 * que utilice Invoice los datos se van a estar manteniendo/compartiendo
 *
 * Con el @RequestScope solo vivirá el componente por petición, cada
 * solicitud será independiente una de otra.
 *
 * Ejemplo1:
 * Client cuando es singleton va a estar concatenando en cada solicitud
 * "Alejandro", ya que es uno solo acumulara todos los datos. Ahora si le
 * agregamos el @RequestScope estará desde su valor inicial
 */
@Component
@RequestScope
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

    /**
     * Con el @PostConstruct actuamos en el ciclo de vida de un componente
     * esto se ejecuta luego de instance el objeto y luego de inyectarse
     * donde se pida por consecuencia ya se puede usar sus variables.
     *
     * Podemos modificar los datos, llamar un proceso, etc al final
     * es parecido a un constructor, pero ligeramente diferente
     * El método anotado con @PostConstruct se ejecuta después de que
     * todas las dependencias han sido inyectadas y antes de que el
     * bean esté disponible para su uso.
     * Es útil cuando necesitas realizar algunas operaciones de
     * inicialización que dependen de la inyección de dependencias.
     * Se puede usar para ejecutar lógica de inicialización que no
     * es apropiada colocar en el constructor.
     */
    @PostConstruct
    public void init() {
        client.setName(client.getName().concat(" ").concat("Alejandro"));
        description = description.concat(" del cliente: ").concat(client.getName());
    }

    /**
     * Ciclo de vida
     * Cuando se destruye el componente
     *
     * Esta clase o componente por defecto es de tipo singleton (Por defecto, el alcance es singleton)
     * o sea que durara todo lo que viva la aplicación
     * para ver este console log debemos encender y apagar
     * la aplicación y en ese momento que se destruye el componente
     * es cuando se mostrara
     */
    @PreDestroy
    public void destroy() {
        System.out.println("Factura destruida: ".concat(description));
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
