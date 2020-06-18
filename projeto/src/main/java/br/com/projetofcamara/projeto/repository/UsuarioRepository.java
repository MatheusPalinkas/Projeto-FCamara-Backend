package br.com.projetofcamara.projeto.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.projetofcamara.projeto.entity.Usuario;

public interface UsuarioRepository extends MongoRepository<Usuario, String>{

	Usuario findByEmail(String email);
}
