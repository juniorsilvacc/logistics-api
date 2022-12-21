package com.juniorsilvacc.logistics.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juniorsilvacc.logistics.domain.dtos.ClienteDTO;
import com.juniorsilvacc.logistics.domain.models.Cliente;
import com.juniorsilvacc.logistics.domain.repositories.ClienteRepository;
import com.juniorsilvacc.logistics.services.exceptions.DataIntegrityViolationException;
import com.juniorsilvacc.logistics.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repository;

	public List<Cliente> findAll() {
		return repository.findAll();
	}

	public Cliente findById(Long id) {
		Optional<Cliente> cliente = repository.findById(id); 
		
		return cliente.orElseThrow(() -> new ObjectNotFoundException(String.format("Cliente com id %d não encontrado", id)));
	}

	public Cliente create(ClienteDTO cliente) {
		cliente.setId(null);
		
		validaPorEmail(cliente);
		
		Cliente newCliente = new Cliente(cliente);
		return repository.save(newCliente);
	}
	
	public Cliente update(Long id, ClienteDTO cliente) {
		cliente.setId(id);
		
		Cliente oldCliente = findById(id);
		validaPorEmail(cliente);
		
		oldCliente = new Cliente(cliente);
		
		return repository.save(oldCliente);
	}
	
	public void delete(Long id) {
		Cliente cliente = findById(id);
		
		if(cliente.getId() == 0) {
			throw new ObjectNotFoundException(String.format("Cliente com id %d não encontrado", id));
		}
		 
		repository.delete(cliente);
	}

	private void validaPorEmail(ClienteDTO cliente) {
		Optional<Cliente> obj = repository.findByEmail(cliente.getEmail());
		
		if(obj.isPresent() && obj.get().getId() != cliente.getId()) {
			throw new DataIntegrityViolationException("E-mail já cadastrado no sistema");
		}
	}

}
