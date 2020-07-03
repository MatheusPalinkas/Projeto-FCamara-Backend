package br.com.projetofcamara.projeto.controller.dto;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.domain.Page;
import br.com.projetofcamara.projeto.entity.Avaliacao;
import br.com.projetofcamara.projeto.entity.Cliente;
import br.com.projetofcamara.projeto.entity.Comercio;
import br.com.projetofcamara.projeto.entity.Endereco;
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
	private Comercio comercio;
	private Cliente cliente;
	private Endereco endereco;
	private List<ItemPedido> itensPedido;
	
	public PedidoDto(Pedido pedido) {
		this.id = pedido.getId();
		this.observacao = pedido.getObservacao();
		this.total = pedido.getTotal();
		this.frete = pedido.getFrete();
		this.subtotal = pedido.getSubtotal();
		this.statusPedido = pedido.getStatusPedido();
		this.cliente = pedido.getCliente();
		this.comercio = pedido.getComercio();
		this.endereco = pedido.getEndereco();
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
	
	public Endereco getEndereco() {
		return endereco;
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
	
	public Comercio getComercio() {
		return comercio;
	}

	public Cliente getCliente() {
		return cliente;
	}
	
	public static Page<PedidoDto> converter(Page<Pedido> pedido) {
		return pedido.map(PedidoDto::new);
	}	

}
