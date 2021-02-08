package br.com.everis.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.everis.delivery.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long>{

}
