package br.com.projetofcamara.projeto.entity;

import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Imagem {
	
	@Id
	private String id;
	private Binary binario;
		
	public Imagem() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Binary getBinario() {
		return binario;
	}

	public void setBinario(Binary binario) {
		this.binario = binario;
	}	
}
