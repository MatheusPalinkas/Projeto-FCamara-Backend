package br.com.projetofcamara.projeto.controller.dto;

import br.com.projetofcamara.projeto.entity.Categoria;

public class CategoriaDto {

	private String id;
	private String nome;
	private String descricao;
	
	public CategoriaDto() {
		
	}
	
	public CategoriaDto(Categoria categoria) {
		this.id = categoria.getId();
		this.nome = categoria.getNome();
		this.descricao = categoria.getDescricao();
	}

	public String getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}
}
