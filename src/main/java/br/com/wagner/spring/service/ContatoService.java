package br.com.wagner.spring.service;

import br.com.wagner.spring.persistencia.Contato;
import br.com.wagner.spring.persistencia.Endereco;

/**
 * Padrão Strategy no domínio do Contato.
 * 
 * @author wagne
 *
 */
public interface ContatoService {

	Iterable<Contato> buscarTodos();
	
	Contato buscarPorId(Long id);
	
	void inserir(Contato contato);
	
	void atualizar (Long id, Contato contato);
	
	void deletar (Long id);
	
	Endereco consultarCep(String cep);
}
