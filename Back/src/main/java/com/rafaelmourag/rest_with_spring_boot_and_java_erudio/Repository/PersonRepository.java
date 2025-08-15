package com.rafaelmourag.rest_with_spring_boot_and_java_erudio.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rafaelmourag.rest_with_spring_boot_and_java_erudio.Model.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{
    
}
