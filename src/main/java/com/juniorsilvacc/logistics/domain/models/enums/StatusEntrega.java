package com.juniorsilvacc.logistics.domain.models.enums;

public enum StatusEntrega {
	
	PENDENTE(1), FINALIZADA(2), CANCELADO(3);

	private int codigo;
	
	private StatusEntrega(int codigo) {
		this.codigo = codigo;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public static StatusEntrega valueOf(int code) {
		for(StatusEntrega value : StatusEntrega.values()) {
			if(value.getCodigo() == code) {
				return value;
			}
		}
		
		throw new IllegalArgumentException("Código de status entrega inválido");
	}

}
