package com.edilson.helpdesk.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.edilson.helpdesk.domain.Client;
import com.edilson.helpdesk.domain.Person;
import com.edilson.helpdesk.domain.dtos.ClientDTO;
import com.edilson.helpdesk.repositories.ClientRepository;
import com.edilson.helpdesk.repositories.PersonRepository;
import com.edilson.helpdesk.services.exceptions.DataIntegrityViolationException;
import com.edilson.helpdesk.services.exceptions.ObjectnotFoundException;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;

	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;

	public Client findById(Integer id) {
		Optional<Client> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("object not found! id " + id));
	}

	public List<Client> findAll() {
		return repository.findAll();
	}

	public Client create(ClientDTO objDTO) {
		objDTO.setId(null); // adiciona o id nulo no body da requisição para não ter problema com a
							// reescrita de dados.(atualizção dos dados indevidamente)
		objDTO.setPassword(encoder.encode(objDTO.getPassword()));
		validaPorCpfEEmail(objDTO);
		Client newObj = new Client(objDTO);
		return repository.save(newObj);
	}

	public Client update(Integer id, @Valid ClientDTO objDTO) {
		objDTO.setId(id);
		Client oldObj = findById(id);
		
		if(!objDTO.getPassword().equals(oldObj.getPassword()))
			objDTO.setPassword(encoder.encode(objDTO.getPassword()));
		
		validaPorCpfEEmail(objDTO);
		oldObj = new Client(objDTO);
		return repository.save(oldObj);
	}

	public void delete(Integer id) {
		Client obj = findById(id);
		if (obj.getCalled().size() > 0) {
			throw new DataIntegrityViolationException("Client has work orders and cannot be deleted!");
		}
		repository.deleteById(id);
	}

	private void validaPorCpfEEmail(ClientDTO objDTO) {
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
