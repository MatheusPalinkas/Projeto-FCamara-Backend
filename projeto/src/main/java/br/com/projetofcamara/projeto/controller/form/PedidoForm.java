package br.com.projetofcamara.projeto.controller.form;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.projetofcamara.projeto.entity.Cliente;
import br.com.projetofcamara.projeto.entity.Endereco;
import br.com.projetofcamara.projeto.entity.ItemPedido;
import br.com.projetofcamara.projeto.entity.Pedido;

public class PedidoForm {
	
	private String observacao;	
	@NotNull 
	private List<ItemPedidoForm> itensPedido;
	@NotNull @NotEmpty  
	private String codigoCliente;	
	@NotNull @NotEmpty
	private String codigoEndereco;
	
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}	
	public String getCodigoEndereco() {
		return codigoEndereco;
	}
	public void setCodigoEndereco(String codigoEndereco) {
		this.codigoEndereco = codigoEndereco;
	}
	public List<ItemPedidoForm> getItensPedido() {
		return itensPedido;
	}
	public void setItensPedido(List<ItemPedidoForm> itensPedido) {
		this.itensPedido = itensPedido;
	}
	public String getCodigoCliente() {
		return codigoCliente;
	}
	public void setCodigoCliente(String codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public Pedido converter() {
		Pedido pedido = new Pedido();
		pedido.setCliente(new Cliente(codigoCliente));
		pedido.setEndereco(new Endereco(codigoEndereco));
		pedido.setItensPedido(converterListItemPedidoForm(itensPedido));	
		pedido.setObservacao(observacao);	
	
		return pedido;
	}
	
	private List<ItemPedido> converterListItemPedidoForm(List<ItemPedidoForm> itemPedido) {		
		return itemPedido.stream().map(ItemPedido::new).collect(Collectors.toList());
	}	
	
	
}
