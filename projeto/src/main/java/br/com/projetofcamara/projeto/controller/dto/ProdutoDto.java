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
	private boolean produtoPorDemanda;
	private boolean produtoComEstoque;
	private boolean produtoEmEstoque;
	private CodigoNomeDto comercio;
	private CodigoNomeDto categoria;
	
	public ProdutoDto(Produto produto) {
		this.id = produto.getId();
		this.nome = produto.getNome();
		this.preco = produto.getPreco();
		this.quantidade = produto.getQuantidade();
		this.descricao = produto.getDescricao();
		this.dataCriacao = produto.getDataCriacao();
		this.urlFoto = produto.getUrlFoto();
		this.produtoEmEstoque = produto.isProdutoEmEstoque();
		this.produtoPorDemanda = produto.isProdutoPorDemanda();
		this.produtoComEstoque = produto.isProdutoComEstoque();
		if(produto.getCategoria() != null)
			this.categoria = new CodigoNomeDto(produto.getCategoria().getId(), produto.getCategoria().getNome());
		
		if(produto.getComercio() != null)
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
	
	public boolean isProdutoEmEstoque() {
		return produtoEmEstoque;
	}

	public CodigoNomeDto getComercio() {
		return comercio;
	}

	public CodigoNomeDto getCategoria() {
		return categoria;
	}
	
	public boolean isProdutoPorDemanda() {
		return produtoPorDemanda;
	}
	
	public boolean isProdutoComEstoque() {
		return produtoComEstoque;
	}	
	
	public static Page<ProdutoDto> converter(Page<Produto> produto) {
		return produto.map(ProdutoDto::new);
	}	
}
