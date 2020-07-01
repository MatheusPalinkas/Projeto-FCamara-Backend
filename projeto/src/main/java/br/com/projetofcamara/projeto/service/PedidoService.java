package br.com.projetofcamara.projeto.service;

import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import br.com.projetofcamara.projeto.entity.Avaliacao;
import br.com.projetofcamara.projeto.entity.Pedido;

public interface PedidoService {	
		
	Optional<Pedido> criarPedido(Pedido pedido);

	Optional<Pedido> buscarPedidoId(String id);	
	
	Page<Pedido> listarPedidoComercio(String idComercio, Pageable paginacao);

	Page<Pedido> listarPedidoCliente(String idCliente, Pageable paginacao);	
	
	Optional<Pedido> aceitaPedido(Pedido pedido);
	
	Optional<Pedido> negarPedido(Pedido pedido);
	
	Optional<Pedido> enviarPedido(Pedido pedido);
	
	Optional<Pedido> entregarPedido(Pedido pedido);

	Optional<Pedido> criarAvaliacao(Avaliacao avaliaPedido, String avaliado, String idPedido);
		
}
