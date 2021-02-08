package br.com.everis.delivery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.everis.delivery.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long>{


	List<Item> findByIdProduto(Long idItem);

}
