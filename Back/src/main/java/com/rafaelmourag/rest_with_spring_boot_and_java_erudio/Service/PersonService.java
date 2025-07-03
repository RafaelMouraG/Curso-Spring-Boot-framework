package com.rafaelmourag.rest_with_spring_boot_and_java_erudio.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.rafaelmourag.rest_with_spring_boot_and_java_erudio.Model.Person;

@Service
public class PersonService {// aqui que se procura no banco de dados
    
    
    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonService.class.getName());


    public Person findById(String id) {
        logger.info("Finding one person!");

        //mock
        Person person=new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Rafael");
        person.setLastName("Moura");
        person.setAddress("BH");
        person.setGender("Male");
        return person;
    }

    public List<Person> findAll(){
        List<Person> people= new ArrayList<Person>();
        for (int i = 0; i < 8; i++) {
            Person person = mockPerson(i);
            people.add(person);
        }

        return people;
    }

    private Person mockPerson(int i) {
       Person person=new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Firstname"+i);
        person.setLastName("Lastname"+i);
        person.setAddress("Chinatown"+i);
        person.setGender("Male");
        return person;
    }
}
