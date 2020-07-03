package br.com.projetofcamara.projeto.entity;

import java.io.Serializable;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import br.com.projetofcamara.projeto.enums.TipoDetentor;

@Document
public class Endereco implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String id;	
	private String nome;
	private String cep;	
	private String cidade;
	private String logradouro;
	private String numero;
	private String bairro;
	private String uf;
	private String complemento;
	private TipoDetentor detentor;
	private String codigoDetentor;
	
	public Endereco(TipoDetentor detentor, String codigoDetentor) {
		this.detentor = detentor;
		this.codigoDetentor = codigoDetentor;
	}
	
	public Endereco(String id) {
		this.id = id;
	}

	public Endereco() {
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
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

	public TipoDetentor getDetentor() {
		return detentor;
	}

	public void setDetentor(TipoDetentor detentor) {
		this.detentor = detentor;
	}

	public String getCodigoDetentor() {
		return codigoDetentor;
	}

	public void setCodigoDetentor(String codigoDetentor) {
		this.codigoDetentor = codigoDetentor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}	
}
