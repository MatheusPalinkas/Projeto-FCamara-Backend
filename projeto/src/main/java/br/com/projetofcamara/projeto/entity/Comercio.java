package br.com.projetofcamara.projeto.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Comercio {

	@Id
	private String id;
	private String nome;
	private String urlFoto;
	private String cnpj;
	private double valorEntrega;
	private LocalTime tempoEntrega;
	private LocalDate dataCriacao;
	private LocalTime horarioAbertura;
	private LocalTime horarioFechamento;
	private boolean possuiServicoEntrega;
	private boolean localAtendimento;
	private boolean pagamentoCartao;
	private boolean pagamentoDinheiro;
	@DBRef
	private Categoria categoria;
	@DBRef
	private Endereco endereco;
	@DBRef
	private Vendedor vendedor;	
	private double mediaAvaliacoes;
	
	public Comercio() {
		this.possuiServicoEntrega = true;
		this.localAtendimento = false;
		this.dataCriacao = LocalDate.now();
	}
	
	public Comercio(String id) {
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

	public String getUrlFoto() {
		return urlFoto;
	}

	public void setUrlFoto(String urlFoto) {
		this.urlFoto = urlFoto;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public double getValorEntrega() {
		return valorEntrega;
	}

	public void setValorEntrega(double valorEntrega) {
		this.valorEntrega = valorEntrega;
	}	

	public LocalTime getHorarioAbertura() {
		return horarioAbertura;
	}

	public void setHorarioAbertura(LocalTime horarioAbertura) {
		this.horarioAbertura = horarioAbertura;
	}

	public LocalTime getHorarioFechamento() {
		return horarioFechamento;
	}

	public void setHorarioFechamento(LocalTime horarioFechamento) {
		this.horarioFechamento = horarioFechamento;
	}

	public boolean isPossuiServicoEntrega() {
		return possuiServicoEntrega;
	}

	public void setPossuiServicoEntrega(boolean possuiServicoEntrega) {
		this.possuiServicoEntrega = possuiServicoEntrega;
	}

	public boolean isLocalAtendimento() {
		return localAtendimento;
	}

	public void setLocalAtendimento(boolean localAtendimento) {
		this.localAtendimento = localAtendimento;
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public boolean isPagamentoCartao() {
		return pagamentoCartao;
	}

	public void setPagamentoCartao(boolean pagamentoCartao) {
		this.pagamentoCartao = pagamentoCartao;
	}

	public boolean isPagamentoDinheiro() {
		return pagamentoDinheiro;
	}

	public void setPagamentoDinheiro(boolean pagamentoDinheiro) {
		this.pagamentoDinheiro = pagamentoDinheiro;
	}

	public LocalTime getTempoEntrega() {
		return tempoEntrega;
	}

	public void setTempoEntrega(LocalTime tempoEntrega) {
		this.tempoEntrega = tempoEntrega;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public double getMediaAvaliacoes() {
		return mediaAvaliacoes;
	}

	public void setMediaAvaliacoes(double mediaAvaliacoes) {
		this.mediaAvaliacoes = mediaAvaliacoes;
	}

}
