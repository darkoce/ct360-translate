package com.zepp.translate.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TranslateRestController {

    @GetMapping("/hello-rest")
    public String helloWorld() {
        return "Hello World";
    }
}
