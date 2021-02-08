package br.com.everis.delivery.controller.dto;

import br.com.everis.delivery.model.Produto;

public class ProdutoDto {

	private Long id;
	
	private String nome;
	
	private String tipo;
	
	private Double preco;
	
	
	
	public ProdutoDto() {
		super();
	}

	public ProdutoDto(Produto produto) {
		this.id = produto.getId();
		this.nome = produto.getNome();
		this.tipo = produto.getTipo();
		this.preco = produto.getPreco();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Produto converter() {
		return new Produto(id, nome, tipo, preco);
	}

	public Produto atualiza(Produto prod) {
		prod.setNome(nome);
		prod.setPreco(preco);
		prod.setTipo(tipo);
		return prod;
	}
	
	
	
}
