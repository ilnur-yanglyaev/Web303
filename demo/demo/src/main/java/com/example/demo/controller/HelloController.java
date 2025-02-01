package com.example.demo.controller;

import com.example.demo.service.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    private final HelloService helloService;
    public HelloController(HelloService helloService) {this.helloService = helloService;}

    @GetMapping("/hello")
    public String hello(){
        return "Hello!";
    }

    @GetMapping("/helloClient")
    public String getHelloMessage(@RequestParam String name){
        return "Hello," + name;
    }

}
