package com.juniorsilvacc.logistics.domain.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.juniorsilvacc.logistics.domain.models.Cliente;

public class ClienteDTO {
	
	protected Long id;
	
	@NotBlank(message = "Campo NOME é requerido")
	@Size(max = 60)
	protected String nome;
	
	@NotBlank (message = "Campo E-MAIL é requerido")
	@Email
	@Size(max = 255)
	protected String email;
	
	@NotBlank(message = "Campo TELEFONE é requerido")
	@Size(max = 20)
	protected String telefone;
	
	public ClienteDTO() {
		super();
	}

	public ClienteDTO(Cliente obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.email = obj.getEmail();
		this.telefone = obj.getTelefone();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
}
