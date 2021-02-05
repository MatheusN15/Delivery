package br.com.everis.delivery.model;

import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PRODUTO")
public class Produto {
	
	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	
	private String nome;
	
	private String tipo;
	
	private Double preco;

	
	
	public Produto() {
		super();
	}

	public Produto(Long id, String nome, String tipo, Double preco) {
		super();
		this.id = id;
		this.nome = nome;
		this.tipo = tipo;
		this.preco = preco;
	}

	public Produto(Optional<Produto> produtos) {
		this.id = produtos.get().getId();
		this.nome = produtos.get().getNome();
		this.tipo = produtos.get().getTipo();
		this.preco = produtos.get().getPreco();
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
	
}
