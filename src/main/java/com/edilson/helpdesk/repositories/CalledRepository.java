package com.edilson.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edilson.helpdesk.domain.Called;

public interface CalledRepository extends JpaRepository<Called, Integer>{

}
