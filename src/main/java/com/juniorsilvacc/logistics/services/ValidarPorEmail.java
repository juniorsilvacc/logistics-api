package com.juniorsilvacc.logistics.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juniorsilvacc.logistics.domain.dtos.ClienteDTO;
import com.juniorsilvacc.logistics.domain.models.Cliente;
import com.juniorsilvacc.logistics.domain.repositories.ClienteRepository;
import com.juniorsilvacc.logistics.services.exceptions.DataIntegrityViolationException;

@Service
public class ValidarPorEmail {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public void validaPorEmail(ClienteDTO cliente) {
		Optional<Cliente> obj = clienteRepository.findByEmail(cliente.getEmail());
		
		if(obj.isPresent() && obj.get().getId() != cliente.getId()) {
			throw new DataIntegrityViolationException("E-mail já cadastrado no sistema");
		}
	}
	
}
