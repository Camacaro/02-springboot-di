package com.jesus.cources.springboot.di.springbootdi.models.service;

import org.springframework.stereotype.Component;

/**
 * Registrar esta clase como componente @Component para poder
 * inyectarla en otros componentes.
 *
 * También se puede usar @Service para agregar lógica de negocio
 * es un componente, es una fallada de un componente, la diferencia
 * es semántica, conceptualmente
 */
@Component("mySimpleService")
public class MyService implements IServicio {

    /**
     * Cabe destacar que al crear un servicio o componente
     * debemos crear un constructor vacío, si tenemos uno
     * con parámetros estamos obligados a crear uno vacío, ya
     * que spring boot lo va a llamar de ese modo automáticamente
     * ahora si no hay ninguno lo hace implícitamente.
     */

    @Override
    public String operation() {
        return "ejecutando algún proceso simple...";
    }
}
