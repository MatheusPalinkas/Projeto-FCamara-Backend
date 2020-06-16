package br.com.projetofcamara.projeto.service.impl;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
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
			produtoBanco.get().setQuantidade(produto.getQuantidade());
			produtoBanco.get().setUrlFoto(produto.getUrlFoto());
			produtoBanco.get().setProdutoEmEstoque(produto.isProdutoEmEstoque());
		}
		return Optional.ofNullable(produtoRepository.save(produtoBanco.get()));
	}

	@Override
	public Optional<Produto> buscarProdutoPeloId(String id) {
		return produtoRepository.findById(id);
	}

	@Override
	public Page<Produto> listarProdutosDeUmComercio(int page, int count, String ordenarPor, String direcao, String idComercio) {
		return produtoRepository.findByComercio(new Comercio(idComercio), PageRequest.of(page, count, Sort.by(Order.by(ordenarPor).with(Direction.fromString(direcao)))));
	}
	
	@Override
	public Page<Produto> listarProdutos(int page, int count, String ordenarPor, String direcao) {
		return produtoRepository.findAll(PageRequest.of(page, count, Sort.by(Order.by(ordenarPor).with(Direction.fromString(direcao)))));
	}

	@Override
	public Page<Produto> listarPorNome(String nome, int page, int count) {
		return produtoRepository.findByNomeIgnoreCaseLike(nome, PageRequest.of(page, count));
	}

	@Override
	public void excluirProduto(String id) {
		this.produtoRepository.deleteById(id);
		
	}
}

	
