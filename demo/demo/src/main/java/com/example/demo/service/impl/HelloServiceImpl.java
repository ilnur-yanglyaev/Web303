package com.example.demo.service.impl;

import com.example.demo.service.HelloService;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public String getHelloUser() {
        return "Hello user";
    }

}
