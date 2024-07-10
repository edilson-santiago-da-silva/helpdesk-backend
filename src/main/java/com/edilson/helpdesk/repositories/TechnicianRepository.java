package com.edilson.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edilson.helpdesk.domain.Technician;

public interface TechnicianRepository extends JpaRepository<Technician, Integer>{

}
