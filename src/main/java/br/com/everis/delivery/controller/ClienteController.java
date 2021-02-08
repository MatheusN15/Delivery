package br.com.everis.delivery.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.everis.delivery.controller.dto.ClienteDto;
import br.com.everis.delivery.form.ClienteLoginForm;
import br.com.everis.delivery.model.Carrinho;
import br.com.everis.delivery.model.Cartao;
import br.com.everis.delivery.model.Cliente;
import br.com.everis.delivery.repository.CarrinhoRepository;
import br.com.everis.delivery.repository.CartaoRepository;
import br.com.everis.delivery.repository.ClienteRepository;


@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	CartaoRepository cartaoRepository;
	@Autowired
	CarrinhoRepository carrinhoRepository;

	
	@GetMapping
	public List<Cliente> listar(){
		return  clienteRepository.findAll();
	}
	@PostMapping("/login")
	public ResponseEntity<Object> login(@RequestBody ClienteLoginForm form, UriComponentsBuilder uriBuilder){
		Cliente clientes = clienteRepository.findByEmail(form.getEmail());
		
		if(form.getSenha().equals(clientes.getSenha())) {
			
			URI uri = uriBuilder.path("/login/{id}").buildAndExpand(clientes.getId()).toUri();
			return ResponseEntity.created(uri).body(new ClienteDto(clientes));
		}
		return ((BodyBuilder) ResponseEntity.notFound()).body(form);
	}
	
	
	@PostMapping
	public ResponseEntity<ClienteDto> cadastrar(@RequestBody ClienteDto clien, UriComponentsBuilder uriBuilder){
		Cliente cliente = clien.converter();
		Carrinho carrinho = new Carrinho();
		cliente.setCarrinho(carrinho);
		clienteRepository.save(cliente);
		
		URI uri = uriBuilder.path("/{id}").buildAndExpand(cliente.getId()).toUri();
		return ResponseEntity.created(uri).body(new ClienteDto(cliente));
		
	}
	@PutMapping("/{id}")
	public Cliente atualiza(@RequestBody ClienteDto clientedto, @PathVariable("id") long id) {
		Cliente cliente = new Cliente(clienteRepository.findById(id));
		clientedto.setCartao(cliente.getCartao());
		return clienteRepository.save(clientedto.atualiza(cliente));
	}
	@GetMapping("/{id}")
	public Cliente show(@PathVariable("id") long id) {
		return new Cliente(clienteRepository.findById(id));
	}
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") long id) {
		clienteRepository.deleteById(id);
	}
	
//Crud Cartao	
	@PostMapping("/{id}/cartao")
	public Cliente newCartao(@PathVariable("id") long id, @RequestBody Cartao cartao) {
		Cliente cliente = new Cliente(clienteRepository.findById(id));
		
		cliente.setCartao(cartaoRepository.save(cartao));
		return clienteRepository.save(cliente);	
	}
	@PutMapping("/{id}/cartao")
	public Cartao atualizaCartao(@PathVariable("id") long id, @RequestBody Cartao cartao) {
		Cliente cliente = new Cliente(clienteRepository.findById(id));
		Cartao cart = new Cartao(cartaoRepository.findById(cliente.getCartao().getId()));
		return cartaoRepository.save(cartao.atualiza(cart));	
	}
	@DeleteMapping("/{id}/cartao")
	public void apagaCartao(@PathVariable("id") long id) {
		Cliente cliente = new Cliente(clienteRepository.findById(id));
		Cartao cart = new Cartao(cartaoRepository.findById(cliente.getCartao().getId()));
		Cartao cartao = new Cartao();
		cartaoRepository.save(cartao.atualiza(cart));
	//	cartaoRepository.delete(cliente.getCartao());	
	}
	
}
