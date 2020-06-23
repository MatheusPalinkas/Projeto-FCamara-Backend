package br.com.projetofcamara.projeto.controller.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.core.mapping.DBRef;
import br.com.projetofcamara.projeto.entity.Categoria;
import br.com.projetofcamara.projeto.entity.Comercio;
import br.com.projetofcamara.projeto.entity.Endereco;
import br.com.projetofcamara.projeto.enums.FormasPagamento;

public class ComercioDto {

	private String id;
	private String nome;
	private String urlFoto;
	private String cnpj;
	private double valorEntrega;
	private String tempoEntrega;
	private LocalDate dataCriacao;
	private LocalTime horarioAbertura;
	private LocalTime horarioFechamento;
	private boolean possuiServicoEntrega;
	private boolean localAtendimento;
	private List<FormasPagamento> formasPagamento;
	@DBRef(lazy = true)
	private Endereco endereco;
	@DBRef
	private Categoria categoria;
	
	public ComercioDto(Comercio comercio) {
		this.id = comercio.getId();
		this.nome = comercio.getNome();
		this.urlFoto = comercio.getUrlFoto();
		this.cnpj = comercio.getCnpj();
		this.tempoEntrega = comercio.getTempoEntrega();
		this.valorEntrega = comercio.getValorEntrega();
		this.dataCriacao = comercio.getDataCriacao();
		this.horarioAbertura = comercio.getHorarioAbertura();
		this.horarioFechamento = comercio.getHorarioFechamento();
		this.formasPagamento = comercio.getFormasPagamento();
		this.localAtendimento = comercio.isLocalAtendimento();
		this.possuiServicoEntrega = comercio.isPossuiServicoEntrega();
		this.categoria = comercio.getCategoria();
		this.endereco = comercio.getEndereco();		
	}

	public String getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getUrlFoto() {
		return urlFoto;
	}

	public String getCnpj() {
		return cnpj;
	}

	public double getValorEntrega() {
		return valorEntrega;
	}

	public String getTempoEntrega() {
		return tempoEntrega;
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public LocalTime getHorarioAbertura() {
		return horarioAbertura;
	}

	public LocalTime getHorarioFechamento() {
		return horarioFechamento;
	}

	public boolean isPossuiServicoEntrega() {
		return possuiServicoEntrega;
	}

	public boolean isLocalAtendimento() {
		return localAtendimento;
	}

	public List<FormasPagamento> getFormasPagamento() {
		return formasPagamento;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public static Page<ComercioDto> converter(Page<Comercio> comercio) {
		return comercio.map(ComercioDto::new);
	}
}
