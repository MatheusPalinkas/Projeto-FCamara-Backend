package br.com.projetofcamara.projeto.entity;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.projetofcamara.projeto.enums.TipoUsuario;

@Document("usuario")
public class Cliente extends Usuario {

	@DBRef(lazy = true)
	List<Endereco> endereco;
	
	public Cliente() {
		 this.tipoUsuario = TipoUsuario.CLIENTE;
	 }
	
	
}
