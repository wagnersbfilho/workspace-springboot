package br.com.wagner.spring.persistencia;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Referencias:
 * http://viacep.com.br/
 * https://www.jsonschema2pojo.org/
 * 
 * @author wagner
 *
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Endereco {

	@Id
	private String cep;
	private String logradouro;
	private String complemento;
	private String bairro;
	private String localidade;
	private String uf;
	private String ibge;
	private String gia;
	private String ddd;
	private String siafi;
}
