package com.rafaelmourag.rest_with_spring_boot_and_java_erudio.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.rafaelmourag.rest_with_spring_boot_and_java_erudio.Service.PersonService;

@RestController
public class PersonController {
    

    @Autowired
    private PersonService service;
}
