package br.com.projetofcamara.projeto.service;

import java.util.List;
import java.util.Optional;
import br.com.projetofcamara.projeto.entity.Avaliacao;
import br.com.projetofcamara.projeto.entity.Pedido;

public interface PedidoService {	
		
	Optional<Pedido> criarPedido(Pedido pedido);

	Optional<Pedido> buscarPedidoId(String id);	
	
	List<Pedido> listarPedidoComercio(String idComercio);

	List<Pedido> listarPedidoCliente(String idCliente);	
	
	Optional<Pedido> aceitaPedido(Pedido pedido);
	
	Optional<Pedido> negarPedido(Pedido pedido);
	
	Optional<Pedido> enviarPedido(Pedido pedido);
	
	Optional<Pedido> entregarPedido(Pedido pedido);

	Optional<Pedido> criarAvaliacao(Avaliacao avaliaPedido, String avaliado, String idPedido);
		
}
