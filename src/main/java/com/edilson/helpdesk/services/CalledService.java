package com.edilson.helpdesk.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edilson.helpdesk.domain.Called;
import com.edilson.helpdesk.repositories.CalledRepository;
import com.edilson.helpdesk.services.exceptions.ObjectnotFoundException;

@Service
public class CalledService {
		
	@Autowired
	private CalledRepository repository;
	
	public Called findById(Integer id) {
		Optional<Called> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Object not found! ID :" + id));
	}

	public List<Called> findAll() {
		return repository.findAll();
	}
	
}
