package br.com.wagner.spring.controller;

import java.util.List;

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
import br.com.wagner.spring.persistencia.ContatoRepositorio;

@RestController
@RequestMapping({"/contatos"})
public class ContatoController {

	private ContatoRepositorio repositorio;
	
	public ContatoController(ContatoRepositorio repositorio) {
		this.repositorio = repositorio;
	}
	
	//metodos CRUD
	
	@GetMapping
	public List<Contato> findAll(){
	   return repositorio.findAll();
	}

	@GetMapping(path = {"/{id}"})
	public ResponseEntity<Contato> findById(@PathVariable Long id){
		return repositorio.findById(id)
		           .map(record -> ResponseEntity.ok().body(record))
		           .orElse(ResponseEntity.notFound().build());
	}
	

	@PostMapping
	public Contato create(@RequestBody Contato contato){
	   return repositorio.save(contato);
	}

	@PutMapping(value="/{id}")
	public ResponseEntity<Contato> update(@PathVariable("id") long id,
	                             @RequestBody Contato contato) {
	   return repositorio.findById(id)
	           .map(record -> {
	               record.setNome(contato.getNome());
	               record.setEmail(contato.getEmail());
	               record.setTelefone(contato.getTelefone());
	               Contato updated = repositorio.save(record);
	               return ResponseEntity.ok().body(updated);
	           }).orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping(path ={"/{id}"})
	public ResponseEntity <?> delete(@PathVariable Long id) {
	   return repositorio.findById(id)
	           .map(record -> {
	               repositorio.deleteById(id);
	               return ResponseEntity.ok().build();
	           }).orElse(ResponseEntity.notFound().build());
	}
}