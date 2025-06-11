package com.rafaelmourag.rest_with_spring_boot_and_java_erudio.Service;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

@Service
public class PersonService {
    
    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonService.class.getName());
}
