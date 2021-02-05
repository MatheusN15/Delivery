package br.com.everis.delivery.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="PEDIDO")
public class Pedido {

	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	@ManyToOne
	private Cliente cliente;
	@ManyToMany
	private List<Produto> produtos;
	private LocalDateTime data;
	private Double valor;
	@Enumerated(EnumType.STRING)
	private Pagamento pagamento;
	@Enumerated(EnumType.STRING)
	private TipoCartao tipoCartao;
	

	

	public Pedido() {
		super();
	}

	public Pedido(Long id, Cliente cliente, List<Produto> produtos, LocalDateTime data, Double valor) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.produtos = produtos;
		this.data = data;
		this.valor = valor;
	}

	public Pedido(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public LocalDateTime getData() {
		return data;
	}
	public void setData(LocalDateTime data) {
		this.data = data;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}
	public TipoCartao getTipoCartao() {
		return tipoCartao;
	}

	public void setTipoCartao(TipoCartao tipoCartao) {
		this.tipoCartao = tipoCartao;
	}
}
