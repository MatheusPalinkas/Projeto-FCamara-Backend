package br.com.projetofcamara.projeto.controller.dto;

import java.util.List;
import br.com.projetofcamara.projeto.entity.Cliente;
import br.com.projetofcamara.projeto.entity.Endereco;
import br.com.projetofcamara.projeto.entity.Favorito;
import br.com.projetofcamara.projeto.entity.Usuario;

public class ClienteDto extends UsuarioDto{
		
	private List<Favorito> favoritos;
	private List<Endereco> endereco;
	
	public ClienteDto() {
		
	}

	public ClienteDto(Cliente cliente) {	
		super((Usuario) cliente);
		this.favoritos = cliente.getFavoritos();
		this.endereco = cliente.getEndereco();
	}
	public List<Favorito> getFavoritos() {
		return favoritos;
	}
	public List<Endereco> getEndereco() {
		return endereco;
	}	
}
