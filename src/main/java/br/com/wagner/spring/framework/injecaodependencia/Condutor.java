package br.com.wagner.spring.framework.injecaodependencia;

import org.springframework.beans.factory.annotation.Autowired;

public class Condutor {

	public static void main(String[] args) {
		Condutor c = new Condutor(new Carro());
		c.automovel();

		Condutor m = new Condutor(new Moto());
		m.automovel();
}
	
	//@Autowired //(não é necessário a partir de 4.3, somente se tiver mais de um construtor)
	public Condutor(Veiculo obj) {
		this.veiculo = obj;
	}
	
	private Veiculo veiculo;
	
	public void automovel() {
		veiculo.acao();
	}

}
