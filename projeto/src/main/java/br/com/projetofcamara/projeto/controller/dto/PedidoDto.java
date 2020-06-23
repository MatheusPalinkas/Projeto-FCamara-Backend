package br.com.projetofcamara.projeto.controller.dto;

import java.util.List;
import org.springframework.data.domain.Page;
import br.com.projetofcamara.projeto.entity.Cliente;
import br.com.projetofcamara.projeto.entity.Comercio;
import br.com.projetofcamara.projeto.entity.Endereco;
import br.com.projetofcamara.projeto.entity.ItemPedido;
import br.com.projetofcamara.projeto.entity.Pedido;
import br.com.projetofcamara.projeto.enums.StatusPedido;

public class PedidoDto {

	private String id;
	private String observacao;
	private double total;
	private StatusPedido statusPedido;
	private Comercio comercio;
	private Cliente cliente;
	private Endereco endereco;
	private List<ItemPedido> itensPedido;
	
	public PedidoDto(Pedido pedido) {
		this.id = pedido.getId();
		this.observacao = pedido.getObservacao();
		this.total = pedido.getTotal();
		this.statusPedido = pedido.getStatusPedido();
		this.comercio = pedido.getComercio();
		this.cliente = pedido.getCliente();
		this.endereco = pedido.getEndereco();
		this.itensPedido = pedido.getItensPedido();
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

	public Comercio getComercio() {
		return comercio;
	}

	public Cliente getCliente() {
		return cliente;
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

	public static Page<PedidoDto> converter(Page<Pedido> pedido) {
		return pedido.map(PedidoDto::new);
	}

}
