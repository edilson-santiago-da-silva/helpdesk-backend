package com.edilson.helpdesk;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.edilson.helpdesk.domain.Called;
import com.edilson.helpdesk.domain.Client;
import com.edilson.helpdesk.domain.Technician;
import com.edilson.helpdesk.domain.enums.Priority;
import com.edilson.helpdesk.domain.enums.Profile;
import com.edilson.helpdesk.domain.enums.Status;
import com.edilson.helpdesk.repositories.CalledRepository;
import com.edilson.helpdesk.repositories.ClientRepository;
import com.edilson.helpdesk.repositories.TechnicianRepository;

@SpringBootApplication
public class HelpdeskApplication implements CommandLineRunner {
	
	@Autowired
	private TechnicianRepository technicianRepository;
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private CalledRepository calledRepository;

	public static void main(String[] args) {
		SpringApplication.run(HelpdeskApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Technician tech1 = new Technician(null, "Edilson Santiago" , "064.007.370-06", "edilson@gmail.com", "123");
		tech1.addProfile(Profile.ADMIN);
		
		Client client1 = new Client(null, "Jose Silva" , "610.691.880-50", "jose@gmail.com", "123");
		
		Called called1 = new Called(null, Priority.AVERAGE, Status.PROGRESS, "Called 01", "First called", tech1, client1);
		
		technicianRepository.saveAll(Arrays.asList(tech1));
		clientRepository.saveAll(Arrays.asList(client1));
		calledRepository.saveAll(Arrays.asList(called1));
		
	}

}
