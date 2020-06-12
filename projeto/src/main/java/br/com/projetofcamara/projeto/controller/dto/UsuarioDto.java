package br.com.projetofcamara.projeto.controller.dto;

import java.time.LocalDate;

import br.com.projetofcamara.projeto.entity.Usuario;

public class UsuarioDto {

	private String id;
	private String nome;
	private String email;
	private LocalDate dataNascimento;	
	private String cpf;
	private String telefone;	

	public UsuarioDto(Usuario usuario) {
		
		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.email = usuario.getEmail();
		this.dataNascimento = usuario.getDataNascimento();
		this.cpf = usuario.getCpf();
		this.telefone = usuario.getTelefone();		
	}

	public String getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public String getTelefone() {
		return telefone;
	}	
	
}
