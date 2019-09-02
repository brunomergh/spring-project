package com.javatechie.spring.mysql.api.dao;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.javatechie.spring.mysql.api.model.Conta;

public interface ContaDao extends CrudRepository<Conta, Integer>{
	
	@Transactional
	@Modifying
	@Query("update Conta set saldo = saldo - :valorTransferencia WHERE cpf = :cpfOrigem")
	void debitoEmConta(@Param("valorTransferencia") BigDecimal valorTransferencia, @Param("cpfOrigem") Long cpfOrigem);
	
	@Transactional
	@Modifying
	@Query("update Conta set saldo = saldo + :valorTransferencia WHERE cpf = :cpfDestino")
	void creditoEmConta(@Param("valorTransferencia") BigDecimal valorTransferencia, @Param("cpfDestino") Long cpfDestino);
	
	@Query("select c from Conta c WHERE c.cpf = :cpf")
	Conta findContaByCpf(@Param("cpf") Long cpf);
}
