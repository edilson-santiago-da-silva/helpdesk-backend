package com.edilson.helpdesk.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edilson.helpdesk.domain.Called;
import com.edilson.helpdesk.domain.Client;
import com.edilson.helpdesk.domain.Technician;
import com.edilson.helpdesk.domain.dtos.CalledDTO;
import com.edilson.helpdesk.domain.enums.Priority;
import com.edilson.helpdesk.domain.enums.Status;
import com.edilson.helpdesk.repositories.CalledRepository;
import com.edilson.helpdesk.services.exceptions.ObjectnotFoundException;

@Service
public class CalledService {

	@Autowired
	private CalledRepository repository;

	@Autowired
	private TechnicianService technicianService;

	@Autowired
	private ClientService clientService;

	public Called findById(Integer id) {
		Optional<Called> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Object not found! ID :" + id));
	}

	public List<Called> findAll() {
		return repository.findAll();
	}

	public Called create(@Valid CalledDTO objDTO) {
		return repository.save(newCalled(objDTO));
	}
	
	public Called update(Integer id, @Valid CalledDTO objDTO) {
		objDTO.setId(id);
		Called oldObj = findById(id);
		oldObj = newCalled(objDTO);
		return repository.save(oldObj);
	}

	private Called newCalled(CalledDTO obj) {
		Technician technician = technicianService.findById(obj.getTechnician());
		Client client = clientService.findById(obj.getClient());

		Called called = new Called();
		if (obj.getId() != null) {
			called.setId(obj.getId());
		}
		
		if (obj.getStatus().equals(2)) {
			called.setClosingDate(LocalDate.now());
		}
		
		called.setTechnician(technician);
		called.setClient(client);
		called.setPriority(Priority.toEnum(obj.getPriority()));
		called.setStatus(Status.toEnum(obj.getStatus()));
		called.setTitle(obj.getTitle());
		called.setComments(obj.getComments());

		return called;
	}
	



}
