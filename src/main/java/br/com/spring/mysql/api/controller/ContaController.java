package br.com.spring.mysql.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.spring.mysql.api.dao.ContaDao;
import br.com.spring.mysql.api.model.Conta;
import br.com.spring.mysql.api.model.Transferencia;

@RestController
@RequestMapping("/conta")
public class ContaController {
	@Autowired
	private ContaDao dao;
	
	@PostMapping("/")
	public String setContas(@RequestBody List<Conta> contas) {
		dao.save(contas);
		return "Registros inseridos com sucesso.";
	}
	
	@GetMapping("/getContas")
	public List<Conta> getContas() {
		return (List<Conta>) dao.findAll();
	}
	
	@GetMapping("/{cpf}")
	public Conta getConta(@PathVariable Long cpf ) {
		return dao.findContaByCpf(cpf);
	}
	
	@DeleteMapping("/")
	public String delConta(@RequestBody Conta conta) {
		dao.delete(conta);
		return "Registro excluído com sucesso.";
	}
	
	@PutMapping("/update")
	public String updateConta(@RequestBody Conta conta) {
		dao.save(conta);
		return "Registro atualizado com sucesso.";
	}
	
	@PutMapping("/transferenciaEntreContas")
	public String transferencia(@RequestBody Transferencia transferencia) {
		
		dao.debitoEmConta(transferencia.getValorTransferencia(), transferencia.getCpfOrigem());
		dao.creditoEmConta(transferencia.getValorTransferencia(), transferencia.getCpfDestino());

		return "Transferência realizada com sucesso.";
	}
	
	@PutMapping("/deposito")
	public String deposito(@RequestBody Transferencia transferencia) {	
		dao.creditoEmConta(transferencia.getValorTransferencia(), transferencia.getCpfDestino());
		return "Depósito realizado com sucesso.";
	}
	
	@PutMapping("/saque")
	public String saque(@RequestBody Transferencia transferencia) {	
		dao.debitoEmConta(transferencia.getValorTransferencia(), transferencia.getCpfDestino());
		return "Saque realizado com sucesso.";
	}
}
