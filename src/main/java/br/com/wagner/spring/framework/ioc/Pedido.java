package br.com.wagner.spring.framework.ioc;


/**
 * IoC - processo onde se inverte o fluxo de comando de um programa.
 * 
 * Seu objetivo é descoplar ou remover dependências do objeto e fornecer
 * controle para outra camada.
 * 
 * Este objeto delega a tarefa de construir dependências para um coteiner IoC
 * 
 * @author wagne
 *
 */
public class Pedido {

	public static void main(String[] args) {
		Pedido pedido = new Pedido();
		
		pedido.gravar();
	}
	
	// Classe EnviarEmails fornece os recursos necessários
	// Spring Framework realizar automaticamente as dependencias
	// atraves de um container IoC
	private EnviarEmails enviar = EnviarEmails.obterDadosEmail();
	 
	 public void gravar() {
		 this.enviar.retornar("Pedido criado!");
	 }
}
