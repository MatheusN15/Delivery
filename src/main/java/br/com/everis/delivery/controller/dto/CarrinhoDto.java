package br.com.everis.delivery.controller.dto;

import java.util.List;

import br.com.everis.delivery.model.Produto;

public class CarrinhoDto {
	
	private Long id;
	private List<Long> idProdutos;
	private Double total = 00.00;
	private List<Produto> produtos;
	private Long idItem;
	
	
	public Long getIdItem() {
		return idItem;
	}

	public void setIdItem(Long idItem) {
		this.idItem = idItem;
	}

	public CarrinhoDto() {
		super();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<Long> getIdProdutos() {
		return idProdutos;
	}
	public void setIdProdutos(List<Long> idProdutos) {
		this.idProdutos = idProdutos;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	
}
