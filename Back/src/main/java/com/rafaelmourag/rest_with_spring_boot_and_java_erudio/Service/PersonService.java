package com.rafaelmourag.rest_with_spring_boot_and_java_erudio.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafaelmourag.rest_with_spring_boot_and_java_erudio.Exception.ResourceNotFoundException;
import com.rafaelmourag.rest_with_spring_boot_and_java_erudio.Model.Person;
import com.rafaelmourag.rest_with_spring_boot_and_java_erudio.Repository.PersonRepository;

@Service
public class PersonService {// aqui que se procura no banco de dados
    
    
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    PersonRepository repository;

    private Logger logger = LoggerFactory.getLogger(PersonService.class.getName());


    public Person findById(Long id) {
        logger.info("Finding one person!");

       return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
    }

    public List<Person> findAll(){
        logger.info("Finding all people!");
        
        return repository.findAll();
    }

    public Person create(Person person){
        logger.info("Creating one Person!");
        return repository.save(person);
    }

    public Person update(Person person){
        logger.info("Updating one person!");
        Person entity =  repository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
    
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        return repository.save(person);
    }

    public void delete(Long id){
        logger.info("Deleting one person");

         Person entity =  repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        repository.delete(entity);
    }

    
}
