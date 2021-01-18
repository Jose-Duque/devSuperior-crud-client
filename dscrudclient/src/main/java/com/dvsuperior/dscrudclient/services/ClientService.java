package com.dvsuperior.dscrudclient.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dvsuperior.dscrudclient.entities.Client;
import com.dvsuperior.dscrudclient.repositories.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;
	
	@Transactional(readOnly = true)
	public Page<Client> findAllPage(PageRequest pageRequest) {
		
		Page<Client> list = repository.findAll(pageRequest);
		return list;
	}

	@Transactional(readOnly = true)
	public Optional<Client> findById(Long id) {
		Optional<Client> client = repository.findById(id);
		return client;
	}
	
}
		
