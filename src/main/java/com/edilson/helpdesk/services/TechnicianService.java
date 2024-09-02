package com.edilson.helpdesk.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.edilson.helpdesk.domain.Person;
import com.edilson.helpdesk.domain.Technician;
import com.edilson.helpdesk.domain.dtos.TechnicianDTO;
import com.edilson.helpdesk.repositories.PersonRepository;
import com.edilson.helpdesk.repositories.TechnicianRepository;
import com.edilson.helpdesk.services.exceptions.DataIntegrityViolationException;
import com.edilson.helpdesk.services.exceptions.ObjectnotFoundException;

@Service
public class TechnicianService {

	@Autowired
	private TechnicianRepository repository;

	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;

	public Technician findById(Integer id) {
		Optional<Technician> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("object not found! id " + id));
	}

	public List<Technician> findAll() {
		return repository.findAll();
	}

	public Technician create(TechnicianDTO objDTO) {
		objDTO.setId(null); // adiciona o id nulo no body da requisição para não ter problema com a
							// reescrita de dados.(atualizção dos dados indevidamente)
		objDTO.setPassword(encoder.encode(objDTO.getPassword()));
		validaPorCpfEEmail(objDTO);
		Technician newObj = new Technician(objDTO);
		return repository.save(newObj);
	}

	public Technician update(Integer id, @Valid TechnicianDTO objDTO) {
		objDTO.setId(id);
		Technician oldObj = findById(id);
		
		if(!objDTO.getPassword().equals(oldObj.getPassword()))
			objDTO.setPassword(encoder.encode(objDTO.getPassword()));
		
		validaPorCpfEEmail(objDTO);
		oldObj = new Technician(objDTO);
		return repository.save(oldObj);
	}

	public void delete(Integer id) {
		Technician obj = findById(id);
		if (obj.getCalled().size() > 0) {
			throw new DataIntegrityViolationException("Technician has work orders and cannot be deleted!");
		}
		repository.deleteById(id);
	}

	private void validaPorCpfEEmail(TechnicianDTO objDTO) {
		Optional<Person> obj = personRepository.findByCpf(objDTO.getCpf());
		if (obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("CPF already registered in the system!");
		}

		obj = personRepository.findByEmail(objDTO.getEmail());
		if (obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("E-mail already registered in the system!");
		}
	}

}
