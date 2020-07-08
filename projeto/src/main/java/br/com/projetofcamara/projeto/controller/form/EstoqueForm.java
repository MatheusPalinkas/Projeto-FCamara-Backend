package br.com.projetofcamara.projeto.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import br.com.projetofcamara.projeto.entity.Produto;

public class EstoqueForm {

	@NotNull @NotEmpty
	private String id;
	@NotNull
	private int quantidade;
	@NotNull
	private boolean produtoDisponivel;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public boolean isProdutoEmEstoque() {
		return produtoDisponivel;
	}
	public void setProdutoDisponivel(boolean produtoDisponivel) {
		this.produtoDisponivel = produtoDisponivel;
	}
	public Produto converter() {
		Produto produto = new Produto();
		produto.setId(id);
		produto.setQuantidade(quantidade);
		produto.setProdutoDisponivel(produtoDisponivel);
		
		return produto;
	}	
}
