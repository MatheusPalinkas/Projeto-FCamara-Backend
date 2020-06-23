package br.com.projetofcamara.projeto.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import br.com.projetofcamara.projeto.enums.StatusPedido;

@Document
public class Pedido {

	@Id
	private String id;
	private String observacao;
	private double total;
	private StatusPedido statusPedido;
	@DBRef
	private Comercio comercio;
	@DBRef
	private Cliente cliente;
	@DBRef
	private Endereco endereco;	
	private List<ItemPedido> itensPedido;
	
	public Pedido() {
		this.statusPedido = StatusPedido.PENDENTE;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	public StatusPedido getStatusPedido() {
		return statusPedido;
	}
	public void setStatusPedido(StatusPedido statusPedido) {
		this.statusPedido = statusPedido;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public List<ItemPedido> getItensPedido() {
		return itensPedido;
	}
	public void setItensPedido(List<ItemPedido> itensPedido) {
		this.itensPedido = itensPedido;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Comercio getComercio() {
		return comercio;
	}

	public void setComercio(Comercio comercio) {
		this.comercio = comercio;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
		
}
