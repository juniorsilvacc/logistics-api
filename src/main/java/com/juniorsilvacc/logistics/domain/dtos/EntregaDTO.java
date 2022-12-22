package com.juniorsilvacc.logistics.domain.dtos;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.juniorsilvacc.logistics.domain.models.Cliente;
import com.juniorsilvacc.logistics.domain.models.Destinatario;
import com.juniorsilvacc.logistics.domain.models.Entrega;
import com.juniorsilvacc.logistics.domain.models.enums.StatusEntrega;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EntregaDTO {
	
	private Long id;
	private Cliente cliente;
	private Destinatario destinatario;
	private BigDecimal taxa;
	private StatusEntrega statusEntrega;
	private OffsetDateTime dataPedido;
	private OffsetDateTime finalizacao;
	
	public EntregaDTO() {
	}

	public EntregaDTO(Entrega obj) {
		this.id = obj.getId();
		this.cliente = obj.getCliente();
		this.taxa = obj.getTaxa();
		this.destinatario = obj.getDestinatario();
		this.statusEntrega = obj.getStatusEntrega();
		this.dataPedido = obj.getDataPedido();
		this.finalizacao = obj.getFinalizacao();
	}

}
