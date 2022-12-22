package com.juniorsilvacc.logistics.controllers;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.juniorsilvacc.logistics.domain.dtos.OcorrenciaDTO;
import com.juniorsilvacc.logistics.domain.models.Ocorrencia;
import com.juniorsilvacc.logistics.services.RegistroOcorrenciaService;

@RestController
@RequestMapping(value = "/entregas/{id}/ocorrencias")
public class OcorrenciaController {
	
	@Autowired
	private RegistroOcorrenciaService registroOcorrenciaService;
	
	@PostMapping
	public ResponseEntity<OcorrenciaDTO> register(@Valid @RequestBody OcorrenciaDTO ocorrencia, @PathVariable Long id) {
		Ocorrencia newOcorrencia = registroOcorrenciaService.register(ocorrencia.getDescricao(), id);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newOcorrencia.getId()).toUri();
		 
		return ResponseEntity.created(uri).body(new OcorrenciaDTO(newOcorrencia));
	} 

}
