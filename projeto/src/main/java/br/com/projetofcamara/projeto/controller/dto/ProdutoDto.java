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
		this.comercio = new CodigoNomeDto(produto.getComercio().getId(), produto.getComercio().getNome());
		this.categoria = new CodigoNomeDto(produto.getCategoria().getId(), produto.getCategoria().getNome());
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
	
	public static Page<ProdutoDto> converter(Page<Produto> produto) {
		return produto.map(ProdutoDto::new);
	}
	
}
