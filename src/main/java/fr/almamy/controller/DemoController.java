package fr.almamy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    // http://localhost:8080/todo-list/hello
    @GetMapping("/hello")
    public String Hello(){
        return "Hello";
    }
}
