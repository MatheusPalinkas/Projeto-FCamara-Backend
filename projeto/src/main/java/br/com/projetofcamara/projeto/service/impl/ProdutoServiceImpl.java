package br.com.projetofcamara.projeto.service.impl;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import br.com.projetofcamara.projeto.entity.Comercio;
import br.com.projetofcamara.projeto.entity.Produto;
import br.com.projetofcamara.projeto.repository.ProdutoRepository;
import br.com.projetofcamara.projeto.service.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService{
	
	@Autowired
	ProdutoRepository produtoRepository;

	@Override
	public Optional<Produto> criarProduto(Produto produto) {
		return Optional.ofNullable(produtoRepository.save(produto));
	}

	@Override
	public Optional<Produto> alterarProduto(Produto produto) {
		
		Optional<Produto> produtoBanco = produtoRepository.findById(produto.getId());
		if(produtoBanco.isPresent()) {
			produtoBanco.get().setCategoria(produto.getCategoria());
			produtoBanco.get().setDescricao(produto.getDescricao());
			produtoBanco.get().setNome(produto.getNome());
			produtoBanco.get().setPreco(produto.getPreco());			
			produtoBanco.get().setUrlFoto(produto.getUrlFoto());			
		}
		return Optional.ofNullable(produtoRepository.save(produtoBanco.get()));
	}

	@Override
	public Optional<Produto> buscarProdutoPeloId(String id) {
		return produtoRepository.findById(id);
	}

	@Override
	public Page<Produto> listarProdutosDeUmComercio(String idComercio, Pageable paginacao) {
		return produtoRepository.findByComercio(new Comercio(idComercio), paginacao);
	}
	
	@Override
	public Page<Produto> listarProdutos(Pageable paginacao) {
		return produtoRepository.findAll(paginacao);
	}

	@Override
	public Page<Produto> listarPorNome(String nome, Pageable paginacao) {
		return produtoRepository.findByNomeIgnoreCaseLike(nome, paginacao);
	}

	@Override
	public void excluirProduto(String id) {
		this.produtoRepository.deleteById(id);
		
	}

	@Override
	public Optional<Produto> alterarEstoqueProduto(Produto produto) {
		
		Optional<Produto> produtoBanco = produtoRepository.findById(produto.getId());
		if(produtoBanco.isPresent()) {			
			produtoBanco.get().setQuantidade(produto.getQuantidade());
			produtoBanco.get().setProdutoEmEstoque(produto.isProdutoEmEstoque());			
		}
		return Optional.ofNullable(produtoRepository.save(produtoBanco.get()));
	}
}

	
