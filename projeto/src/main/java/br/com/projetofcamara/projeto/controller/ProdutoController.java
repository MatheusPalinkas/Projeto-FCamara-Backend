package br.com.projetofcamara.projeto.controller;

import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import br.com.projetofcamara.projeto.controller.dto.EstoqueProdutoDto;
import br.com.projetofcamara.projeto.controller.dto.ProdutoDto;
import br.com.projetofcamara.projeto.controller.form.AtualizaProdutoForm;
import br.com.projetofcamara.projeto.controller.form.EstoqueForm;
import br.com.projetofcamara.projeto.controller.form.ProdutoForm;
import br.com.projetofcamara.projeto.entity.Produto;
import br.com.projetofcamara.projeto.service.ComercioService;
import br.com.projetofcamara.projeto.service.ProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	ProdutoService produtoService;
	
	@Autowired
	ComercioService comercioService;
	
	
	@GetMapping("comercio/{idComercio}")
	public Page<ProdutoDto> listaProdutoDeUmComercio(@PathVariable String idComercio, Pageable paginacao) {
		
		Page<Produto> produto = produtoService.listarProdutosDeUmComercio(idComercio, paginacao);
		return ProdutoDto.converter(produto);
	}
	
	@GetMapping
	public Page<ProdutoDto> listaProdutos(@RequestParam(required = false) String nome, Pageable paginacao){
		
		Page<Produto> produto;
		if(nome == null) {
			produto = produtoService.listarProdutos(paginacao);			
		}else {
			produto = produtoService.listarPorNome(nome, paginacao);
		}
		
		return ProdutoDto.converter(produto); 		
	}
	
	@PostMapping
	public ResponseEntity<ProdutoDto> criarProduto(@RequestBody @Valid ProdutoForm produtoForm){
		
		Produto produto = produtoForm.converter();
		
		Optional<Produto> produtoBd = produtoService.criarProduto(produto);
		
		if(produtoBd.isPresent()) {
			return new ResponseEntity<>( new ProdutoDto(produtoBd.get()), HttpStatus.CREATED);
		}
		
		return ResponseEntity.badRequest().body(new ProdutoDto(produto));
	}
	
	@PutMapping
	public ResponseEntity<ProdutoDto> atualizarProduto( @RequestBody @Valid AtualizaProdutoForm form) {
		
		Produto produto = form.converter();
		Optional<Produto> produtoBd = produtoService.alterarProduto(produto);
		
		if(produtoBd.isPresent()) {
			return new ResponseEntity<>(new ProdutoDto(produtoBd.get()), HttpStatus.OK);
		}
		
		return ResponseEntity.badRequest().body(new ProdutoDto(produto));	
	}
	
	@PutMapping("/estoque")
	public ResponseEntity<EstoqueProdutoDto> atualizaEstoqueProduto( @RequestBody @Valid EstoqueForm form) {
		
		Produto produto = form.converter();
		Optional<Produto> produtoBd = produtoService.alterarEstoqueProduto(produto);
		
		if(produtoBd.isPresent()) {
			return new ResponseEntity<>(new EstoqueProdutoDto(produtoBd.get()), HttpStatus.OK);
		}
		
		return ResponseEntity.badRequest().body(new EstoqueProdutoDto(produto));	
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProdutoDto> buscarProdutoPeloId(@PathVariable String id){
		
		Optional<Produto> produtoBd = produtoService.buscarProdutoPeloId(id);
		
		if(produtoBd.isPresent()) {
			return ResponseEntity.ok( new ProdutoDto(produtoBd.get()));
		}
		
		return ResponseEntity.notFound().build();
	}	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> remover(@PathVariable String id){
		
		Optional<Produto> produtoBd = produtoService.buscarProdutoPeloId(id);
		
		if(produtoBd.isPresent()) {
			produtoService.excluirProduto(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}

}
