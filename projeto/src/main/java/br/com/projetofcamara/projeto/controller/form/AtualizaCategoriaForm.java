package br.com.projetofcamara.projeto.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.projetofcamara.projeto.entity.Categoria;

public class AtualizaCategoriaForm {

	@NotNull @NotEmpty
	private String id;
	@NotNull @NotEmpty
	private String nome;
	private String descricao;
	private boolean ativo;
		
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
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	public Categoria converter() {
		Categoria categoria = new Categoria();
		categoria.setId(id);
		categoria.setAtivo(ativo);
		categoria.setDescricao(descricao);
		categoria.setNome(nome);
		
		return categoria;
	}	
}
