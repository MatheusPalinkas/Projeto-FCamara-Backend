package br.com.projetofcamara.projeto.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import br.com.projetofcamara.projeto.entity.Cliente;
import br.com.projetofcamara.projeto.entity.Comercio;
import br.com.projetofcamara.projeto.entity.Endereco;
import br.com.projetofcamara.projeto.entity.ItemPedido;
import br.com.projetofcamara.projeto.entity.Pedido;
import br.com.projetofcamara.projeto.entity.Produto;
import br.com.projetofcamara.projeto.enums.StatusPedido;
import br.com.projetofcamara.projeto.repository.PedidoRepository;
import br.com.projetofcamara.projeto.service.ComercioService;
import br.com.projetofcamara.projeto.service.EnderecoService;
import br.com.projetofcamara.projeto.service.PedidoService;
import br.com.projetofcamara.projeto.service.ProdutoService;

@Service
public class PedidoServiceImpl implements PedidoService{
	
	@Autowired
	PedidoRepository pedidoRepository;
	
	@Autowired
	ComercioService comercioService;
	
	@Autowired
	ProdutoService produtoService;
	
	@Autowired
	EnderecoService enderecoService;

	@Override
	public Optional<Pedido> criarPedido(Pedido pedido) throws Exception {
	
		if(pedido.getItensPedido().isEmpty()) {
			throw new Exception("Carrinho vazio!");
		}
		
		Optional<Comercio> comercioBd = comercioService.buscarComercioPeloId(pedido.getComercio().getId());
		if(!comercioBd.isPresent()) {
			throw new Exception("Comercio não existe");
		}
		
		Optional<Endereco> enderecoBd = enderecoService.buscarEnderecoPeloId(pedido.getEndereco().getId());
		if(!enderecoBd.isPresent()) {
			throw new Exception("Endereço não existe");
		}
		
		List<Produto> listaProdutos = new ArrayList<Produto>();
		
		for (ItemPedido itemPedido : pedido.getItensPedido()) {
			Optional<Produto> produto = produtoService.buscarProdutoPeloId(itemPedido.getCodigoProduto());
			
			if(produto.isPresent()) {
				
				if(!produto.get().getComercio().getId().equals(comercioBd.get().getId())) {
					throw new Exception("Produto " + produto.get().getNome() + " de comercio diferente");					
				}	
				
			if(produto.get().getQuantidade() - itemPedido.getQuantidade() < 0 || !produto.get().isProdutoEmEstoque()) {
				throw new Exception("Produto sem estoque ou não possui a quantidade desejada");
			}						
			
			}		
			listaProdutos.add(produto.get());
		}
		
		// calcula e verifica quantidade disponivel 
		int subtotal  = 0;
		for(ItemPedido itemPedido : pedido.getItensPedido()) {
			
			for (int i = 0; i < listaProdutos.size(); i++) {	
				
				if(listaProdutos.get(i).getId().equals(itemPedido.getCodigoProduto() ) ){
					listaProdutos.get(i).setQuantidade(listaProdutos.get(i).getQuantidade() - itemPedido.getQuantidade());
					subtotal += listaProdutos.get(i).getPreco() * itemPedido.getQuantidade(); 
					
				}
			}
		}
		
		// reduz quantidade do produto 
		for (Produto aux: listaProdutos) {
			produtoService.criarProduto(aux);
		}
		
		//soma valor dos produtos mais valor de entrega
		pedido.setTotal(subtotal + comercioBd.get().getValorEntrega());
		
		return Optional.ofNullable(pedidoRepository.save(pedido));			
	}	

	@Override
	public Optional<Pedido> buscarPedidoId(String id) {
		return pedidoRepository.findById(id);
	}

	
	@Override
	public Page<Pedido> listarPedidoCliente(String idCliente, Pageable paginacao) {
		return pedidoRepository.findByCliente(new Cliente(idCliente), paginacao);
	}

	@Override
	public Page<Pedido> listarPedidoComercio(String idComercio, Pageable paginacao) {
		return pedidoRepository.findByComercio(new Comercio(idComercio), paginacao);
	}
	
	public Optional<Pedido> aceitaPedido(Pedido pedido){
		
		Optional<Pedido> pedidoBd = pedidoRepository.findById(pedido.getId());
		if(pedidoBd.isPresent() && StatusPedido.PENDENTE.equals( pedidoBd.get().getStatusPedido() )) {
			pedidoBd.get().setStatusPedido(pedido.getStatusPedido());	
		}else{
			throw new IllegalArgumentException("Este pedido já foi cancelado pelo cliente ou negado pelo vendedor");
		}
		return Optional.ofNullable(pedidoRepository.save(pedidoBd.get()));			
	}
	

	public Optional<Pedido> negarPedido(Pedido pedido){
		
		Optional<Pedido> pedidoBd = pedidoRepository.findById(pedido.getId());
		if(pedidoBd.isPresent() && StatusPedido.PENDENTE.equals( pedidoBd.get().getStatusPedido() )) {
			pedidoBd.get().setStatusPedido(pedido.getStatusPedido());	
		}
		return Optional.ofNullable(pedidoRepository.save(pedidoBd.get()));			
	}
	
	public Optional<Pedido> enviarPedido(Pedido pedido){
		
		Optional<Pedido> pedidoBd = pedidoRepository.findById(pedido.getId());
		if(pedidoBd.isPresent() && StatusPedido.ACEITO.equals( pedidoBd.get().getStatusPedido() )) {
			pedidoBd.get().setStatusPedido(pedido.getStatusPedido());	
		}
		return Optional.ofNullable(pedidoRepository.save(pedidoBd.get()));			
	}
	
	public Optional<Pedido> entregarPedido(Pedido pedido){
		
		Optional<Pedido> pedidoBd = pedidoRepository.findById(pedido.getId());
		if(pedidoBd.isPresent() && StatusPedido.ENVIADO.equals( pedidoBd.get().getStatusPedido() )) {
			pedidoBd.get().setStatusPedido(pedido.getStatusPedido());	
		}
		return Optional.ofNullable(pedidoRepository.save(pedidoBd.get()));			
	}
		 
}
