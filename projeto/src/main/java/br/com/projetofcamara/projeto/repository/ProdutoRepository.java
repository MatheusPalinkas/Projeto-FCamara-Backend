package br.com.projetofcamara.projeto.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import br.com.projetofcamara.projeto.entity.Produto;

public interface ProdutoRepository extends MongoRepository<Produto, String>{

	Page<Produto> findByNomeIgnoreCaseLike(String nome, Pageable paginacao);
	
	@Query("{ 'comercio.id' : ?0, 'nome' : {$regex : ?1, $options: 'i'}}")
	Page<Produto> findByComercioNomeIgnoreCaseLike(String idComercio, String nome, Pageable paginacao);
	
	@Query("{ 'comercio.id' : ?0, 'categoria.id' : ?1 }")
	Page<Produto> findByComercioCategoria(String idComercio, String idCategoria, Pageable paginacao);
	
	@Query("{ 'categoria.id' : ?0 }")
	Page<Produto> findByCategoria(String idCategoria, Pageable paginacao);
	
	@Query("{ 'comercio.id' : ?0 }")
	Page<Produto> findByComercio(String idComercio, Pageable paginacao);
}
