package fr.almamy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoController {

    // http://localhost:8080/todo-list/hello
    @GetMapping("/hello")
    @ResponseBody
    public String Hello(){
        return "Hello";
    }
}
