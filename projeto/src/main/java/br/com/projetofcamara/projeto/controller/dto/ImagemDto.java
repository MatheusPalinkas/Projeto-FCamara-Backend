package br.com.projetofcamara.projeto.controller.dto;

import br.com.projetofcamara.projeto.entity.Imagem;

public class ImagemDto {

	private String id;
		
	public ImagemDto(Imagem imagem) {
		this.id = imagem.getId();		
	}	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}
