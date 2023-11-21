package com.jesus.cources.springboot.di.springbootdi.controllers;

import com.jesus.cources.springboot.di.springbootdi.models.service.IServicio;
import com.jesus.cources.springboot.di.springbootdi.models.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    /**
     * De esta forma tenemos una alta cohesion,
     * usaremos inyección de dependencia para mejorar esto, desacoplarlo
     * private MyService service = new MyService();
     *
     * Con Autowired lo que hace es buscar entre los componentes
     * registrados de spring e inyecta la clase que sea del tipo
     * de dato puesto, en este caso MyService (IServicio), pero este tipo de
     * dato tiene que ser genérico (interfaces) y no concretos (clases)
     *
     * Hay tres formas para hacer la inyección de dependencia
     * 1. Mediante variable
     * @Autowired
     * private IServicio service;
     *
     * 2. Mediante setter
     * @Autowired
     * public void setService(IServicio service) {
     *  this.service = service;
     * }
     *
     * 3. Mediante constructor
     * public IndexController(IServicio service) {
     *     this.service = service;
     * }
     *
     * Para diferenciar las clases que implementen IServicio
     * y sea inyectado correctamente, en la clase servicio hay que
     * agregar el decorador @Primary para que inyecte ese.
     * El @Primary sirve para que sea por defecto ahora si
     * quisiera usar otro que no sea por defecto puedo usar
     * el decorador Qualifier("myClase") y asignar el nombre
     * del componente asignado a la clase
     *
     */
    @Autowired
    @Qualifier("mySimpleService")
    private IServicio service;
    @GetMapping({"", "/", "index"})
    public String index(Model model) {
        model.addAttribute("obj", service.operation());
        return "index";
    }

    public void setService(IServicio service) {
        this.service = service;
    }
}
