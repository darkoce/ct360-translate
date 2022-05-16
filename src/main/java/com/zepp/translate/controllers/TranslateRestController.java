package com.zepp.translate.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class TranslateRestController {

    private RestTemplate restTemplate;

    @Autowired
    public TranslateRestController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/hello-rest")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping("/hello-systran/{lang}/{input}")
    public String helloSystran(@PathVariable("input") String input, @PathVariable("lang") String lang) {
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
        Map map = new HashMap<String, String>();
        map.put("Content-Type", "application/json");
        map.put("Authorization", "Key 1bf448dc-360e-4b8b-9355-2c36c4619e65");

        headers.setAll(map);
        HttpEntity<?> request = new HttpEntity<>(headers);

        String url = "https://api-translate.systran.net/translation/text/translate?source=en&target=" + lang + "&input=" + input;
        System.out.println("Systran");
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, request, String.class);
        System.out.println(response.getBody());
        //List<Outputs> outputsList = response.getBody();
        return response.getBody();
    }
}
