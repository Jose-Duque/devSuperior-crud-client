package com.dvsuperior.dscrudclient.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dvsuperior.dscrudclient.entities.Client;
import com.dvsuperior.dscrudclient.repositories.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;
	public List<Client> findAll() {
		return repository.findAll();
	}
	
}
		
