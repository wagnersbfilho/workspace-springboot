package br.com.wagner.spring.persistencia;

import java.util.stream.LongStream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

//@SpringBootApplication //TODO descomentar para realizar TESTES ao inicializar o Spring Boot
public class TesteBancoDados {

    public static void main(String[] args) {
        SpringApplication.run(TesteBancoDados.class, args);
    }

    @Bean
    CommandLineRunner init(ContatoRepositorio repositorio) {
        return args -> {
            repositorio.deleteAll();
            LongStream.range(1, 11)
                    .mapToObj(i -> {
                        Contato c = new Contato();
                        c.setNome("Contato " + i);
                        c.setEmail("contato" + i + "@email.com");
                        c.setTelefone("(111) 111-1111");
                        return c;
                    })
                    .map(v -> repositorio.save(v))
                    .forEach(System.out::println);
        };
    }
}