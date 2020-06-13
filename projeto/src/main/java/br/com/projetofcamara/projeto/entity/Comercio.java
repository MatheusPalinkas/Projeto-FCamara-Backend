package br.com.projetofcamara.projeto.entity;

import java.time.LocalTime;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import br.com.projetofcamara.projeto.enums.FormasPagamento;

@Document
public class Comercio {

	@Id
	private String id;
	private String nome;
	private String urlFoto;
	private String cnpj;
	private String valorEntrega;
	private String tempoEntrega;
	private LocalTime horarioAbertura;
	private LocalTime horarioFechamento;
	private boolean possuiServicoEntrega = true;
	private boolean localAtendimento = false;
	private List<FormasPagamento> formasPagamento;
	@DBRef(lazy = true)
	private Endereco endereco;	
	
	public Comercio() {
		
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

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
}
