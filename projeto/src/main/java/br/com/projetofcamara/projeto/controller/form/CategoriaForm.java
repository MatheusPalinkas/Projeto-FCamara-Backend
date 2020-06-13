package br.com.projetofcamara.projeto.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.projetofcamara.projeto.entity.Categoria;

public class CategoriaForm {
	
	@NotNull @NotEmpty 
	private String nome;
	private String descricao;
	
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
	public Categoria converter() {
		Categoria categoria = new Categoria();		
		categoria.setDescricao(descricao);		
		categoria.setNome(nome);
		
		return categoria;
	}	
}
