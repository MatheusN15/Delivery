package br.com.everis.delivery.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import br.com.everis.delivery.controller.dto.CarrinhoDto;

@Entity
public class Carrinho {
	
	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Item> itens;
	private Double total;
	

	public Carrinho() {
		super();
	}

	public Carrinho(CarrinhoDto carrinho) {
		this.id = carrinho.getId();
		this.total = carrinho.getTotal();
	}

	public Carrinho(Carrinho carrinho) {
		this.id = carrinho.getId();
		this.total = carrinho.getTotal();
		this.itens = carrinho.getItens();
	}

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

//	public List<Item> getItens() {
//		return itens;
//	}
//
//	public void setItens(List<Item> itens) {
//		this.itens = itens;
//	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

}
