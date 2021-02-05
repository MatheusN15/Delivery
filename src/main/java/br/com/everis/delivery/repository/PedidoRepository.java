package br.com.everis.delivery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.everis.delivery.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{

	List<Pedido> findByClienteId(Long idCliente);
}
