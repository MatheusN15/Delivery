package br.com.everis.delivery.form;

import java.util.List;

import br.com.everis.delivery.model.Produto;

public class CarrinhoForm {

	private Long idCarrinho;
	private List<Long> idProdutos;
	private List<Produto> produtos;
	private Double valor;
	
	
	public Long getIdCarrinho() {
		return idCarrinho;
	}
	public void setIdCarrinho(Long idCarrinho) {
		this.idCarrinho = idCarrinho;
	}
	public List<Long> getIdProdutos() {
		return idProdutos;
	}
	public void setIdProdutos(List<Long> idProdutos) {
		this.idProdutos = idProdutos;
	}
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	
}
