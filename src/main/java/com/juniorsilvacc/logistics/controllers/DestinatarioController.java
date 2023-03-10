package com.juniorsilvacc.logistics.controllers;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.juniorsilvacc.logistics.domain.dtos.DestinatarioDTO;
import com.juniorsilvacc.logistics.domain.models.Destinatario;
import com.juniorsilvacc.logistics.services.DestinatarioEntregaService;

@RestController
@RequestMapping("/destinatarios")
public class DestinatarioController {
	
	@Autowired
	private DestinatarioEntregaService destinatarioEntregaService;
	
	@PostMapping
	public ResponseEntity<DestinatarioDTO> create(@Valid @RequestBody DestinatarioDTO destinatario) {
		Destinatario newObj = destinatarioEntregaService.create(destinatario);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
				
		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<DestinatarioDTO> findById(@PathVariable Long id) {
		Destinatario obj = destinatarioEntregaService.findById(id);
		
		return ResponseEntity.ok().body(new DestinatarioDTO(obj));
	}
	
	@DeleteMapping(value = "{id}")
	public ResponseEntity<Void> deleta(@PathVariable Long id) {
		destinatarioEntregaService.delete(id);
		
		return ResponseEntity.noContent().build();
	}

}
