package com.juniorsilvacc.logistics.domain.models;

import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
@Entity
public class Ocorrencia {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Entrega entrega;
	
	@Column(nullable = false)
	private String descricao;
	
	@JsonProperty(access = Access.READ_ONLY)
	private OffsetDateTime dataRegistro;
	
	public Ocorrencia() {
		super();
	}

	public Ocorrencia(Long id, Entrega entrega, String descricao, OffsetDateTime dataRegistro) {
		super();
		this.id = id;
		this.entrega = entrega;
		this.descricao = descricao;
		this.dataRegistro = dataRegistro;
	}

}
