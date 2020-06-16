package br.com.projetofcamara.projeto.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.projetofcamara.projeto.entity.Comercio;
import br.com.projetofcamara.projeto.entity.Produto;

public interface ProdutoRepository extends MongoRepository<Produto, String>{

	Page<Produto> findByNomeIgnoreCaseLike(String nome, PageRequest of);
	
	Page<Produto> findByComercio(Comercio comercio, PageRequest of);	
}
