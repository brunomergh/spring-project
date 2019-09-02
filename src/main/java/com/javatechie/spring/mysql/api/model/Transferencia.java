package com.javatechie.spring.mysql.api.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Transferencia {

	private Long cpfOrigem;
	private BigDecimal valorTransferencia;
	private Long cpfDestino;
	
	
	public Long getCpfOrigem() {
		return cpfOrigem;
	}
	public void setCpfOrigem(Long cpfOrigem) {
		this.cpfOrigem = cpfOrigem;
	}
	public BigDecimal getValorTransferencia() {
		return valorTransferencia;
	}
	public void setValorTransferencia(BigDecimal valorTransferencia) {
		this.valorTransferencia = valorTransferencia;
	}
	public Long getCpfDestino() {
		return cpfDestino;
	}
	public void setCpfDestino(Long cpfDestino) {
		this.cpfDestino = cpfDestino;
	}
	
	

}
