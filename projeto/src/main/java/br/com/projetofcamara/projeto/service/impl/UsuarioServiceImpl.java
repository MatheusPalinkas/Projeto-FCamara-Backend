package br.com.projetofcamara.projeto.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projetofcamara.projeto.entity.Usuario;
import br.com.projetofcamara.projeto.repository.UsuarioRepository;
import br.com.projetofcamara.projeto.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	UsuarioRepository usuarioRepository;

	@Override
	public Optional<Usuario> buscarUsuarioPeloId(String id) {		
		return usuarioRepository.findById(id);
	}

}
