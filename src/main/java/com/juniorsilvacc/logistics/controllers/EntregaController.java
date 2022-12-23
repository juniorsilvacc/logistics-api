package com.juniorsilvacc.logistics.controllers;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.juniorsilvacc.logistics.domain.dtos.EntregaDTO;
import com.juniorsilvacc.logistics.domain.models.Entrega;
import com.juniorsilvacc.logistics.services.FinalizacaoEntregaService;
import com.juniorsilvacc.logistics.services.SolicitacaoEntregaService;

@RestController
@RequestMapping(value = "/entregas")
public class EntregaController {
	
	@Autowired
	private SolicitacaoEntregaService service;
	
	@Autowired
	private FinalizacaoEntregaService finalizacaoEntregaService;
	
	@PostMapping
	public ResponseEntity<EntregaDTO> request(@Valid @RequestBody EntregaDTO entrega) {
		Entrega newRequest = service.request(entrega);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newRequest.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new EntregaDTO(newRequest));
	}
	
	@GetMapping
	public ResponseEntity<List<Entrega>> findAll() {
		List<Entrega> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Entrega> findById(@PathVariable Long id) {
		Entrega obj = service.findById(id);
		
		return ResponseEntity.ok().body(obj);
	}
	
	@PutMapping(value = "/{id}/finalizacao")
	public ResponseEntity<Void> finaliza(@PathVariable Long id){
		finalizacaoEntregaService.finalize(id);
		
		return ResponseEntity.noContent().build();
	}
}
