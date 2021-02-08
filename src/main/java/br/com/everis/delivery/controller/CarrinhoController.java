package br.com.everis.delivery.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.everis.delivery.controller.dto.CarrinhoDto;
import br.com.everis.delivery.model.Carrinho;
import br.com.everis.delivery.model.Cliente;
import br.com.everis.delivery.model.Item;
import br.com.everis.delivery.model.Produto;
import br.com.everis.delivery.repository.CarrinhoRepository;
import br.com.everis.delivery.repository.ClienteRepository;
import br.com.everis.delivery.repository.ItemRepository;
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
	@Autowired
	ItemRepository itemRepository;
	
	@PostMapping("/{id}")
	public Optional<Carrinho> createCarrinho(@PathVariable("id") long id, @RequestBody CarrinhoDto carrinho){
		Cliente cliente = new Cliente(clienteRepository.findById(id));
		Carrinho carrinhoNew = new Carrinho(cliente.getCarrinho());
		List<Produto> produtos = new ArrayList<Produto>();
		
		produtos.addAll(produtoRepository.findAllById(carrinho.getIdProdutos()));
		List<Item> itens = new ArrayList<Item>();
		
		for (int i = 0; i < produtos.size(); i++) {
			Item item = new Item(produtos.get(i));
			itemRepository.save(item);
			itens.add(item);
		}
		double valor = 0;
		if(carrinhoNew.getItens() != null) {
			itens.addAll(carrinhoNew.getItens());
			valor = carrinhoNew.getTotal();
		}
		
		carrinhoNew.setItens(itens);
		
		
		for (int i = 0; i < produtos.size(); i++) {
			valor += produtos.get(i).getPreco();
		}
		carrinhoNew.setTotal(valor);
		carrinhoRepository.save(carrinhoNew);
		cliente.setCarrinho(carrinhoNew);
		clienteRepository.save(cliente);
		return carrinhoRepository.findById(cliente.getCarrinho().getId());
	}
	
	@GetMapping("/{id}")
	public Carrinho showCarrinho(@PathVariable("id") long id){
		Cliente cliente = new Cliente(clienteRepository.findById(id));
		
		return cliente.getCarrinho();
	}
	
	@DeleteMapping("/{id}")
	public Carrinho deleteItem(@PathVariable("id") long id,  @RequestBody CarrinhoDto carrinho) {
		// TODO: metodo de delete item
		Cliente cliente = new Cliente(clienteRepository.findById(id));
		for (int i = 0; i < cliente.getCarrinho().getItens().size(); i++) {
			if (cliente.getCarrinho().getItens().get(i).getIdProduto() == carrinho.getIdItem()) {
				
				itemRepository.delete(cliente.getCarrinho().getItens().get(i));
				cliente.getCarrinho().getItens().get(0).setId(null);
				itemRepository.delete(cliente.getCarrinho().getItens().get(0));
				break;
			}
		}
		
		return cliente.getCarrinho();
	}

}
