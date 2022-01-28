package br.com.wagner.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaudacaoController {

	@GetMapping("/teste")
	public String saudacao(String nome) {
		return String.format("Bem-Vindo, %s", nome);
	}

	@GetMapping("/testeReqParam")
	public String saudacaoReqParam(
			@RequestParam(name = "nome", defaultValue = "WAGNER") String nome) {
		return String.format("Bem-Vindo, %s", nome);
	}

}
