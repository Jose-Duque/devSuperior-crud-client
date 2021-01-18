package com.dvsuperior.dscrudclient.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dvsuperior.dscrudclient.dto.ClientDTO;
import com.dvsuperior.dscrudclient.entities.Client;
import com.dvsuperior.dscrudclient.repositories.ClientRepository;
import com.dvsuperior.dscrudclient.services.exceptions.ResourceNotFoundException;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;
	
	@Transactional(readOnly = true)
	public Page<ClientDTO> findAllPage(PageRequest pageRequest) {
		
		Page<Client> list = repository.findAll(pageRequest);
		return list.map(x -> new ClientDTO(x)) ;
	}

	@Transactional(readOnly = true)
	public ClientDTO findById(Long id) {
		Optional<Client> obj = repository.findById(id);
		Client entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entidade não encontrada"));
		return new ClientDTO(entity);
	}
	
}
		
