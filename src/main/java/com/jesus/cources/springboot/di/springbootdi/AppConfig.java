package com.jesus.cources.springboot.di.springbootdi;

import com.jesus.cources.springboot.di.springbootdi.models.domain.ItemInvoice;
import com.jesus.cources.springboot.di.springbootdi.models.domain.Product;
import com.jesus.cources.springboot.di.springbootdi.models.service.IServicio;
import com.jesus.cources.springboot.di.springbootdi.models.service.MyService;
import com.jesus.cources.springboot.di.springbootdi.models.service.MyServiceComplex;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class AppConfig {

    /**
     * Otra forma de registrar servicios o componentes desde una clase
     * de configuración.
     *
     * Para usar el mismo ejemplo debo ir a los archivos
     * models/service/MyService.java
     * models/service/MyServiceComplex.java
     * y comentar sus respectivos @Component y @Primary
     * además de cambiarle el nombre a los Bean de esta clase a los mismos
     * que usé en models/service
     *
     * Ahora debo crear unos métodos que sean del tipo de dato
     * e inyectar IServicio y devolver el llamado de la clase
     * correspondiente.
     * Primero debo agregarle el decorador @Bean y asignarles nombres
     * ahora puedo usar @Primary para ponerlo como defecto o en los controladores
     * poner su nombre en los @Qualifier
     */

    @Bean("meServiceConfigSimple")
    public IServicio registerMyService() {
        return new MyService();
    }

    @Bean("meServiceComplexConfigSimple")
    public IServicio registerMyServiceComplex() {
        return new MyServiceComplex();
    }

    @Bean("itemsInvoice")
    public List<ItemInvoice> registerItems() {
        Product product1 = new Product("Camara Sony", 100);
        Product product2 = new Product("Bicicleta", 150);

        ItemInvoice line1 = new ItemInvoice(product1, 2);
        ItemInvoice line2 = new ItemInvoice(product2, 1);

        return Arrays.asList(line1, line2);
    }

    @Bean("itemsInvoiceOffice")
    public List<ItemInvoice> registerItemsOffice() {
        Product product1 = new Product("Monitor LG LCD 24", 300);
        Product product2 = new Product("Notebook Asus", 500);
        Product product3 = new Product("Impresora HP", 150);
        Product product4 = new Product("Escritorio", 300);

        ItemInvoice line1 = new ItemInvoice(product1, 2);
        ItemInvoice line2 = new ItemInvoice(product2, 1);
        ItemInvoice line3 = new ItemInvoice(product3, 1);
        ItemInvoice line4 = new ItemInvoice(product4, 1);

        return Arrays.asList(line1, line2, line3, line4);
    }
}
