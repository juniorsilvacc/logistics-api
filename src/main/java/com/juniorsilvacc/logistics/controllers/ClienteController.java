package com.juniorsilvacc.logistics.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juniorsilvacc.logistics.domain.model.Cliente;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

	@GetMapping
	public List<Cliente> findAll() {
		Cliente cliente1 = new Cliente();
		cliente1.setId(1L);
		cliente1.setNome("Junior");
		cliente1.setEmail("junior@hotmail.com");
		cliente1.setTelefone("83981321325");
		
		Cliente cliente2 = new Cliente();
		cliente2.setId(1L);
		cliente2.setNome("Leontina");          
		cliente2.setEmail("leontina@hotmail.com");
		cliente2.setTelefone("8398133224433");
		
		return Arrays.asList(cliente1, cliente2);
	}
	
}