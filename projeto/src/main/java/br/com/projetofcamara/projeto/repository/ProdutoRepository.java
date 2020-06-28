package br.com.projetofcamara.projeto.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import br.com.projetofcamara.projeto.entity.Produto;

public interface ProdutoRepository extends MongoRepository<Produto, String>{

	Page<Produto> findByNomeIgnoreCaseLike(String nome, Pageable paginacao);
	
	Page<Produto> findByIdComercio(String idComercio, Pageable paginacao);	
}
