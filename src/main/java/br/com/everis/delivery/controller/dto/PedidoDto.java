package br.com.everis.delivery.controller.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import br.com.everis.delivery.model.Cliente;
import br.com.everis.delivery.model.Pagamento;
import br.com.everis.delivery.model.TipoCartao;

public class PedidoDto {

	private Long id;
	private Long clienteId;
	private List<Long> produtosId;
	private LocalDateTime data;
	private Double valor;
	private Pagamento pagamento = Pagamento.DINHEIRO;
	private TipoCartao tipoCartao;
	
	
	public PedidoDto() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getClienteId() {
		return clienteId;
	}

	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
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

	public void setCliente(Optional<Cliente> findById) {
		
	}

	public List<Long> getProdutosId() {
		return produtosId;
	}

	public void setProdutosId(List<Long> produtosId) {
		this.produtosId = produtosId;
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
		if(this.pagamento == Pagamento.DINHEIRO) {
		}else {
		this.tipoCartao = tipoCartao;
		}
	}
}
