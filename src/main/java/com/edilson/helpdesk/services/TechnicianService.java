package com.edilson.helpdesk.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edilson.helpdesk.domain.Technician;
import com.edilson.helpdesk.repositories.TechnicianRepository;
import com.edilson.helpdesk.services.exceptions.ObjectnotFoundException;

@Service
public class TechnicianService {

	@Autowired
	private TechnicianRepository repository;
	
	public Technician findById(Integer id) {
		Optional<Technician> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("object not found! id " + id ));
	}
}
