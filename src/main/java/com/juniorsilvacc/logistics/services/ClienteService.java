package com.juniorsilvacc.logistics.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juniorsilvacc.logistics.domain.dtos.ClienteDTO;
import com.juniorsilvacc.logistics.domain.model.Cliente;
import com.juniorsilvacc.logistics.domain.repositories.ClienteRepository;
import com.juniorsilvacc.logistics.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repository;

	public List<Cliente> findAll() {
		return repository.findAll();
	}

	public Cliente findById(Long id) {
		Optional<Cliente> obj = repository.findById(id); 
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(String.format("Cliente do id %d não encontrado", id)));
	}

	public Cliente create(ClienteDTO objDTO) {
		objDTO.setId(null);
		Cliente newObj = new Cliente(objDTO);
		return repository.save(newObj);
	}

}
