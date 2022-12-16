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
		Optional<Cliente> obj = repository.findById(id); 
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(String.format("Cliente com id %d não encontrado", id)));
	}

	public Cliente create(ClienteDTO objDTO) {
		objDTO.setId(null);
		
		validaPorEmail(objDTO);
		
		Cliente newObj = new Cliente(objDTO);
		return repository.save(newObj);
	}
	
	public Cliente update(Long id, ClienteDTO objDTO) {
		objDTO.setId(id);
		
		Cliente oldObj = findById(id);
		validaPorEmail(objDTO);
		
		oldObj = new Cliente(objDTO);
		
		return repository.save(oldObj);
	}
	
	public void delete(Long id) {
		Cliente obj = findById(id);
		
		if(obj.getId() == 0) {
			throw new ObjectNotFoundException(String.format("Cliente com id %d não encontrado", id));
		}
		
		repository.delete(obj);
	}

	private void validaPorEmail(ClienteDTO objDTO) {
		Optional<Cliente> obj = repository.findByEmail(objDTO.getEmail());
		
		if(obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("E-mail já cadastrado no sistema");
		}
	}

}
