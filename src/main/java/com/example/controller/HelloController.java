package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static java.util.Optional.ofNullable;

@RestController
public class HelloController {

    @GetMapping("echo")
    public String echo(@RequestParam(name = "arg", required = false) String arg) {
        return ofNullable(arg).orElse("hello world");
    }

}
