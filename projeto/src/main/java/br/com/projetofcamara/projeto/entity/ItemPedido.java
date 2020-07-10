package br.com.projetofcamara.projeto.entity;

import br.com.projetofcamara.projeto.controller.dto.ProdutoDto;
import br.com.projetofcamara.projeto.controller.form.ItemPedidoForm;

public class ItemPedido {
	
	private ProdutoDto produto;	
	private int quantidade;
	private String observacao;
	private double valorProduto;

	public ItemPedido() {
	}
	
	public ItemPedido(ItemPedidoForm itemPedidoForm) {
		this.produto = new ProdutoDto(itemPedidoForm.getCodigoProduto());
		this.quantidade = itemPedidoForm.getQuantidade();
		this.observacao = itemPedidoForm.getObservacao();
		this.valorProduto = itemPedidoForm.getValorProduto();
	}
	
	public ItemPedido(String codigoProduto, int quantidade, String observacao, double valorProduto) {
		this.produto = new ProdutoDto(codigoProduto);
		this.quantidade = quantidade;
		this.observacao = observacao;
		this.valorProduto = valorProduto;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	public String getObservacao() {
		return observacao;
	}
	public ProdutoDto getProduto() {
		return produto;
	}
	public void setProduto(ProdutoDto produto) {
		this.produto = produto;
	}
	public double getValorProduto() {
		return valorProduto;
	}
	public void setValorProduto(double valorProduto) {
		this.valorProduto = valorProduto;
	}
}
