package cz.upce.fei.nnpiacv.controller;

import cz.upce.fei.nnpiacv.service.GreetingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingControl {

    private final GreetingService greetingService;

    public GreetingControl(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/")
    public String sayGreeting() {
        return greetingService.sayGreeting();
    }
}
