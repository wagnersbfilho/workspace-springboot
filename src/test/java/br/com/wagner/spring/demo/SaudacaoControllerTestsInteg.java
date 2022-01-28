package br.com.wagner.spring.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest
@ExtendWith(SpringExtension.class)
public class SaudacaoControllerTestsInteg {

	@Autowired
	private MockMvc mvc;
	
	@Test
	public void testInt() throws Exception {
		RequestBuilder requisicao = MockMvcRequestBuilders.get("/testeReqParam");
		MvcResult resultado = mvc.perform(requisicao).andReturn();
		assertEquals("Bem-vindo, WAGNER", resultado.getResponse().getContentAsString());
	}
	
	@Test
	public void testIntComArgumento() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/test?nome=Wagner Filho"))
		.andExpect(MockMvcResultMatchers.content().string("Bem-Vindo, Wagner Filho"));
	}
}
