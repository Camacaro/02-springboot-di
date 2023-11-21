package com.jesus.cources.springboot.di.springbootdi;

import com.jesus.cources.springboot.di.springbootdi.models.service.IServicio;
import com.jesus.cources.springboot.di.springbootdi.models.service.MyService;
import com.jesus.cources.springboot.di.springbootdi.models.service.MyServiceComplex;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
}
