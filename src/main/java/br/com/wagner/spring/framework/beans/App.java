package br.com.wagner.spring.framework.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class App {

	public static void main(String[] args) {

		ApplicationContext factory = 
				new AnnotationConfigApplicationContext(AppConfig.class);

		Autor autor = factory.getBean(Autor.class);
		autor.setNome("J. R. R. Tolkien");

		Livro livro = factory.getBean(Livro.class);
		livro.setNome("Lord of the Rings");
		livro.setCodigo("D3GH8");
		System.out.println(livro);

		Autor autor2 = factory.getBean(Autor.class);
		autor2.setNome("Wachowskis");

		Livro livro2 = factory.getBean(Livro.class);
		livro2.setNome("Matrix");
		livro2.setCodigo("D3IJ90O");
		System.out.println(livro2);

		((AbstractApplicationContext) factory).close();
	}

}
