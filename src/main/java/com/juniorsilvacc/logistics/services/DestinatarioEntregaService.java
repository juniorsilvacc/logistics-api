package com.juniorsilvacc.logistics.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juniorsilvacc.logistics.domain.dtos.DestinatarioDTO;
import com.juniorsilvacc.logistics.domain.models.Destinatario;
import com.juniorsilvacc.logistics.domain.repositories.DestinatarioRepository;

@Service
public class DestinatarioEntregaService {
	
	@Autowired
	private DestinatarioRepository destinatarioRepository;

	public Destinatario create(DestinatarioDTO destinatario) {
		Destinatario newDestinatario = new Destinatario(destinatario);
		
		return destinatarioRepository.save(newDestinatario);
	}

}
