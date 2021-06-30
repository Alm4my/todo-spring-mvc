package fr.almamy.controller;

import fr.almamy.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class DemoController {
    // == Fields ==
    private final DemoService demoService;

    // == Constructors ==
    @Autowired
    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

    // == Request Methods ==
    // http://localhost:8080/todo-list/hello
    @GetMapping("/hello")
    @ResponseBody
    public String hello(){
        return "Hello";
    }

    // http://localhost:8080/todo-list/welcome
    // http://localhost:8080/todo-list/welcome?user=Almamy
    @GetMapping("welcome")
    public String welcome(@RequestParam String user, Model model){
        model.addAttribute("helloMessage", demoService.getHelloMessage(user));
        log.info("model = {}", model);

        // prefix + name + suffix
        // /WEB-INF/view/welcome.jsp <-- view resolver result
        return "welcome";
    }

    // == Model Attributes ==
    @ModelAttribute("welcomeMessage")
    public String welcomeMessage(){
        log.info("welcomeMessage() called");

        return demoService.getWelcomeMessage();
    }

}
