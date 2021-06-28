package fr.almamy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoController {

    // http://localhost:8080/todo-list/hello
    @GetMapping("/hello")
    @ResponseBody
    public String hello(){
        return "Hello";
    }

    // http://localhost:8080/todo-list/welcome
    // prefix + name + suffix
    // /WEB-INF/view/welcome.jsp <-- view resolver result
    @GetMapping("welcome")
    public String welcome(){
        return "welcome";
    }
}
