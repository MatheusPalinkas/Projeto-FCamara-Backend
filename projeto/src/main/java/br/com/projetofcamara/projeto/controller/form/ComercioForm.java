package br.com.projetofcamara.projeto.controller.form;

import java.time.LocalTime;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import br.com.projetofcamara.projeto.entity.Categoria;
import br.com.projetofcamara.projeto.entity.Comercio;
import br.com.projetofcamara.projeto.enums.FormasPagamento;

public class ComercioForm {
	
	@NotNull @NotEmpty
	private String nome;
	private String urlFoto;	
	private String cnpj;
	@NotNull 
	private double valorEntrega;
	@NotNull @NotEmpty
	private String tempoEntrega;	
	@NotNull
	private LocalTime horarioAbertura;
	@NotNull
	private LocalTime horarioFechamento;
	@NotNull
	private boolean possuiServicoEntrega;
	@NotNull
	private boolean localAtendimento;
	@NotNull 
	private List<FormasPagamento> formasPagamento;
	@NotNull
	private Categoria categoria;
	
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
	public String getTempoEntrega() {
		return tempoEntrega;
	}
	public void setTempoEntrega(String tempoEntrega) {
		this.tempoEntrega = tempoEntrega;
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
	public List<FormasPagamento> getFormasPagamento() {
		return formasPagamento;
	}
	public void setFormasPagamento(List<FormasPagamento> formasPagamento) {
		this.formasPagamento = formasPagamento;
	}	
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
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
		comercio.setFormasPagamento(formasPagamento);
		comercio.setCategoria(categoria);
		
		return comercio;
	}
	
	
}
