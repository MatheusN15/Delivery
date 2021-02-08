package br.com.everis.delivery.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.sun.istack.NotNull;

import br.com.everis.delivery.model.Cartao;
import br.com.everis.delivery.model.Cliente;
import br.com.everis.delivery.model.Endereco;

public class ClienteDto {

	private Long id;
	@NotNull
	private String nome;
	@NotNull
	private String cpf;
	private Endereco endereco;
	@NotNull
	private String email;
	@NotNull
	private String senha;
	private Cartao cartao;

	public ClienteDto(Cliente cliente) {
		this.id = cliente.getId();
		this.nome = cliente.getNome();
		this.cpf = cliente.getCpf();
		this.endereco = cliente.getEndereco();
		this.email = cliente.getEmail();
		this.senha = cliente.getSenha();
		this.cartao = cliente.getCartao();
	}

	public ClienteDto(String nome, String cpf, Endereco endereco, String email, String senha, Cartao cartao) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.email = email;
		this.senha = senha;
		this.cartao = cartao;
	}

	public Cliente atualiza(Cliente cliente) {
		cliente.setNome(this.nome);
		cliente.setCpf(this.cpf);
		cliente.setEmail(this.email);
		cliente.setSenha(this.senha);
		cliente.setCartao(this.cartao);
		return cliente;
	}

	public ClienteDto() {
		super();
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

	public static List<ClienteDto> converter(List<Cliente> clientes) {
		return clientes.stream().map(ClienteDto::new).collect(Collectors.toList());
	}

	public Cliente converter() {
		return new Cliente(id, nome, cpf, endereco, email, senha, cartao);
	}
}
