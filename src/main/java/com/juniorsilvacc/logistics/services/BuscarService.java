package com.juniorsilvacc.logistics.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juniorsilvacc.logistics.domain.models.Destinatario;
import com.juniorsilvacc.logistics.domain.models.Entrega;
import com.juniorsilvacc.logistics.domain.repositories.DestinatarioRepository;
import com.juniorsilvacc.logistics.domain.repositories.EntregaRepository;
import com.juniorsilvacc.logistics.services.exceptions.ObjectNotFoundException;

@Service
public class BuscarService {
	
	@Autowired
	private EntregaRepository entregaRepository;
	
	@Autowired
	private DestinatarioRepository destinatarioRepository;
	
	public Entrega buscarEntrega(Long id) {
		return entregaRepository.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException(String.format("Entrega com id %d não encontrado", id)));
	}
	
	public Destinatario buscarDestinatario(Long id) {
		Optional<Destinatario> obj = destinatarioRepository.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(String.format("Cliente com id %d não encontrado", id)));
	}

}
