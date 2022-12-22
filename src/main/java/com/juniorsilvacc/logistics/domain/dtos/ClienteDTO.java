package com.juniorsilvacc.logistics.domain.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.juniorsilvacc.logistics.domain.models.Cliente;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteDTO {
	
	private Long id;
	
	@NotBlank(message = "Campo NOME é requerido")
	@Size(max = 60)
	private String nome;
	
	@NotBlank (message = "Campo E-MAIL é requerido")
	@Email
	@Size(max = 255)
	private String email;
	
	@NotBlank(message = "Campo TELEFONE é requerido")
	@Size(max = 20)
	private String telefone;
	
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

}
