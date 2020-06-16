package br.com.projetofcamara.projeto.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import br.com.projetofcamara.projeto.entity.Produto;

public class AtualizaProdutoForm {

	@NotNull @NotEmpty
	private String id;
	@NotNull @NotEmpty
	private String nome;
	@NotNull 
	private double preco;
	@NotNull
	private int quantidade;
	@NotNull @NotEmpty
	private String descricao;
	private String urlFoto;
	@NotNull
	private boolean produtoEmEstoque;
		
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getUrlFoto() {
		return urlFoto;
	}
	
	public void setUrlFoto(String urlFoto) {
		this.urlFoto = urlFoto;
	}

	public boolean isProdutoEmEstoque() {
		return produtoEmEstoque;
	}

	public void setProdutoEmEstoque(boolean produtoEmEstoque) {
		this.produtoEmEstoque = produtoEmEstoque;
	}
	
	public Produto converter() {
		Produto produto = new Produto();
		produto.setId(id);
		produto.setNome(nome);
		produto.setPreco(preco);
		produto.setQuantidade(quantidade);
		produto.setDescricao(descricao);
		produto.setUrlFoto(urlFoto);
		produto.setProdutoEmEstoque(produtoEmEstoque);		
				
		return produto;
	}		
}
