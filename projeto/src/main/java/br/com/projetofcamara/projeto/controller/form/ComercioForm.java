package br.com.projetofcamara.projeto.controller.form;

import java.time.LocalTime;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import br.com.projetofcamara.projeto.entity.Categoria;
import br.com.projetofcamara.projeto.entity.Comercio;
import br.com.projetofcamara.projeto.entity.Endereco;

public class ComercioForm {
	
	@NotNull @NotEmpty
	private String nome;
	private String urlFoto;	
	private String cnpj;
	@NotNull 
	private double valorEntrega;
	@NotNull 
	private LocalTime tempoEntrega;	
	@NotNull
	private LocalTime horarioAbertura;
	@NotNull
	private LocalTime horarioFechamento;
	@NotNull
	private boolean possuiServicoEntrega;
	@NotNull
	private boolean localAtendimento;
	@NotNull
	private boolean pagamentoCartao;
	@NotNull
	private boolean pagamentoDinheiro;
	@NotNull @NotEmpty
	private String codigoCategoria;
	@NotNull @NotEmpty
	private String codigoEndereco;	
	
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
	public LocalTime getTempoEntrega() {
		return tempoEntrega;
	}
	public void setTempoEntrega(LocalTime tempoEntrega) {
		this.tempoEntrega = tempoEntrega;
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
	public String getCodigoCategoria() {
		return codigoCategoria;
	}
	public void setCodigoCategoria(String codigoCategoria) {
		this.codigoCategoria = codigoCategoria;
	}
	public String getCodigoEndereco() {
		return codigoEndereco;
	}
	public void setCodigoEndereco(String codigoEndereco) {
		this.codigoEndereco = codigoEndereco;
	}
		
	public Comercio converter() {
		Comercio comercio = new Comercio();
		comercio.setNome(nome);
		comercio.setUrlFoto(urlFoto);
		comercio.setCnpj(cnpj);
		comercio.setValorEntrega(valorEntrega);
		comercio.setTempoEntrega(tempoEntrega);
		comercio.setHorarioAbertura(horarioAbertura);
		comercio.setHorarioFechamento(horarioFechamento);
		comercio.setPossuiServicoEntrega(possuiServicoEntrega);
		comercio.setLocalAtendimento(localAtendimento);
		comercio.setPagamentoCartao(pagamentoCartao);
		comercio.setPagamentoDinheiro(pagamentoDinheiro);
		comercio.setEndereco(new Endereco (codigoEndereco));		
		comercio.setCategoria(new Categoria (codigoCategoria));
		
		return comercio;
	}	
}
