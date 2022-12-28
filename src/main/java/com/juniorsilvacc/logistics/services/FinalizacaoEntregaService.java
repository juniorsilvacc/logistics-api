package com.juniorsilvacc.logistics.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.juniorsilvacc.logistics.domain.models.Entrega;
import com.juniorsilvacc.logistics.domain.repositories.EntregaRepository;

@Service
public class FinalizacaoEntregaService {
	
	@Autowired
	private EntregaRepository entregaRepository;
	
	@Autowired
	private BuscarService buscaEntregaService;
	
	@Transactional
	public void finalize (Long id) {
		Entrega entrega = buscaEntregaService.buscar(id);
		
		entrega.finalizar();
		
		entregaRepository.save(entrega);
	}

}
