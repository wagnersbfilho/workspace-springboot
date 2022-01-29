package br.com.wagner.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.wagner.spring.persistencia.Contato;
import br.com.wagner.spring.service.ContatoService;

@RestController
@RequestMapping({ "/contatosRest" })
public class ContatoRestController {

	private ContatoService contatoService;
	
	@Autowired
	public ContatoRestController(ContatoService contatoService) {
		this.contatoService = contatoService;
	}

	@GetMapping
	public ResponseEntity<Iterable<Contato>> buscarTodos() {
		return ResponseEntity.ok(contatoService.buscarTodos());
	}

	@GetMapping(path = { "/{id}" })
	public ResponseEntity<Contato> buscarPorId(@PathVariable Long id) {
		return ResponseEntity.ok(contatoService.buscarPorId(id));
	}

	@PostMapping
	public ResponseEntity<Contato> isnerir(@RequestBody Contato contato) {
		contatoService.inserir(contato);
		return ResponseEntity.ok(contato);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Contato> update(@PathVariable("id") long id, @RequestBody Contato contato) {
		contatoService.atualizar(id, contato);
		return ResponseEntity.ok(contato);
	}

	@DeleteMapping(path = { "/{id}" })
	public ResponseEntity<Contato> delete(@PathVariable Long id) {
//		Contato contato = contatoService.buscarPorId(id);
		contatoService.deletar(id);
		return ResponseEntity.ok().build();
	}

}
