package com.edilson.helpdesk.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edilson.helpdesk.domain.Technician;
import com.edilson.helpdesk.domain.dtos.TechnicianDTO;
import com.edilson.helpdesk.services.TechnicianService;

@RestController
@RequestMapping(value = "/technicians")
public class TechnicianResources {
	
	@Autowired
	private TechnicianService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<TechnicianDTO> findById(@PathVariable Integer id) {
		Technician obj = service.findById(id);
		return ResponseEntity.ok().body(new TechnicianDTO(obj));
	}
	
	@GetMapping
	public ResponseEntity<List<TechnicianDTO>> findAll(){
		List<Technician> list = service.findAll();
		List<TechnicianDTO> listDTO = list.stream().map(obj -> new TechnicianDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
}
