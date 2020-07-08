package br.com.projetofcamara.projeto.controller.form;

import javax.validation.constraints.NotBlank;

public class AtualizarUsuarioForm {

	@NotBlank
	protected String id;
	@NotBlank
	protected String nome;
	@NotBlank
	protected String telefone;
	protected String senha;
	
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
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}	
}
