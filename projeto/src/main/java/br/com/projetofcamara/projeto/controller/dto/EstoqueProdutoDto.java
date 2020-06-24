package br.com.projetofcamara.projeto.controller.dto;

import br.com.projetofcamara.projeto.entity.Produto;

public class EstoqueProdutoDto {

	private String id;	
	private String nome;
	private int quantidade;	
	private boolean produtoEmEstoque;
		
	public EstoqueProdutoDto(Produto produto) {
		this.id = produto.getId();	
		this.nome = produto.getNome();
		this.quantidade = produto.getQuantidade();		
		this.produtoEmEstoque = produto.isProdutoEmEstoque();
	}

	public String getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public boolean isProdutoEmEstoque() {
		return produtoEmEstoque;
	}
	
}
