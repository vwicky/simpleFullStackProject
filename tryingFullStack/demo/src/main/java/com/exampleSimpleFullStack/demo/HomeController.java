package com.exampleSimpleFullStack.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {

    @GetMapping("/hello")
    public String getHello() {
        return "<h1> Hello World </h1>";
    }

}
