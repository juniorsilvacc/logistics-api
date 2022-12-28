package com.juniorsilvacc.logistics.domain.dtos;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import javax.validation.constraints.NotNull;

import com.juniorsilvacc.logistics.domain.models.Cliente;
import com.juniorsilvacc.logistics.domain.models.Destinatario;
import com.juniorsilvacc.logistics.domain.models.Entrega;
import com.juniorsilvacc.logistics.domain.models.enums.StatusEntrega;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EntregaDTO {
	
//	@NotBlank: verifica se a sequência de caracteres anotada não é nula e se o comprimento aparado é maior que 0.
//	@NotNull: Verifica se o valor anotado não é nulo, porém pode ser vazio.
//	@NotEmpty: Verifica se o elemento anotado não é nulo nem vazio.
	
	private Long id;
	private Cliente cliente;
	private Destinatario destinatario;
	
	@NotNull(message = "Campo TAXA é requerido")
	private BigDecimal taxa;
	
	private StatusEntrega statusEntrega;
	private OffsetDateTime dataPedido;
	private OffsetDateTime finalizacao;
	
	public EntregaDTO() {
	}
	
	public EntregaDTO(Long id, Cliente cliente, Destinatario destinatario, BigDecimal taxa, StatusEntrega statusEntrega,
			OffsetDateTime dataPedido, OffsetDateTime finalizacao ) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.destinatario = destinatario;
		this.taxa = taxa;
		this.statusEntrega = statusEntrega;
		this.dataPedido = dataPedido;
		this.finalizacao = finalizacao;
	}

	public EntregaDTO(Entrega obj) {
		this.id = obj.getId();
		this.cliente = obj.getCliente();
		this.destinatario = obj.getDestinatario();
		this.taxa = obj.getTaxa();
		this.statusEntrega = obj.getStatusEntrega();
		this.dataPedido = obj.getDataPedido();
		this.finalizacao = obj.getFinalizacao();
	}

}
