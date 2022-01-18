package br.com.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.daniel.tdd.modelo.Desempenho;
import br.com.daniel.tdd.modelo.Funcionario;
import br.com.daniel.tdd.service.ReajusteService;

public class ReajusteServiceTest {

	private ReajusteService service;
	private Funcionario funcionario;
	
	
	@BeforeEach
	public void inicializar() {
		this.service = new ReajusteService();
		this.funcionario = new Funcionario("Daniel", LocalDate.now(), new BigDecimal("1000.0"));

	}

	@Test
	public void desempenhoDeveriaSerDeTresPorcentoQuandoDesempenhoForADesejar() {
		service.concederReajuste(funcionario, Desempenho.A_DESEJAR);
		assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());

	}

	@Test
	public void reajusteDeveriaSerDeQuinzePorCentoQuandoDesmpenhoForBom() {
		service.concederReajuste(funcionario, Desempenho.BOM);
		assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());

	}

	@Test
	public void reajusteDeveriaSerDeQuinzePorCentoQuandoDesmpenhoForOtimo() {
		service.concederReajuste(funcionario, Desempenho.OTIMO);
		assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());

	}

}
