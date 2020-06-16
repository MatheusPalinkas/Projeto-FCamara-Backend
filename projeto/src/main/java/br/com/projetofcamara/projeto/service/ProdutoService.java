package br.com.projetofcamara.projeto.service;

import java.util.Optional;
import org.springframework.data.domain.Page;
import br.com.projetofcamara.projeto.entity.Produto;

public interface ProdutoService {	
		
	Optional<Produto> criarProduto(Produto produto);
	
	Optional<Produto> alterarProduto(Produto produto);	

	Optional<Produto> buscarProdutoPeloId(String id);	
	
	Page<Produto> listarProdutosDeUmComercio(int page, int count, String ordenarPor, String direcao, String idComercio);
	
	Page<Produto> listarProdutos(int page, int count, String ordenarPor, String direcao);
	
	Page<Produto> listarPorNome(String nome, int page, int count);
	
	void excluirProduto(String id);	
}
