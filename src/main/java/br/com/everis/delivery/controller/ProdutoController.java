package br.com.everis.delivery.controller;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.everis.delivery.controller.dto.ProdutoDto;
import br.com.everis.delivery.model.Produto;
import br.com.everis.delivery.repository.ProdutoRepository;

@RequestMapping("/produto")
@RestController
public class ProdutoController {

	@Autowired
	ProdutoRepository produtoRepository;
	
	@GetMapping
	public List<Produto> lista(){
		return produtoRepository.findAll();
	}
	
	@PostMapping
	@Transactional
	public Produto cadastrar(@RequestBody ProdutoDto produto){
		Produto prod = produto.converter();
		return produtoRepository.save(prod);
		
	}
	
	@PutMapping("/{id}")
	public Produto atualiza(@PathVariable("id") long id, @RequestBody ProdutoDto produtoDto) {
		Produto prod = new Produto(produtoRepository.findById(id));
		return produtoRepository.save(produtoDto.atualiza(prod));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<URI> delete(@PathVariable("id") long id, UriComponentsBuilder uriBuilder) {
		Produto prod = new Produto(produtoRepository.findById(id));
		produtoRepository.delete(prod);
		URI uri = uriBuilder.path("/{id}").buildAndExpand(id).toUri();
		return ResponseEntity.ok(uri);
	}
}
