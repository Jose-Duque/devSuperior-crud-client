package com.dvsuperior.dscrudclient.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dvsuperior.dscrudclient.entities.Client;
import com.dvsuperior.dscrudclient.services.ClientService;


@RestController
@RequestMapping(value = "/clients")
public class ClientResource {
	
	@Autowired
	private ClientService service;

	@GetMapping
	public ResponseEntity<Client> findAll(){
		
		List<Client> client = service.findAll();
		return ResponseEntity.of(null).body(client);
	}
}
