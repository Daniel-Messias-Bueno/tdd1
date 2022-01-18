package br.com.daniel.tdd.service;

import java.math.BigDecimal;

import br.com.daniel.tdd.modelo.Desempenho;
import br.com.daniel.tdd.modelo.Funcionario;

public class ReajusteService {

	public void concederReajuste(Funcionario funcionario, Desempenho desempenho) {
 
		BigDecimal reajuste = desempenho.percentualReajuste();
		funcionario.reajustarSalario(reajuste);

	}

}
