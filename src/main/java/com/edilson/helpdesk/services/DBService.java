package com.edilson.helpdesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edilson.helpdesk.domain.Called;
import com.edilson.helpdesk.domain.Client;
import com.edilson.helpdesk.domain.Technician;
import com.edilson.helpdesk.domain.enums.Priority;
import com.edilson.helpdesk.domain.enums.Profile;
import com.edilson.helpdesk.domain.enums.Status;
import com.edilson.helpdesk.repositories.CalledRepository;
import com.edilson.helpdesk.repositories.ClientRepository;
import com.edilson.helpdesk.repositories.TechnicianRepository;

@Service
public class DBService {

	@Autowired
	private TechnicianRepository technicianRepository;

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private CalledRepository calledRepository;

	public void instanceDB() {
		Technician tech1 = new Technician(null, "Edilson Santiago", "064.007.370-06", "edilson@gmail.com", "123");
		tech1.addProfile(Profile.ADMIN);
		Technician tech2 = new Technician(null, "Richard Stallman", "903.347.070-56", "stallman@mail.com", "123");
		Technician tech3 = new Technician(null, "Claude Elwood Shannon", "271.068.470-54", "shannon@mail.com", "123");
		Technician tech4 = new Technician(null, "Tim Berners-Lee", "162.720.120-39", "lee@mail.com", "123");
		Technician tech5 = new Technician(null, "Linus Torvalds", "778.556.170-27", "linus@mail.com", "123");

		Client client1 = new Client(null, "Jose Silva", "610.691.880-50", "jose@gmail.com", "123");
		Client client2 = new Client(null, "Marie Curie", "322.429.140-06", "curie@mail.com", "123");
		Client client3 = new Client(null, "Charles Darwin", "792.043.830-62", "darwin@mail.com", "123");
		Client client4 = new Client(null, "Stephen Hawking", "177.409.680-30", "hawking@mail.com", "123");
		Client client5 = new Client(null, "Max Planck", "081.399.300-83", "planck@mail.com", "123");

		Called called1 = new Called(null, Priority.AVERAGE, Status.PROGRESS, "Called 01", "First called", tech1, client1);
		Called called2 = new Called(null, Priority.HIGH, Status.OPEN, "Chamado 2", "Teste chamado 2", tech1, client2);
		Called called3 = new Called(null, Priority.LOW, Status.CLOSED, "Chamado 3", "Teste chamado 3", tech2, client3);
		Called called4 = new Called(null, Priority.HIGH, Status.OPEN, "Chamado 4", "Teste chamado 4", tech3, client3);
		Called called5 = new Called(null, Priority.AVERAGE, Status.PROGRESS, "Chamado 5", "Teste chamado 5", tech2, client1);
		Called called6 = new Called(null, Priority.LOW, Status.CLOSED, "Chamado 7", "Teste chamado 6", tech1, client5);

		technicianRepository.saveAll(Arrays.asList(tech1, tech2, tech3, tech4, tech5));
		clientRepository.saveAll(Arrays.asList(client1, client2, client3, client4, client5));
		calledRepository.saveAll(Arrays.asList(called1, called2, called3, called4, called5, called6));

	}
}
