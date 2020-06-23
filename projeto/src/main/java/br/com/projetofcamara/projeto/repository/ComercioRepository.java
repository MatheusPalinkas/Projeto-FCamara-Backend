package br.com.projetofcamara.projeto.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import br.com.projetofcamara.projeto.entity.Categoria;
import br.com.projetofcamara.projeto.entity.Comercio;

public interface ComercioRepository extends MongoRepository<Comercio, String>{
		
	Page<Comercio> findByNomeIgnoreCaseLike(String nome, Pageable paginacao);
	Page<Comercio> findByCategoria(Categoria categoria, Pageable paginacao);
}
