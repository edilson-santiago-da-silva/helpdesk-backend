package com.edilson.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edilson.helpdesk.domain.Person;

public interface PersonRepository extends JpaRepository<Person, Integer>{

}
