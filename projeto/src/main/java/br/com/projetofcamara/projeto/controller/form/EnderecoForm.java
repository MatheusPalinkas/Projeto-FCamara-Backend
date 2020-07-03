package br.com.projetofcamara.projeto.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import br.com.projetofcamara.projeto.entity.Endereco;

public class EnderecoForm {
	
	@NotNull @NotEmpty 
	private String cep;	
	@NotNull @NotEmpty 
	private String cidade;
	@NotNull @NotEmpty 
	private String logradouro;
	@NotNull @NotEmpty 
	private String numero;
	@NotNull @NotEmpty 
	private String bairro;
	@NotNull @NotEmpty 
	private String uf;
	@NotNull @NotEmpty 
	private String complemento;
		
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}	
	public String getComplemento() {
		return complemento;
	}	
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}	
	
	public Endereco converter() {
		
		Endereco endereco = new Endereco();	
		endereco.setComplemento(complemento);
		endereco.setLogradouro(logradouro);
		endereco.setCidade(cidade);
		endereco.setNumero(numero);
		endereco.setUf(uf);
		endereco.setBairro(bairro);
		endereco.setCep(cep);
				
		return endereco;
	}	
}
