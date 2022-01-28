package br.com.wagner.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * <b>IMPORTANTE:</b>
 * Ao executar uma aplicação String Boot (i.e. a class annotated with @SpringBootApplication)
 * O Spring irá executar apenas as classes que estão nos pacotes abaixo à esta classe.
 * 
 * @author wagner
 *
 */
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
