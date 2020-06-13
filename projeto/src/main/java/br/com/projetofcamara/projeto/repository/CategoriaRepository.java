package br.com.projetofcamara.projeto.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.projetofcamara.projeto.entity.Categoria;

public interface CategoriaRepository extends MongoRepository<Categoria, String>{
		
	List<Categoria> findByAtivo(boolean ativo);  
}
