package com.juniorsilvacc.logistics.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juniorsilvacc.logistics.domain.models.Entrega;
import com.juniorsilvacc.logistics.domain.repositories.EntregaRepository;
import com.juniorsilvacc.logistics.services.exceptions.ObjectNotFoundException;

@Service
public class BuscaEntregaService {
	
	@Autowired
	private EntregaRepository entregaRepository;
	
	public Entrega buscar(Long id) {
		return entregaRepository.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException(String.format("Entrega com id %d não encontrado", id)));
		
	}

}
