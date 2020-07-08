package br.com.projetofcamara.projeto.service.impl;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import br.com.projetofcamara.projeto.entity.Categoria;
import br.com.projetofcamara.projeto.entity.Comercio;
import br.com.projetofcamara.projeto.entity.Produto;
import br.com.projetofcamara.projeto.exception.RegraDeNegocioException;
import br.com.projetofcamara.projeto.repository.ProdutoRepository;
import br.com.projetofcamara.projeto.service.CategoriaService;
import br.com.projetofcamara.projeto.service.ComercioService;
import br.com.projetofcamara.projeto.service.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService{
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@Autowired
	ComercioService comercioService;
	
	@Autowired
	CategoriaService categoriaService;

	@Override
	public Optional<Produto> criarProduto(Produto produto) {
		
		Optional<Comercio> comercioBd = comercioService.buscarComercioPeloId(produto.getComercio().getId());
		Optional<Categoria> categoriaBd = categoriaService.buscarCategoriaPeloId(produto.getCategoria().getId());
		
		if(!comercioBd.isPresent()) {
			throw new RegraDeNegocioException("Comercio inexistente");
		}
		
		if(!categoriaBd.isPresent()) {
			throw new RegraDeNegocioException("Categoria inexistente");
		}
		
		if(!produto.isProdutoDemanda() && !produto.isProdutoEstoque()) {
			throw new RegraDeNegocioException("É necessario selecionar uma das opções: Estoque ou Encomenda");
		}
		return Optional.ofNullable(produtoRepository.save(produto));
	}

	@Override
	public Optional<Produto> alterarProduto(Produto produto) {
		
		Optional<Produto> produtoBanco = produtoRepository.findById(produto.getId());
		if(produtoBanco.isPresent()) {
			
			produtoBanco.get().setDescricao(produto.getDescricao());
			produtoBanco.get().setNome(produto.getNome());
			produtoBanco.get().setPreco(produto.getPreco());			
			produtoBanco.get().setUrlFoto(produto.getUrlFoto());			
		}else {
			throw new RegraDeNegocioException("Produto não existe");
		}
		return Optional.ofNullable(produtoRepository.save(produtoBanco.get()));
	}

	@Override
	public Optional<Produto> buscarProdutoPeloId(String id) {
		return produtoRepository.findById(id);
	}

	@Override
	public Page<Produto> listarProdutosDeUmComercio(String idComercio, Pageable paginacao) {		
		return produtoRepository.findByComercio(idComercio, paginacao);
	}
	
	@Override
	public Page<Produto> listarProdutosComercioPorNome(String idComercio, String nome, Pageable paginacao) {			
		return produtoRepository.findByComercioNomeIgnoreCaseLike(idComercio, nome, paginacao);
	}
	
	@Override
	public Page<Produto> listarProdutosComercioPorCategoria(String idComercio, String idCategoria, Pageable paginacao) {		
		return produtoRepository.findByComercioCategoria( idComercio, idCategoria, paginacao);
	}
	
	@Override
	public Page<Produto> listarProdutos(Pageable paginacao) {
		return produtoRepository.findAll(paginacao);
	}

	@Override
	public Page<Produto> listarProdutoPorNome(String nome, Pageable paginacao) {
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
			produtoBanco.get().setProdutoDisponivel(produto.isProdutoDisponivel());			
		}else {
			throw new RegraDeNegocioException("Produto não existe");
		}
		return Optional.ofNullable(produtoRepository.save(produtoBanco.get()));
	}
	
}

	
