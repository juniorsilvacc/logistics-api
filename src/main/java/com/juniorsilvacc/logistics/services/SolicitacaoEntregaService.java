package com.juniorsilvacc.logistics.services;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juniorsilvacc.logistics.domain.dtos.EntregaDTO;
import com.juniorsilvacc.logistics.domain.models.Cliente;
import com.juniorsilvacc.logistics.domain.models.Entrega;
import com.juniorsilvacc.logistics.domain.models.enums.StatusEntrega;
import com.juniorsilvacc.logistics.domain.repositories.ClienteRepository;
import com.juniorsilvacc.logistics.domain.repositories.EntregaRepository;
import com.juniorsilvacc.logistics.services.exceptions.DataIntegrityViolationException;
import com.juniorsilvacc.logistics.services.exceptions.ObjectNotFoundException;

@Service
public class SolicitacaoEntregaService {
	
	@Autowired
	private EntregaRepository entregaRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public Entrega request (EntregaDTO entrega) {
		entrega.setId(null);
		buscaCliente(entrega);
		
		entrega.setStatusEntrega(StatusEntrega.PENDENTE);
		entrega.setDataPedido(OffsetDateTime.now());
		
		Entrega newEntrega = new Entrega(entrega);
		return entregaRepository.save(newEntrega);
	}
	
	public List<Entrega> findAll() {
		return entregaRepository.findAll();
	}
	
	public Entrega findById(Long id) {
		Optional<Entrega> entrega = entregaRepository.findById(id); 
		
		return entrega.orElseThrow(() -> new ObjectNotFoundException(String.format("Entrega com id %d não encontrado", id)));
	}
	
	private void buscaCliente(EntregaDTO entrega) {
		Long clienteId = entrega.getCliente().getId();
		Optional<Cliente> cliente = clienteRepository.findById(clienteId);
		
		if(!cliente.isPresent()) {
			throw new DataIntegrityViolationException(String.format("Cliente com id %d não encontrado", clienteId));
		}
	}

}
