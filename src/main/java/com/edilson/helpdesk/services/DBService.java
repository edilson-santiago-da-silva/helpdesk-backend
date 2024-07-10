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

		Client client1 = new Client(null, "Jose Silva", "610.691.880-50", "jose@gmail.com", "123");

		Called called1 = new Called(null, Priority.AVERAGE, Status.PROGRESS, "Called 01", "First called", tech1, client1);

		technicianRepository.saveAll(Arrays.asList(tech1));
		clientRepository.saveAll(Arrays.asList(client1));
		calledRepository.saveAll(Arrays.asList(called1));

	}
}
