package com.rafaelmourag.rest_with_spring_boot_and_java_erudio.Controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.rafaelmourag.rest_with_spring_boot_and_java_erudio.DTO.PersonDTO;
import com.rafaelmourag.rest_with_spring_boot_and_java_erudio.DTOv2.PersonDTOV2;
import com.rafaelmourag.rest_with_spring_boot_and_java_erudio.Service.PersonService;


@RestController
@RequestMapping("/person")
public class PersonController {
    

    @Autowired
    private PersonService service;

    @GetMapping(
    produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<PersonDTO> findAll(){
        return service.findAll();
    }

    @GetMapping(value = "/{id}",
    produces = MediaType.APPLICATION_JSON_VALUE
    )
    public PersonDTO findById(@PathVariable("id") Long id){
        return service.findById(id);
    }

    @PostMapping(
    produces = MediaType.APPLICATION_JSON_VALUE,
    consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public PersonDTO create(@RequestBody PersonDTO person){
     
        return service.create(person);
    }
    @PostMapping(
    name = "/v2",
    produces = MediaType.APPLICATION_JSON_VALUE,
    consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public PersonDTOV2 create(@RequestBody PersonDTOV2 person){
        return service.createV2(person);
    }


    @PutMapping(
    produces = MediaType.APPLICATION_JSON_VALUE,
    consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public PersonDTO update(@RequestBody PersonDTO person){
        return service.update(person);
    }

      @DeleteMapping("/{id}")
    public  ResponseEntity<?> delete(@PathVariable("id") Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    
}
