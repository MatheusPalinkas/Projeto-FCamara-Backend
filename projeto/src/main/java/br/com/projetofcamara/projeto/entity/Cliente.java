package br.com.projetofcamara.projeto.entity;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import br.com.projetofcamara.projeto.enums.TipoUsuario;

@Document("usuario")
public class Cliente extends Usuario {

	private static final long serialVersionUID = 1L;
	
	private double mediaAvaliacoes;
	@DBRef
	private List<Endereco> endereco;
	private List<Favorito> favoritos;
	
	public Cliente() {
		 this.tipoUsuario = TipoUsuario.CLIENTE;	
		 endereco = new ArrayList<Endereco>();
		 favoritos = new ArrayList<Favorito>();
	 }

	public Cliente(String id) {
		this.id = id;
	}

	public List<Endereco> getEndereco() {
		return endereco;
	}

	public void setEndereco(List<Endereco> endereco) {
		this.endereco = endereco;
	}

	public double getMediaAvaliacoes() {
		return mediaAvaliacoes;
	}

	public void setMediaAvaliacoes(double mediaAvaliacoes) {
		this.mediaAvaliacoes = mediaAvaliacoes;
	}

	public List<Favorito> getFavoritos() {
		return favoritos;
	}

	public void setFavoritos(List<Favorito> favoritos) {
		this.favoritos = favoritos;
	}
}
