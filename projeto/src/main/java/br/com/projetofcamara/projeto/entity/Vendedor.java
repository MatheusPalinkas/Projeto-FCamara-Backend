package br.com.projetofcamara.projeto.entity;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import br.com.projetofcamara.projeto.enums.TipoUsuario;

@Document("usuario")
public class Vendedor extends Usuario{
	
	private static final long serialVersionUID = 1L;
	@DBRef
	private Comercio comercio;	 	
	
	public Vendedor() {
		 this.tipoUsuario = TipoUsuario.VENDEDOR;
	 }

	public Vendedor(String id) {
		this.id = id;
	}

	public Comercio getComercio() {
		return comercio;
	}

	public void setComercio(Comercio comercio) {
		this.comercio = comercio;
	}	
}
