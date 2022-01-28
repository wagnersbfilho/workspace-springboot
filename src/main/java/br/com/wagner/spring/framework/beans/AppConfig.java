package br.com.wagner.spring.framework.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	@Bean
	public Livro getLivro() {
		return new Livro();
	}
	//<bean id="livro" class="beans.Livro"/>
	
	@Bean
	public IAutor getIAutor() {
		return new Autor();
	}
}
