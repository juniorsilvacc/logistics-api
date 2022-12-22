package com.juniorsilvacc.logistics.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.juniorsilvacc.logistics.domain.models.Entrega;
import com.juniorsilvacc.logistics.domain.models.Ocorrencia;

@Service
public class RegistroOcorrenciaService {
	
	@Autowired
	private BuscaEntregaService buscaEntregaService;
	
	@Transactional
	public Ocorrencia register(String descricao, Long id) {
		Entrega entrega = buscaEntregaService.buscar(id);
				
		
		return entrega.addOcorrenciaDescricao(descricao);
	}
}
