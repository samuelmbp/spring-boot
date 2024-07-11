package com.samuelraducan.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello World From First Controller";
    }

    @PostMapping("/post")
    public String post(@RequestBody String message) {
        return "Request Accepted and the message is: " + message;
    }
}
