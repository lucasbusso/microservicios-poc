package microservicios_poc.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldRestController {

    @GetMapping({"/hello-world", "/test"})
    public String helloWorld() {
        System.out.println("Solicitud ejecutada");
        return "Hello world";
    }

}
