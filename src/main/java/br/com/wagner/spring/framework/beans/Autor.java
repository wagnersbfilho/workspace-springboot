package br.com.wagner.spring.framework.beans;

public class Autor implements IAutor {

	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Autor [nome=" + nome + "]";
	}

	@Override
	public void exibirAutor() {
		System.out.println("Autor: " + this.nome);
		
	}
}
