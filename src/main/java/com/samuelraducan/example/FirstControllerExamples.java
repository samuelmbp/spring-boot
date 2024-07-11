//package com.samuelraducan.example;
//
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//public class FirstControllerExamples {
//
//    @GetMapping("/hello")
//    public String hello() {
//        return "Hello World From First Controller";
//    }
//
//    @PostMapping("/post")
//    public String post(@RequestBody String message) {
//        return "Request Accepted and the message is: " + message;
//    }
//
//    @PostMapping("/post-order")
//    public String post(@RequestBody Order order) {
//        return "Request Accepted and the message is: " + order.toString();
//    }
//
//    // @GetMapping("/hello/{user-name}")
//    public String pathVariable(@PathVariable("user-name") String userName) {
//        return "My values = " + userName;
//    }
//
//    @GetMapping("/hello")
//    public String paramVariable(
//            @RequestParam("user-name") String userName,
//            @RequestParam("user-lastname") String userLastname
//    ) {
//        return "My values = " + userName + " " + userLastname;
//    }
//}
