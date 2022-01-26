package br.com.wagner.spring.persistencia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface ContatoRepositorio extends JpaRepository<Contato, Long>{

}
