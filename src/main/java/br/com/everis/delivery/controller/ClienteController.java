package br.com.everis.delivery.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
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
import br.com.everis.delivery.model.Cartao;
import br.com.everis.delivery.model.Cliente;
import br.com.everis.delivery.repository.CartaoRepository;
import br.com.everis.delivery.repository.ClienteRepository;





@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	CartaoRepository cartaoRository;

	@PostMapping
	public ResponseEntity<ClienteDto> cadastrar(@RequestBody ClienteDto clien, UriComponentsBuilder uriBuilder){
		Cliente cliente = clien.converter();
		clienteRepository.save(cliente);
		
		URI uri = uriBuilder.path("/{id}").buildAndExpand(cliente.getId()).toUri();
		return ResponseEntity.created(uri).body(new ClienteDto(cliente));
		
	}
	
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
	
	@PostMapping("/{id}/cartao")
	public Cliente newCartao(@PathVariable("id") long id, @RequestBody Cartao cartao) {
		Cliente cliente = new Cliente(clienteRepository.findById(id));
		
		cliente.setCartao(cartaoRository.save(cartao));
		return clienteRepository.save(cliente);
		
	}
}
