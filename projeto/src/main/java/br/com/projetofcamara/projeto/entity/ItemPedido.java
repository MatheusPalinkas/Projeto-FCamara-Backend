package br.com.projetofcamara.projeto.entity;

public class ItemPedido {
	
	private String codigoProduto;	
	private int quantidade;
	private String observacao;
	
	
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public String getCodigoProduto() {
		return codigoProduto;
	}
	public void setCodigoProduto(String codigoProduto) {
		this.codigoProduto = codigoProduto;
	}	
}
