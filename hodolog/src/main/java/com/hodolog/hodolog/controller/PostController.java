package com.hodolog.hodolog.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

    // SSR 방식: jsp, thymeleaf, mustache, freemarker -> HTML rendering
    // SPA 방식: react(SSR + react = next), vue(SSR + vue = nuxt) -> js. <-> API(JSON)

    @GetMapping("/")
    public String get() { return "Hello World!"; }
}
