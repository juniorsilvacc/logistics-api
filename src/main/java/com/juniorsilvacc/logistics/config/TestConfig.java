package com.juniorsilvacc.logistics.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.juniorsilvacc.logistics.domain.models.Cliente;
import com.juniorsilvacc.logistics.domain.repositories.ClienteRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public void run(String... args) throws Exception {
	
		Cliente c1 = new Cliente(null, "Junior", "junior@hotmail.com", "83988992233");
		Cliente c2 = new Cliente(null, "José", "jose@hotmail.com", "83977883322");
		Cliente c3 = new Cliente(null, "Davi", "davi@hotmail.com", "83999883322");
		
		clienteRepository.saveAll(Arrays.asList(c1, c2, c3));
	}

}
