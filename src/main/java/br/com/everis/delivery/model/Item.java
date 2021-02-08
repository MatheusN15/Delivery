package br.com.everis.delivery.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Item {

	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;

	private Long idProduto;
	
	private String nome;
	
	private String tipo;
	
	private Double preco;

	public Item(Produto produto) {
		this.idProduto = produto.getId();
		this.nome = produto.getNome();
		this.preco = produto.getPreco();
		this.tipo = produto.getTipo();
		
	}

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public Item() {
		super();
	}

	public Item(Item item) {
		this.idProduto = item.getId();
		this.idProduto = item.getIdProduto();
		this.nome = item.getNome();
		this.preco = item.getPreco();
		this.tipo = item.getTipo();
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
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
