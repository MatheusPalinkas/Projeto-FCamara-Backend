package br.com.projetofcamara.projeto.entity;

import br.com.projetofcamara.projeto.enums.NotaPedido;

public class Avaliacao {
	
	private String comentario;
	private NotaPedido notaPedido;
	private boolean teveProblema;
	private String codigoAvaliador;
	private String codigoAvaliado;

	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}	
	public NotaPedido getNotaPedido() {
		return notaPedido;
	}
	public void setNotaPedido(NotaPedido notaPedido) {
		this.notaPedido = notaPedido;
	}
	public boolean isTeveProblema() {
		return teveProblema;
	}
	public void setTeveProblema(boolean teveProblema) {
		this.teveProblema = teveProblema;
	}
	public String getCodigoAvaliador() {
		return codigoAvaliador;
	}
	public void setCodigoAvaliador(String codigoAvaliador) {
		this.codigoAvaliador = codigoAvaliador;
	}
	public String getCodigoAvaliado() {
		return codigoAvaliado;
	}
	public void setCodigoAvaliado(String codigoAvaliado) {
		this.codigoAvaliado = codigoAvaliado;
	}		
}
