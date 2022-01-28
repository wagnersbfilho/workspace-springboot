package br.com.wagner.spring.framework.injecaodependencia;

import org.springframework.stereotype.Service;

@Service
public class Carro implements Veiculo{

	@Override
	public void acao() {
		System.out.println("Carro");
	}

}
