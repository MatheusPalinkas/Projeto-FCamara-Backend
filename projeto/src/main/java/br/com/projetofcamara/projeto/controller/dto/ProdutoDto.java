package br.com.projetofcamara.projeto.controller.dto;

import java.time.LocalDateTime;
import org.springframework.data.domain.Page;
import br.com.projetofcamara.projeto.entity.Produto;

public class ProdutoDto {

	private String id;
	private String nome;
	private double preco;
	private int quantidade;
	private String descricao;
	private LocalDateTime dataCriacao;
	private String urlFoto;
	private boolean produtoDemanda;
	private boolean produtoEstoque;
	private boolean produtoDisponivel;
	private CodigoNomeDto comercio;
	private CodigoNomeDto categoria;
	
	public ProdutoDto() {
		
	}
	
	public ProdutoDto(String id) {
		this.id = id;
	}
	
	public ProdutoDto(Produto produto) {
		this.id = produto.getId();
		this.nome = produto.getNome();
		this.preco = produto.getPreco();
		this.quantidade = produto.getQuantidade();
		this.descricao = produto.getDescricao();
		this.dataCriacao = produto.getDataCriacao();
		this.urlFoto = produto.getUrlFoto();
		this.produtoEstoque = produto.isProdutoEstoque();
		this.produtoDemanda = produto.isProdutoDemanda();
		this.produtoDisponivel = produto.isProdutoDisponivel();
		this.categoria = new CodigoNomeDto(produto.getCategoria().getId(), produto.getCategoria().getNome());
		this.comercio = new CodigoNomeDto(produto.getComercio().getId(), produto.getComercio().getNome());		
	}

	public String getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public double getPreco() {
		return preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public String getDescricao() {
		return descricao;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public String getUrlFoto() {
		return urlFoto;
	}
	
	public boolean isProdutoDisponivel() {
		return produtoDisponivel;
	}

	public CodigoNomeDto getComercio() {
		return comercio;
	}

	public CodigoNomeDto getCategoria() {
		return categoria;
	}
	
	public boolean isProdutoDemanda() {
		return produtoDemanda;
	}
	
	public boolean isProdutoEstoque() {
		return produtoEstoque;
	}	
	
	public static Page<ProdutoDto> converter(Page<Produto> produto) {
		return produto.map(ProdutoDto::new);
	}	
}
