package br.com.everis.delivery.controller.dto;

import java.util.List;

import br.com.everis.delivery.model.Cliente;
import br.com.everis.delivery.model.Produto;

public class CarrinhoDto {
	
	private List<Long> produtos;
	private Double total;
	private Cliente cliente;
	private Long id;
	private List<Produto> produtos2;
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<Long> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Long> produtos) {
		this.produtos = produtos;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public List<Produto> getProdutos2() {
		return produtos2;
	}
	public void setProdutos2(List<Produto> produtos2) {
		this.produtos2 = produtos2;
	}

	
}
