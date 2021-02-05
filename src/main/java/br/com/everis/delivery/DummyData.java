package br.com.everis.delivery;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.everis.delivery.controller.dto.ClienteDto;
import br.com.everis.delivery.model.Cartao;
import br.com.everis.delivery.model.Cliente;
import br.com.everis.delivery.model.Endereco;
import br.com.everis.delivery.repository.CartaoRepository;
import br.com.everis.delivery.repository.ClienteRepository;

@Component
public class DummyData {
	
	@Autowired
	CartaoRepository cartao;
	
	//@PostConstruct
	@Transactional
	public void savePosts(){
		cartao.deleteById(15L);
	}

}
