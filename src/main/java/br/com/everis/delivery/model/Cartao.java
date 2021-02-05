package br.com.everis.delivery.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cartao {
	
	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	private String numeroCartao;
	private Integer cvv;
	@Enumerated(EnumType.STRING)
	private TipoCartao tipoCartao;
	
	
	public String getNumeroCartao() {
		return numeroCartao;
	}
	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}
	public Integer getCvv() {
		return cvv;
	}
	public void setCvv(Integer cvv) {
		this.cvv = cvv;
	}
	public TipoCartao getTipoCartao() {
		return tipoCartao;
	}
	public void setTipoCartao(TipoCartao tipoCartao) {
		this.tipoCartao = tipoCartao;
	}

}
