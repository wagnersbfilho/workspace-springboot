package br.com.wagner.spring.ioc;

public class EnviarEmails {

	public EnviarEmails(String tipo, String endereco,
			String senha) {
		// TODO Auto-generated constructor stub
	}
	
	public static EnviarEmails obterDadosEmail() {
		return new EnviarEmails("smtp", "contato@rmail.com", "pawd");
	}
	
	public void retornar(String mensagem) {
		System.out.println("Email enviado!");
	}
}
