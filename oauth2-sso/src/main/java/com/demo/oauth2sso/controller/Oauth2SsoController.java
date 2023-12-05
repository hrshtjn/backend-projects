package com.demo.oauth2sso.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Oauth2SsoController {

    @GetMapping("/hello")
    public String helloUser() {
        return "Hello user";
    }
}
