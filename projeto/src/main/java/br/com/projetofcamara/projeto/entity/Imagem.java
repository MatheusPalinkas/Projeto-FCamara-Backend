package br.com.projetofcamara.projeto.entity;

import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.projetofcamara.projeto.enums.TipoDetentor;

@Document
public class Imagem {
	
	@Id
	private String id;
	private Binary binario;
	private TipoDetentor detentor;
	private String codigoDetentor;
	
	public Imagem(TipoDetentor detentor, String codigoDetentor) {
		this.detentor = detentor;
		this.codigoDetentor = codigoDetentor;
	}
	
	public Imagem() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public TipoDetentor getDetentor() {
		return detentor;
	}

	public void setDetentor(TipoDetentor detentor) {
		this.detentor = detentor;
	}

	public String getCodigoDetentor() {
		return codigoDetentor;
	}

	public void setCodigoDetentor(String codigoDetentor) {
		this.codigoDetentor = codigoDetentor;
	}

	public Binary getBinario() {
		return binario;
	}

	public void setBinario(Binary binario) {
		this.binario = binario;
	}	
}
