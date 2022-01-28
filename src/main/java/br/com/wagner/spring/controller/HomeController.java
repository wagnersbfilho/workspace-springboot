package br.com.wagner.spring.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController
public class HomeController {

    @GetMapping("/")
    //@ResponseBody
    public String hello() {
        return "Página inicial!";
    }

}