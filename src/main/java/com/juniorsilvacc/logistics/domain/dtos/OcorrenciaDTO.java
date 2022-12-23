package com.juniorsilvacc.logistics.domain.dtos;

import java.time.OffsetDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.juniorsilvacc.logistics.domain.models.Ocorrencia;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OcorrenciaDTO {
	
	private Long id;
	
	@NotBlank(message = "Campo DESCRICÃO é requerido")
	@Size(max = 100)
	private String descricao;
	
	private OffsetDateTime dataRegistro;

	public OcorrenciaDTO() {
	}

	public OcorrenciaDTO(Ocorrencia obj) {
		this.id = obj.getId();
		this.descricao = obj.getDescricao();
		this.dataRegistro = obj.getDataRegistro();
	}
	
}
