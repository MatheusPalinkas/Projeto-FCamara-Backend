package br.com.projetofcamara.projeto.entity;

import java.util.List;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.projetofcamara.projeto.enums.TipoUsuario;

@Document("usuario")
public class Cliente extends Usuario {

	private static final long serialVersionUID = 1L;
	@DBRef
	private List<Endereco> endereco;
	
	public Cliente() {
		 this.tipoUsuario = TipoUsuario.CLIENTE;
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

}
