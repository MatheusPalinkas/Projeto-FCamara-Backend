package br.com.projetofcamara.projeto.controller.form;

public class ItemPedidoForm {
	
	private String codigoProduto;	
	private int quantidade;
	private String observacao;
	private double valorProduto;

	public ItemPedidoForm(String codigoProduto, int quantidade, String observacao, double valorProduto) {
		this.codigoProduto = codigoProduto;
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
	public String getCodigoProduto() {
		return codigoProduto;
	}
	public double getValorProduto() {
		return valorProduto;
	}
	public void setValorProduto(double valorProduto) {
		this.valorProduto = valorProduto;
	}
}
