package com.rafaelmourag.rest_with_spring_boot_and_java_erudio.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.rafaelmourag.rest_with_spring_boot_and_java_erudio.DTO.PersonDTO;
import com.rafaelmourag.rest_with_spring_boot_and_java_erudio.DTOv2.PersonDTOV2;
import com.rafaelmourag.rest_with_spring_boot_and_java_erudio.Exception.ResourceNotFoundException;
import com.rafaelmourag.rest_with_spring_boot_and_java_erudio.Model.Person;
import com.rafaelmourag.rest_with_spring_boot_and_java_erudio.Repository.PersonRepository;
import com.rafaelmourag.rest_with_spring_boot_and_java_erudio.mapper.ObjectMapper;
import com.rafaelmourag.rest_with_spring_boot_and_java_erudio.mapper.custom.PersonMapper;

@Service
public class PersonService {// aqui que se procura no banco de dados
    
    
    @SuppressWarnings("unused")
    private final AtomicLong counter = new AtomicLong();
    private Logger logger = LoggerFactory.getLogger(PersonService.class.getName());

    @Autowired
    PersonRepository repository;
    @Autowired
    PersonMapper converter;
    


    public PersonDTO findById(Long id) {
        logger.info("Finding one person!");

       var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
       return ObjectMapper.parseObject(entity, PersonDTO.class);
    }

    public List<PersonDTO> findAll(){
        logger.info("Finding all people!");
        
        return ObjectMapper.parseListObjects(repository.findAll(), PersonDTO.class);
    }

    public PersonDTO create(PersonDTO person){
        logger.info("Creating one Person!");

        var entity = ObjectMapper.parseObject(person, Person.class);
        return ObjectMapper.parseObject(repository.save(entity), PersonDTO.class);
    }

    public PersonDTOV2 createV2(PersonDTOV2 person){
        logger.info("Creating one Person V2!");

        var entity = converter.convertDTOtoEntity(person);

        return converter.convertEntityToDTO(repository.save(entity));
    }

    public PersonDTO update(PersonDTO person){
        logger.info("Updating one person!");
        Person entity =  repository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
    
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return ObjectMapper.parseObject(repository.save(entity), PersonDTO.class);
    }

    public void delete(Long id){
        logger.info("Deleting one person");

         Person entity =  repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        repository.delete(entity);
    }

    
}
