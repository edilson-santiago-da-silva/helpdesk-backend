package com.edilson.helpdesk.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edilson.helpdesk.domain.Technician;
import com.edilson.helpdesk.domain.dtos.TechnicianDTO;
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

	public List<Technician> findAll() {
		return repository.findAll();
	}

	public Technician create(TechnicianDTO objDTO) {
		objDTO.setId(null); // adiciona o id nulo no body da requisição para não ter problema com a reescrita de dados. atualizção dos dados indevidamente
		Technician newObj = new Technician(objDTO);
		return repository.save(newObj);
	}
}
