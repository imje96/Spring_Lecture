package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    // localhost:8080 들어오면 이게 호출이 될 것
    @GetMapping("/")
    public String home() {
        return "home";
    }
}
