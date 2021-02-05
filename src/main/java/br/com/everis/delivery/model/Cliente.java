package br.com.everis.delivery.model;

import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="CLIENTE")
public class Cliente {
	
	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	private String nome;
	private String cpf;
	@OneToOne(cascade = CascadeType.PERSIST)
	private Endereco endereco;
	private String email;
	private String senha;
	@OneToOne( cascade = CascadeType.PERSIST)
	private Cartao cartao;
	


	public Cliente() {
		super();
	}
	
	

	public Cliente(Long id, String nome, String cpf, Endereco endereco, String email, String senha, Cartao cartao) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.email = email;
		this.senha = senha;
		this.cartao = cartao;
	}

	public Cliente(Optional<Cliente> clienteOp) {
		this.id = clienteOp.get().getId();
		this.nome = clienteOp.get().getNome();
		this.cpf = clienteOp.get().getCpf();
		this.endereco = clienteOp.get().getEndereco();
		this.email = clienteOp.get().getEmail();
		this.senha = clienteOp.get().getSenha();
		this.cartao = clienteOp.get().getCartao();
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
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Cartao getCartao() {
		return cartao;
	}

	public void setCartao(Cartao cartao) {
		this.cartao = cartao;
	}
	
}
