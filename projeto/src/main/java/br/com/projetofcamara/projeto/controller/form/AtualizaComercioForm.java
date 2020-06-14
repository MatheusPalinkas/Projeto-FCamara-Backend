package br.com.projetofcamara.projeto.controller.form;

import java.time.LocalTime;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.projetofcamara.projeto.entity.Comercio;
import br.com.projetofcamara.projeto.enums.FormasPagamento;

public class AtualizaComercioForm {
	
	@NotNull @NotEmpty
	private String id;
	private String urlFoto;
	@NotNull @NotEmpty
	private String valorEntrega;
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
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getValorEntrega() {
		return valorEntrega;
	}
	public void setValorEntrega(String valorEntrega) {
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
	public String getUrlFoto() {
		return urlFoto;
	}
	public void setUrlFoto(String urlFoto) {
		this.urlFoto = urlFoto;
	}
	
	public Comercio converter() {
		Comercio comercio = new Comercio();
		comercio.setId(id);
		comercio.setUrlFoto(urlFoto);
		comercio.setValorEntrega(valorEntrega);
		comercio.setTempoEntrega(tempoEntrega);
		comercio.setHorarioAbertura(horarioAbertura);
		comercio.setHorarioFechamento(horarioFechamento);
		comercio.setPossuiServicoEntrega(possuiServicoEntrega);
		comercio.setLocalAtendimento(localAtendimento);
		comercio.setFormasPagamento(formasPagamento);
		
		return comercio;
	}			
}
