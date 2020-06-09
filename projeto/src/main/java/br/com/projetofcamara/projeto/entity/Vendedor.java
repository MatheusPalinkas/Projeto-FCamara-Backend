package br.com.projetofcamara.projeto.entity;


import org.springframework.data.mongodb.core.mapping.Document;

import br.com.projetofcamara.projeto.enums.TipoUsuario;


@Document("usuario")
public class Vendedor extends Usuario{
	
	 public Vendedor() {
		 this.tipoUsuario = TipoUsuario.VENDEDOR;
	 }
}
