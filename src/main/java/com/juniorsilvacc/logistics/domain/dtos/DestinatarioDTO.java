package com.juniorsilvacc.logistics.domain.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.juniorsilvacc.logistics.domain.models.Destinatario;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DestinatarioDTO {
	
	private Long id;
	
	@NotBlank(message = "Campo NOME é requerido")
	@Size(max = 60)
	private String nome;
	
	@NotBlank(message = "Campo LOGRADOURO é requerido")
	@Size(max = 60)
	private String logradouro;
	
	@NotBlank(message = "Campo COMPLEMENTO é requerido")
	@Size(max = 60)
	private String complemento;
	
	@NotBlank(message = "Campo NÚMERO é requerido")
	@Size(max = 10)
	private String numero;
	
	@NotBlank(message = "Campo BAIRRO é requerido")
	@Size(max = 30)
	private String bairro;
	
	
	public DestinatarioDTO() {
		super();
	}

	public DestinatarioDTO(Long id, String nome, String logradouro, String complemento, String numero, String bairro) {
		super();
		this.id = id;
		this.nome = nome;
		this.logradouro = logradouro;
		this.complemento = complemento;
		this.numero = numero;
		this.bairro = bairro;
	}
	
	public DestinatarioDTO(Destinatario obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.logradouro = obj.getLogradouro();
		this.complemento = obj.getComplemento();
		this.numero = obj.getNumero();
		this.bairro = obj.getBairro();
	}
	

}
