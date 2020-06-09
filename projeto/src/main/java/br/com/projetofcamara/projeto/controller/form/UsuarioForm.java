package br.com.projetofcamara.projeto.controller.form;

import java.time.LocalDate;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;


public class UsuarioForm {
	
	@NotNull @NotEmpty 
	protected String nome;
	@NotNull @NotEmpty @Email
	protected String email;
	@NotNull @NotEmpty @Length(min = 5)
	protected String senha;
	@NotNull 
	protected LocalDate dataNascimento;
	@NotNull @NotEmpty 
	protected String cpf;
	@NotNull @NotEmpty 
	protected String telefone;
	
	
	
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	
}
