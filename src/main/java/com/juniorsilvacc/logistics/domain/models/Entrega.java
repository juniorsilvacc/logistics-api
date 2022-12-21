package com.juniorsilvacc.logistics.domain.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.juniorsilvacc.logistics.domain.models.enums.StatusEntrega;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
@Entity
public class Entrega {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private BigDecimal taxa;
	
	@JsonProperty(access = Access.READ_ONLY)
	private LocalDateTime dataPedido;
	
	@JsonProperty(access = Access.READ_ONLY)
	private LocalDateTime finalizacao;
	
	@JsonProperty(access = Access.READ_ONLY) 
	private Integer statusEntrega;
	
	@Embedded
	private Destinatario destinatario;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	public Entrega() {
	
	}
	
	public Entrega(Long id, BigDecimal taxa, LocalDateTime dataPedido, LocalDateTime finalizacao,
			StatusEntrega statusEntrega, Destinatario destinatario, Cliente cliente) {
		super();
		this.id = id;
		this.taxa = taxa;
		this.dataPedido = dataPedido;
		this.finalizacao = finalizacao;
		setStatusEntrega(statusEntrega);
		this.destinatario = destinatario;
		this.cliente = cliente;
	}

	public StatusEntrega getStatusEntrega() {
		return StatusEntrega.valueOf(statusEntrega);
	}

	public void setStatusEntrega(StatusEntrega statusEntrega) {
		if(statusEntrega != null) {
			this.statusEntrega = statusEntrega.getCodigo();
		}
	}

}
