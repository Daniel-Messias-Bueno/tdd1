package br.com.tdd.service;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.daniel.tdd.modelo.Funcionario;
import br.com.daniel.tdd.service.BonusService;

class BonusServiceTest {

	@Test
	void bonusDeveriaSerZeroParaSalarioMuitoAlto() {

		BonusService service = new BonusService();
		
		assertThrows(IllegalArgumentException.class, () ->  service.calcularBonus(new Funcionario("Daniel", LocalDate.now(), new BigDecimal("25000"))));
		
		

//		BigDecimal bonus = service.calcularBonus(new Funcionario("Daniel", LocalDate.now(), new BigDecimal("25000")));

//		assertEquals(new BigDecimal("0.00"), bonus);
	}

	@Test
	void bonusDeveriaSer10PorCentoDoSalario() {

		BonusService service = new BonusService();

		BigDecimal bonus = service.calcularBonus(new Funcionario("Daniel", LocalDate.now(), new BigDecimal("2500")));

		assertEquals(new BigDecimal("250.00"), bonus);
	}

	
	@Test
	void bonusDeveriaSer10PorCentoParaSalarioDeExatamente10000() {

		BonusService service = new BonusService();

		BigDecimal bonus = service.calcularBonus(new Funcionario("Daniel", LocalDate.now(), new BigDecimal("10000")));

		assertEquals(new BigDecimal("1000.00"), bonus);
	}
}
