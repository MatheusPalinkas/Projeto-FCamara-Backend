package br.com.projetofcamara.projeto.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import br.com.projetofcamara.projeto.entity.Produto;

public class ProdutoForm {
	
	@NotNull @NotEmpty
	private String nome;
	@NotNull 
	private double preco;
	@NotNull
	private int quantidade;
	@NotNull @NotEmpty
	private String descricao;
	private String urlFoto;	
	@NotNull @NotEmpty
	private String idComercio;
	@NotNull @NotEmpty
	private String idCategoria;	
	
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
	
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}	
	public String getIdComercio() {
		return idComercio;
	}
	public void setIdComercio(String idComercio) {
		this.idComercio = idComercio;
	}
	public String getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(String idCategoria) {
		this.idCategoria = idCategoria;
	}	
	
	public Produto converter() {
		Produto produto = new Produto();
		produto.setNome(nome);
		produto.setPreco(preco);
		produto.setQuantidade(quantidade);
		produto.setDescricao(descricao);
		produto.setUrlFoto(urlFoto);		
		produto.setIdComercio(idComercio);
		produto.setIdCategoria(idCategoria);
		
		return produto;
	}
	
}
