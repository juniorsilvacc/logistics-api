package com.juniorsilvacc.logistics.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.juniorsilvacc.logistics.domain.models.Entrega;
import com.juniorsilvacc.logistics.services.SolicitacaoEntregaService;

@RestController
@RequestMapping(value = "/entregas")
public class EntregaController {
	
	@Autowired
	private SolicitacaoEntregaService service;
	
	@PostMapping
	public ResponseEntity<Entrega> request(@RequestBody Entrega entrega) {
		Entrega newRequest = service.request(entrega);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newRequest.getId()).toUri();
		
		return ResponseEntity.created(uri).body(newRequest);
	}
	
	@GetMapping
	public ResponseEntity<List<Entrega>> findAll() {
		List<Entrega> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
	}

}
