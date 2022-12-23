package com.juniorsilvacc.logistics.domain.dtos;

import javax.validation.constraints.NotEmpty;

import com.juniorsilvacc.logistics.domain.models.Destinatario;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DestinatarioDTO {
	
	@NotEmpty(message = "Campo NOME é requerido")
	private String nome;
	
	@NotEmpty(message = "Campo LOGRADOURO é requerido")
	private String logradouro;
	
	@NotEmpty(message = "Campo COMPLEMENTO é requerido")
	private String complemento;
	
	@NotEmpty(message = "Campo NUMERO é requerido")
	private String numero;
	
	@NotEmpty(message = "Campo BAIRRO é requerido")
	private String bairro;
	
	public DestinatarioDTO() {
		super();
	}

	public DestinatarioDTO(String nome, String logradouro, String complemento, String numero, String bairro) {
		super();
		this.nome = nome;
		this.logradouro = logradouro;
		this.complemento = complemento;
		this.numero = numero;
		this.bairro = bairro;
	}
	
	public DestinatarioDTO(Destinatario obj) {
		super();
		this.nome = obj.getNome();
		this.logradouro = obj.getLogradouro();
		this.complemento = obj.getComplemento();
		this.numero = obj.getNumero();
		this.bairro = obj.getBairro();
	}
	

}
