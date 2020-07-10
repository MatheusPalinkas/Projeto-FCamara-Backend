package br.com.projetofcamara.projeto.controller.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.com.projetofcamara.projeto.entity.Avaliacao;
import br.com.projetofcamara.projeto.entity.ItemPedido;
import br.com.projetofcamara.projeto.entity.Pedido;
import br.com.projetofcamara.projeto.enums.StatusPedido;

public class PedidoDto {

	private String id;
	private String observacao;
	private double subtotal;
	private LocalDateTime dataCriacao;
	private double frete;	
	private double total;
	private StatusPedido statusPedido;
	private Avaliacao avaliacaoDoCliente;
	private Avaliacao avaliacaoDoComercio;
	private ComercioDto comercio;
	private ClienteDto cliente;
	private EnderecoDto endereco;	
	private List<ItemPedido> itensPedido;
	
	public PedidoDto(Pedido pedido) {
		this.id = pedido.getId();
		this.observacao = pedido.getObservacao();
		this.total = pedido.getTotal();
		this.frete = pedido.getFrete();
		this.subtotal = pedido.getSubtotal();
		this.statusPedido = pedido.getStatusPedido();
		this.cliente = new ClienteDto(pedido.getCliente());
		this.comercio = new ComercioDto(pedido.getComercio());
		this.endereco = new EnderecoDto(pedido.getEndereco());
		this.itensPedido = pedido.getItensPedido();
		this.avaliacaoDoCliente = pedido.getAvaliacaoDoCliente();
		this.avaliacaoDoComercio = pedido.getAvaliacaoDoComercio();
		this.dataCriacao = pedido.getDataCriacao();
	}

	public String getId() {
		return id;
	}

	public String getObservacao() {
		return observacao;
	}
	
	public StatusPedido getStatusPedido() {
		return statusPedido;
	}

	public double getTotal() {
		return total;
	}

	public List<ItemPedido> getItensPedido() {
		return itensPedido;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public double getFrete() {
		return frete;
	}	
		
	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}	
	
	public Avaliacao getAvaliacaoDoCliente() {
		return avaliacaoDoCliente;
	}

	public Avaliacao getAvaliacaoDoComercio() {
		return avaliacaoDoComercio;
	}	
		
	public ComercioDto getComercio() {
		return comercio;
	}

	public ClienteDto getCliente() {
		return cliente;
	}

	public EnderecoDto getEndereco() {
		return endereco;
	}	
	
	public static List<PedidoDto> converter(List<Pedido> pedido) {		
		return pedido.stream().map(PedidoDto::new).collect(Collectors.toList());
	}	

}
