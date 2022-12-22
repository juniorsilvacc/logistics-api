package com.juniorsilvacc.logistics.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.juniorsilvacc.logistics.domain.models.Entrega;
import com.juniorsilvacc.logistics.domain.models.Ocorrencia;
import com.juniorsilvacc.logistics.domain.repositories.OcorrenciaRepository;

@Service
public class RegistroOcorrenciaService {
	
	@Autowired
	private OcorrenciaRepository ocorrenciaRepository;
	
	@Autowired
	private BuscaEntregaService buscaEntregaService;
	
	@Transactional
	public Ocorrencia register(String descricao, Long id) {
		Entrega entrega = buscaEntregaService.buscar(id);
				
		
		return entrega.addOcorrenciaDescricao(descricao);
	}

	public List<Ocorrencia> findAll() {
		return ocorrenciaRepository.findAll();
	}
}
