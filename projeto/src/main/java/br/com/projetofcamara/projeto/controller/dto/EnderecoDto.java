package br.com.projetofcamara.projeto.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;

import br.com.projetofcamara.projeto.entity.Endereco;

public class EnderecoDto {
	
	private String id;	
	private String nome;
	private String cep;	
	private String cidade;
	private String logradouro;
	private String numero;
	private String bairro;
	private String uf;
	private String complemento;
	
	public EnderecoDto() {
		
	}	
		
	public EnderecoDto(Endereco endereco) {
		
		this.id = endereco.getId();	
		this.nome = endereco.getNome();
		this.cep = endereco.getCep();
		this.cidade = endereco.getCidade();
		this.logradouro = endereco.getLogradouro();
		this.numero = endereco.getNumero();
		this.bairro = endereco.getBairro();
		this.uf = endereco.getUf();		
		this.complemento = endereco.getComplemento();			
	}

	public String getId() {
		return id;
	}
	
	public String getCep() {
		return cep;
	}

	public String getCidade() {
		return cidade;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public String getBairro() {
		return bairro;
	}

	public String getUf() {
		return uf;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getNome() {
		 return nome;
	}
	
	public static List<EnderecoDto> converter(Page<Endereco> endereco) {
		return endereco.stream().map(EnderecoDto::new).collect(Collectors.toList());
	}
		
}
