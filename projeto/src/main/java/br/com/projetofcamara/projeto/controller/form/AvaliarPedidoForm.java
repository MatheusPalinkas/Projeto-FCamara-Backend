package br.com.projetofcamara.projeto.controller.form;

import javax.validation.constraints.NotNull;
import br.com.projetofcamara.projeto.entity.Avaliacao;
import br.com.projetofcamara.projeto.enums.NotaPedido;

public class AvaliarPedidoForm {
		
	private String comentario;
	@NotNull
	private NotaPedido notaPedido;
	@NotNull
	private boolean teveProblema;
	
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

	public Avaliacao converter() {
				
		Avaliacao avaliar = new Avaliacao();
		avaliar.setTeveProblema(teveProblema);
		avaliar.setNotaPedido(notaPedido);
		avaliar.setComentario(comentario);

		return avaliar;
	}
	
}
