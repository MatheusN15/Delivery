package br.com.everis.delivery.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
