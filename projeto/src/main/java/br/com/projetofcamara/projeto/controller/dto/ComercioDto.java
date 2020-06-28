package br.com.projetofcamara.projeto.controller.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import org.springframework.data.domain.Page;
import br.com.projetofcamara.projeto.entity.Comercio;

public class ComercioDto {

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
	private String idCategoria;
	private String idEndereco;
	private String idVendedor;
	
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
		this.pagamentoCartao = comercio.isPagamentoCartao();
		this.pagamentoDinheiro = comercio.isPagamentoDinheiro();
		this.localAtendimento = comercio.isLocalAtendimento();
		this.possuiServicoEntrega = comercio.isPossuiServicoEntrega();
		this.idCategoria = comercio.getIdCategoria();
		this.idEndereco = comercio.getIdEndereco();
		this.idVendedor = comercio.getIdVendedor();
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

	public LocalTime getTempoEntrega() {
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

	public boolean isPagamentoCartao() {
		return pagamentoCartao;
	}

	public boolean isPagamentoDinheiro() {
		return pagamentoDinheiro;
	}

	public String getIdCategoria() {
		return idCategoria;
	}

	public String getIdEndereco() {
		return idEndereco;
	}
	
	public String getIdVendedor() {
		return idVendedor;
	}

	public static Page<ComercioDto> converter(Page<Comercio> comercio) {
		return comercio.map(ComercioDto::new);
	}
	
}
