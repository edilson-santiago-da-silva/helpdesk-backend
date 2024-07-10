package com.edilson.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edilson.helpdesk.domain.Client;

public interface ClientRepository extends JpaRepository<Client, Integer>{

}
