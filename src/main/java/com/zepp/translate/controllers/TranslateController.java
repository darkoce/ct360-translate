package com.zepp.translate.controllers;

import com.zepp.translate.exceptions.NotFoundException;
import com.zepp.translate.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class TranslateController {

    private final UserService userService;

    @Autowired
    public TranslateController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello-world";
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @GetMapping("/secured/hello")
    public String helloSecured() {
        return "hello-world";
    }

    @GetMapping("/login")
    public String login(){
        return "common/login";
    }

    @GetMapping("/403")
    public String error403() {
        return "error/403";
    }

}
