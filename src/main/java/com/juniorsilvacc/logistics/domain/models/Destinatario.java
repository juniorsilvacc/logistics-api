package com.juniorsilvacc.logistics.domain.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.juniorsilvacc.logistics.domain.dtos.DestinatarioDTO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
@Entity
public class Destinatario {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String logradouro;
	
	@Column(nullable = false)
	private String numero;
	
	@Column(nullable = false)
	private String complemento;
	
	@Column(nullable = false)
	private String bairro;
	
	
	public Destinatario() {
		super();
	}

	public Destinatario(Long id, String nome, String logradouro, String numero, String complemento, String bairro) {
		super();
		this.id = id;
		this.nome = nome;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
	}
	
	public Destinatario(DestinatarioDTO obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.logradouro = obj.getLogradouro();
		this.numero = obj.getNumero();
		this.complemento = obj.getComplemento();
		this.bairro = obj.getBairro();
	}

}
