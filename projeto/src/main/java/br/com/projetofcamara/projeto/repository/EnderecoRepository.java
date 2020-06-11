package br.com.projetofcamara.projeto.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.projetofcamara.projeto.entity.Endereco;

public interface EnderecoRepository extends MongoRepository<Endereco, String>{

}
