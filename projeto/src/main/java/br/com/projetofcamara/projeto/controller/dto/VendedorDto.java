package br.com.projetofcamara.projeto.controller.dto;

import br.com.projetofcamara.projeto.entity.Usuario;
import br.com.projetofcamara.projeto.entity.Vendedor;

public class VendedorDto extends UsuarioDto{

	private String codigoComercio;
	
	public VendedorDto(Vendedor vendedor) {
		super((Usuario) vendedor);
		this.codigoComercio = vendedor.getCodigoComercio();
	}

	public String getCodigoComercio() {
		return codigoComercio;
	}
	
}
