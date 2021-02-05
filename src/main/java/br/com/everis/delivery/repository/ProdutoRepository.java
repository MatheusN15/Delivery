package br.com.everis.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.everis.delivery.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
