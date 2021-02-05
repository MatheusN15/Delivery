package br.com.everis.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.everis.delivery.model.Carrinho;
import br.com.everis.delivery.model.Cliente;

public interface CarrinhoRepository extends JpaRepository<Carrinho, Long>{

	Carrinho findByClienteId(long id);

}
