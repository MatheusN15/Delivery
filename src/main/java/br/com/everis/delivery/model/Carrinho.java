package br.com.everis.delivery.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import br.com.everis.delivery.controller.dto.CarrinhoDto;

@Entity
public class Carrinho {
	
	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	@OneToOne
	private Cliente cliente;
	@OneToMany
	private List<Produto> produtos;
	private Double total;
	
	
	
	public Carrinho() {
		super();
	}

	public Carrinho(CarrinhoDto carrinho) {
		this.id = carrinho.getId();
		this.cliente= carrinho.getCliente();
		this.total = carrinho.getTotal();
		this.produtos = carrinho.getProdutos2();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	
	
	
	

}
