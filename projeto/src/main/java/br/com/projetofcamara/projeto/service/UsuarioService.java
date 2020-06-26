package br.com.projetofcamara.projeto.service;

import java.util.Optional;

import br.com.projetofcamara.projeto.entity.Usuario;

public interface UsuarioService {	
		
	Optional<Usuario> buscarUsuarioPeloId(String id);	
}
