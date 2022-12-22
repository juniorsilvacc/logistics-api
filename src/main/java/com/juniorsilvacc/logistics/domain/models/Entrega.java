package com.juniorsilvacc.logistics.domain.models;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
	private OffsetDateTime dataPedido;
	
	@JsonProperty(access = Access.READ_ONLY)
	private OffsetDateTime finalizacao;
	
	@JsonProperty(access = Access.READ_ONLY) 
	private Integer statusEntrega;
	 
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	@JsonIgnore
	@OneToMany(mappedBy = "entrega")
	@Cascade(CascadeType.ALL)
	private List<Ocorrencia> ocorrencias = new ArrayList<>();
	
	@Embedded
	private Destinatario destinatario;
	
	public Entrega() {
		super();
	}
	
	public Entrega(Long id, BigDecimal taxa, OffsetDateTime dataPedido, OffsetDateTime finalizacao,
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

	public Ocorrencia addOcorrenciaDescricao(String descricao) {
		Ocorrencia ocorrencia = new Ocorrencia();
		ocorrencia.setDescricao(descricao);
		ocorrencia.setDataRegistro(OffsetDateTime.now());
		ocorrencia.setEntrega(this);
		
		this.getOcorrencias().add(ocorrencia);
		
		return ocorrencia;
	}

}
