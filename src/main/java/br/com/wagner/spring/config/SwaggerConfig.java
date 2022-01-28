package br.com.wagner.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author wagne
 *
 * Abrir URL: http://localhost:8080/swagger-ui/index.html
 * 
 * @EnableWebMvc - resolver problema de NullPointerException (analisar melhor o motivo)
 * 
 */
@Configuration
@EnableWebMvc
//@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("br.com.wagner.spring.controller"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(buildApiInfo());
	}
	
	private ApiInfo buildApiInfo() {
		return new ApiInfoBuilder()
				.title("API Contatos")
				.description("REST API Teste Contatos")
				.version("1.0")
				.contact(new Contact("Wagner", null, "wagner@email.com"))
				.build();
	}
}
