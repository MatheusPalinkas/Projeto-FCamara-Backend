package br.com.projetofcamara.projeto.controller.dto;

import br.com.projetofcamara.projeto.entity.Comercio;
import br.com.projetofcamara.projeto.entity.Usuario;
import br.com.projetofcamara.projeto.entity.Vendedor;

public class VendedorDto extends UsuarioDto{

	private Comercio comercio;
	
	public VendedorDto() {
		super();
	}
	
	public VendedorDto(Vendedor vendedor) {
		super((Usuario) vendedor);
		this.comercio = vendedor.getComercio();
	}
	
	public Comercio getComercio() {
		return comercio;
	}	
	
}
