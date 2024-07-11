package com.edilson.helpdesk.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edilson.helpdesk.domain.Technician;
import com.edilson.helpdesk.services.TechnicianService;

@RestController
@RequestMapping(value = "/technicians")
public class TechnicianResources {
	
	@Autowired
	private TechnicianService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Technician> findById(@PathVariable Integer id) {
		Technician obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
