package br.com.everis.delivery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.everis.delivery.controller.dto.CarrinhoDto;
import br.com.everis.delivery.controller.dto.ProdutoDto;
import br.com.everis.delivery.model.Carrinho;
import br.com.everis.delivery.model.Cliente;
import br.com.everis.delivery.model.Produto;
import br.com.everis.delivery.repository.CarrinhoRepository;
import br.com.everis.delivery.repository.ClienteRepository;
import br.com.everis.delivery.repository.ProdutoRepository;

@RestController
@RequestMapping("/carrinho")
public class CarrinhoController {
	
	@Autowired
	CarrinhoRepository carrinhoRepository;
	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	ProdutoRepository produtoRepository;
	
	@PostMapping("/{id}")
	public Carrinho createCarrinho(@PathVariable("id") long id, @RequestBody CarrinhoDto carrinho){
		Cliente cliente = new Cliente(clienteRepository.findById(id));
		carrinho.setCliente(cliente);
		List<Produto> produtos = produtoRepository.findAllById(carrinho.getProdutos());
		carrinho.setProdutos2(produtos);
		double total = 0;
		for (int i = 0; i < carrinho.getProdutos2().size(); i++) {
			total += carrinho.getProdutos2().get(i).getPreco();
			carrinho.setTotal(total);
		}
		Carrinho carrinhoNew = new Carrinho(carrinho);
		return carrinhoRepository.save(carrinhoNew);
	}
	
	@GetMapping("/{id}")
	public Carrinho showCarrinho(@PathVariable("id") long id){
		Carrinho carrinho = carrinhoRepository.findByClienteId(id);
		return carrinho;
	}

}
