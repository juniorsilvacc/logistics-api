package com.juniorsilvacc.logistics.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juniorsilvacc.logistics.domain.dtos.ClienteDTO;
import com.juniorsilvacc.logistics.domain.models.Cliente;
import com.juniorsilvacc.logistics.domain.repositories.ClienteRepository;
import com.juniorsilvacc.logistics.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ValidarPorEmail validarPorEmailService;

	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}

	public Cliente findById(Long id) {
		Optional<Cliente> cliente = clienteRepository.findById(id); 
		
		return cliente.orElseThrow(() -> new ObjectNotFoundException(String.format("Cliente com id %d não encontrado", id)));
	}

	public Cliente create(ClienteDTO cliente) {
		cliente.setId(null);
		
		validarPorEmailService.validaPorEmail(cliente);
		
		Cliente newCliente = new Cliente(cliente);
		return clienteRepository.save(newCliente);
	}
	
	public Cliente update(Long id, ClienteDTO cliente) {
		cliente.setId(id);
		
		Cliente oldCliente = findById(id);
		validarPorEmailService.validaPorEmail(cliente);
		
		oldCliente = new Cliente(cliente);
		
		return clienteRepository.save(oldCliente);
	}
	
	public void delete(Long id) {
		Cliente cliente = findById(id);
		
		if(cliente.getId() == 0) {
			throw new ObjectNotFoundException(String.format("Cliente com id %d não encontrado", id));
		}
		 
		clienteRepository.delete(cliente);
	}

	

}
