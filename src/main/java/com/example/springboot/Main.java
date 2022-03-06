package com.example.springboot;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import java.util.Locale;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Controller
    @RequestMapping("user")
    public static class GreetingController {

        private final CounterService counterService;

        public GreetingController(@Qualifier("counterServiceImpl") CounterService counterService) {
            this.counterService = counterService;
        }

        @GetMapping(value = "/greeting")
        public String requestGreeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
            model.addAttribute("name", StringUtils.toUpperCase(name, Locale.ENGLISH));

            counterService.add();
            model.addAttribute("counter", counterService.GetCounter());
            return "greeting";
        }

        @RequestMapping(value = "/greeting2", method = {RequestMethod.POST})
        public String requestGreeting2(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
            model.addAttribute("name", StringUtils.toUpperCase(name, Locale.ENGLISH));

            counterService.add();
            model.addAttribute("counter", counterService.GetCounter());
            return "greeting";
        }

        @RequestMapping(value = "/welcome/{name}", method = RequestMethod.GET)
        public String listUsersInvoices(@PathVariable(name = "name") String userName, Model model) {
            model.addAttribute("name", StringUtils.toUpperCase(userName, Locale.ENGLISH));

            counterService.add();
            model.addAttribute("counter", counterService.GetCounter());
            return "greeting";
        }
    }
}
