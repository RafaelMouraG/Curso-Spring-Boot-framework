package com.rafaelmourag.rest_with_spring_boot_and_java_erudio.Controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rafaelmourag.rest_with_spring_boot_and_java_erudio.Model.Greeting;

@RestController
public class GreetingController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();


    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name",defaultValue = "Word") String name){

       return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}
