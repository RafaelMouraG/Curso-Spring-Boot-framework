package com.rafaelmourag.rest_with_spring_boot_and_java_erudio.Controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.rafaelmourag.rest_with_spring_boot_and_java_erudio.Model.Person;
import com.rafaelmourag.rest_with_spring_boot_and_java_erudio.Service.PersonService;


@RestController
@RequestMapping("/person")
public class PersonController {
    

    @Autowired
    private PersonService service;

    @GetMapping(
    produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Person> findAll(){
        return service.findAll();
    }

    @GetMapping(value = "/{id}",
    produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Person findById(@PathVariable("id") Long id){
        return service.findById(id);
    }

    @PostMapping(
    produces = MediaType.APPLICATION_JSON_VALUE,
    consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Person create(@RequestBody Person person){
        return service.create(person);
    }

    @PutMapping(
    produces = MediaType.APPLICATION_JSON_VALUE,
    consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Person update(@RequestBody Person person){
        return service.update(person);
    }

      @DeleteMapping("/{id}")
    public  ResponseEntity<?> delete(@PathVariable("id") Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    
}
