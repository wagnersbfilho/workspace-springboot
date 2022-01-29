package br.com.wagner.spring.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.wagner.spring.persistencia.Contato;
import br.com.wagner.spring.persistencia.ContatoRepositorio;
import br.com.wagner.spring.persistencia.Endereco;
import br.com.wagner.spring.persistencia.EnderecoRepositorio;
import br.com.wagner.spring.service.ContatoService;
import br.com.wagner.spring.service.ViaCepService;

public class ContatoServiceImpl implements ContatoService {

	@Autowired
	private ContatoRepositorio contatoRepositorio;
	
	@Autowired
	private EnderecoRepositorio enderecoRepositorio;
	
	@Autowired
	private ViaCepService viaCepService;
	
	@Override
	public Iterable<Contato> buscarTodos() {
		return contatoRepositorio.findAll();
	}

	@Override
	public Contato buscarPorId(Long id) {
		Optional<Contato> contato = contatoRepositorio.findById(id);
		return contato.get();
	}

	@Override
	public void inserir(Contato contato) {
		String cep = contato.getEndereco().getCep();
		Endereco endereco = enderecoRepositorio.findById(cep).orElseGet(() -> {
			Endereco novoEndereco = viaCepService.consultarCep(cep);
			enderecoRepositorio.save(novoEndereco);
			return novoEndereco;
		});
		contato.setEndereco(endereco);
		contatoRepositorio.save(contato);
	}

	@Override
	public void atualizar(Long id, Contato contato) {
		Optional<Contato> contatoBd = contatoRepositorio.findById(id);
		if (contatoBd.isPresent()) {
			inserir(contatoBd.get());
		}

	}

	@Override
	public void deletar(Long id) {
		contatoRepositorio.deleteById(id);

	}

}
