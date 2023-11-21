package com.jesus.cources.springboot.di.springbootdi.models.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * Con la decoración @Primary le decimos a spring que utilice
 * este componente sobre cualquier otro que esté usando el tipo
 * de dato IServicio y lo inyecte donde se use
 */
@Primary
@Component("myComplexService")
public class MyServiceComplex implements IServicio {

    @Override
    public String operation() {
        return "ejecutando algún proceso importante...";
    }
}
