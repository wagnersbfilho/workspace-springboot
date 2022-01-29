package br.com.wagner.spring.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import br.com.wagner.spring.persistencia.Contato;

public class ContatoContollerTest extends AbstractTest {

	@Override
	@BeforeEach
	protected void setUp() {
		// TODO Auto-generated method stub
		super.setUp();
	}

	@Test
	public void getContatoList() throws Exception {
		String uri = "/contatos";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders
				.get(uri)
				.accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);

		String content = mvcResult.getResponse().getContentAsString();
//		System.out.println(content);
		Contato[] contatoList = super.mapFromJson(content, Contato[].class);
		assertTrue(contatoList.length > 0);
	}

	@Test
	public void createContato() throws Exception {
		String uri = "/contatos";
		Contato contato = new Contato();
		contato.setNome("Test Insertion");
		contato.setEmail("teste@mail.com");
		contato.setTelefone("99999-8888");
		String inputJson = super.mapToJson(contato);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders
				.post(uri)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertNotNull(content);
	}
	
	@Test
	public void updateProduct() throws Exception {
		String uri = "/contatos/43";
		Contato contato = new Contato();
		contato.setNome("Test Update");
		contato.setEmail("update@mail.com");
		contato.setTelefone("1111-2222");
		String inputJson = super.mapToJson(contato);
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders
			.put(uri)
			.contentType(MediaType.APPLICATION_JSON_VALUE)
			.content(inputJson))
			.andReturn();
		  
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertNotNull(content);
	}
	
	@Test
	public void deleteContato() throws Exception {
		String uri = "/contatos/44";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders
				.delete(uri))
				.andReturn();
		
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertNotNull(content);
	}
}
