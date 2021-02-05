package br.com.everis.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.everis.delivery.model.Cartao;

public interface CartaoRepository extends JpaRepository<Cartao, Long>{

}
