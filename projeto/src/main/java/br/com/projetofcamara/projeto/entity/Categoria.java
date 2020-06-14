package br.com.projetofcamara.projeto.entity;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Categoria {

	@Id
	private String id;
	private String nome;
	private String descricao;
	private boolean ativo;
	
	public Categoria(boolean ativo) {
		this.ativo = ativo;
	}
	public Categoria() {
		this.ativo = true;
	}
	public Categoria(String id) {
		this.id = id;
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
}
