package com.zepp.translate.controllers;

import com.zepp.translate.entities.request.LanguageTranslateRequest;
import com.zepp.translate.entities.request.Output;
import com.zepp.translate.exceptions.NotFoundException;
import com.zepp.translate.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Controller
public class TranslateController {

    private final UserService userService;
    private final RestTemplate restTemplate;

    @Autowired
    public TranslateController(UserService userService, RestTemplate restTemplate) {
        this.userService = userService;
        this.restTemplate = restTemplate;
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
