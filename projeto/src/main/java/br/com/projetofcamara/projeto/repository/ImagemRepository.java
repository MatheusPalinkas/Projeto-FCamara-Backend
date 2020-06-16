package br.com.projetofcamara.projeto.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.projetofcamara.projeto.entity.Imagem;

public interface ImagemRepository extends MongoRepository<Imagem, String>{

}
