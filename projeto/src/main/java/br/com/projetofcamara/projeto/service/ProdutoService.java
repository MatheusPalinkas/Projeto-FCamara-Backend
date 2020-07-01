package br.com.projetofcamara.projeto.service;

import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import br.com.projetofcamara.projeto.entity.Produto;

public interface ProdutoService {	
		
	Optional<Produto> criarProduto(Produto produto);
	
	Optional<Produto> alterarProduto(Produto produto);	
	
	Optional<Produto> alterarEstoqueProduto(Produto produto);

	Optional<Produto> buscarProdutoPeloId(String id);	
	
	Page<Produto> listarProdutosDeUmComercio(String idComercio, Pageable paginacao);
	
	Page<Produto> listarProdutos(Pageable paginacao);
	
	Page<Produto> listarPorNome(String nome, Pageable paginacao);
	
	void excluirProduto(String id);	
}
