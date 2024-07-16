package com.edilson.helpdesk.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edilson.helpdesk.domain.Called;
import com.edilson.helpdesk.domain.dtos.CalledDTO;
import com.edilson.helpdesk.services.CalledService;

@RestController
@RequestMapping(value = "calleds")
public class CalledResource {
	
	@Autowired
	private CalledService service;
	

	@GetMapping(value = "/{id}")
	public ResponseEntity<CalledDTO> findById(@PathVariable Integer id){
		Called obj = service.findById(id);
		return ResponseEntity.ok().body(new CalledDTO(obj));
	}
	
	@GetMapping
	public ResponseEntity<List<CalledDTO>> FindAll(){
		List<Called> list = service.findAll();
		List<CalledDTO> listDTO = list.stream().map(obj -> new CalledDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);	
	}
	
}