package br.com.wagner.spring.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.com.wagner.spring.controller.SaudacaoController;

public class SaudacaoControllerTests {

	@Test
	public void testar() {
		SaudacaoController controller = new SaudacaoController();
		String resultado = controller.saudacao("WAGNER");
		assertEquals("Bem-Vindo, WAGNER", resultado);
	}
}
