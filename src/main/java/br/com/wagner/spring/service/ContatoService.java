package br.com.wagner.spring.service;

import org.springframework.stereotype.Service;

import br.com.wagner.spring.persistencia.Contato;

/**
 * Padrão Strategy no domínio do Contato.
 * 
 * @author wagne
 *
 */
@Service
public interface ContatoService {

	Iterable<Contato> buscarTodos();
	
	Contato buscarPorId(Long id);
	
	void inserir(Contato contato);
	
	void atualizar (Long id, Contato contato);
	
	void deletar (Long id);
}
