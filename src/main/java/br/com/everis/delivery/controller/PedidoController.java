package br.com.everis.delivery.controller;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.everis.delivery.controller.dto.PedidoDto;
import br.com.everis.delivery.model.Cliente;
import br.com.everis.delivery.model.Item;
import br.com.everis.delivery.model.Pagamento;
import br.com.everis.delivery.model.Pedido;
import br.com.everis.delivery.model.Produto;
import br.com.everis.delivery.repository.ClienteRepository;
import br.com.everis.delivery.repository.PedidoRepository;
import br.com.everis.delivery.repository.ProdutoRepository;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

	@Autowired
	PedidoRepository pedidoRepository;
	@Autowired
	ClienteRepository clienteService;
	@Autowired
	ProdutoRepository produtoRepository;

	@GetMapping(value = "/{id}")
	public List<Pedido> getPostDetails(@PathVariable("id") long id) {
		List<Pedido> pedido = pedidoRepository.findByClienteId(id);
		return pedido;
	}

	@GetMapping
	public List<Pedido> lista() {
		return pedidoRepository.findAll();
	}

	@PostMapping(value = "/{id}")
	public ResponseEntity<Pedido> comprar(@PathVariable("id") long id, @RequestBody PedidoDto pedidodto, UriComponentsBuilder uriBuilder) {
		pedidodto.setData(LocalDateTime.now());
		Cliente cliente = new Cliente(clienteService.findById(id));
		Pedido pedido = new Pedido(cliente);

		if (pedidodto.getPagamento() != Pagamento.DINHEIRO) {
			pedido.setPagamento(Pagamento.CARTAO);
			pedido.setTipoCartao(cliente.getCartao().getTipoCartao());
		}
		List<Produto> produto = new ArrayList<Produto>();
		for (int i = 0; i < pedidodto.getProdutosId().size(); i++) {
			Produto prod = new Produto(produtoRepository.findById(pedidodto.getProdutosId().get(i)));
			produto.add(prod);
		}

		List<Item> itens = new ArrayList<Item>();
		for (int i = 0; i < produto.size(); i++) {
			itens.add(new Item(produto.get(i)));
		}

		pedido.setPagamento(pedidodto.getPagamento());

		pedido.setItem(itens);
		pedido.setData(LocalDateTime.now());
		double valor = 0;
		for (int i = 0; i < produto.size(); i++) {
			valor += produto.get(i).getPreco();

		}
		pedido.setValor(valor);
		URI uri = uriBuilder.path("/{id}").buildAndExpand(cliente.getId()).toUri();
		return ResponseEntity.created(uri).body(pedidoRepository.save(pedido));

	}

}
