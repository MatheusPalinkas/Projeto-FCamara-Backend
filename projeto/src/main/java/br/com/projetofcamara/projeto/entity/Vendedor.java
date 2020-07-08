package br.com.projetofcamara.projeto.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import br.com.projetofcamara.projeto.enums.TipoUsuario;

@Document("usuario")
public class Vendedor extends Usuario{
	
	private static final long serialVersionUID = 1L;
	
	private String codigoComercio;	 	
	
	public Vendedor() {
		 this.tipoUsuario = TipoUsuario.VENDEDOR;
	 }

	public Vendedor(String id) {
		this.id = id;
	}

	public String getCodigoComercio() {
		return codigoComercio;
	}

	public void setCodigoComercio(String codigoComercio) {
		this.codigoComercio = codigoComercio;
	}

}
