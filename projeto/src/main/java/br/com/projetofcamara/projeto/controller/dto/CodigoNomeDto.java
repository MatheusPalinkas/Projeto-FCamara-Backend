package br.com.projetofcamara.projeto.controller.dto;

public class CodigoNomeDto {

	private String id;
	private String nome;
	
	
	public CodigoNomeDto(String id, String nome) {
		
		this.id = id;
		this.nome = nome;
	}

	public String getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
}
