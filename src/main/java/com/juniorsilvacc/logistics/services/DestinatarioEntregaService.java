package com.juniorsilvacc.logistics.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juniorsilvacc.logistics.domain.dtos.DestinatarioDTO;
import com.juniorsilvacc.logistics.domain.models.Destinatario;
import com.juniorsilvacc.logistics.domain.repositories.DestinatarioRepository;
import com.juniorsilvacc.logistics.services.exceptions.ObjectNotFoundException;

@Service
public class DestinatarioEntregaService {
	
	@Autowired
	private DestinatarioRepository destinatarioRepository;
	
	@Autowired
	private BuscarService buscarService;

	public Destinatario create(DestinatarioDTO destinatario) {
		Destinatario newDestinatario = new Destinatario(destinatario);
		
		return destinatarioRepository.save(newDestinatario);
	}

	public Destinatario findById(Long id) {
		return buscarService.buscarDestinatario(id);
	}

	public void delete(Long id) {
		Destinatario destinatarioId = buscarService.buscarDestinatario(id);
		
		if(destinatarioId.getId() == 0) {
			throw new ObjectNotFoundException(String.format("Destinatário com id %d não encontrado", id));
		}
		
		destinatarioRepository.delete(destinatarioId);
		
	}

}
