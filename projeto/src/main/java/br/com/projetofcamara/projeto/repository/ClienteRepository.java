package br.com.projetofcamara.projeto.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.projetofcamara.projeto.entity.Cliente;

public interface ClienteRepository extends MongoRepository<Cliente, String>{

	Cliente findByEmail(String email);
}
