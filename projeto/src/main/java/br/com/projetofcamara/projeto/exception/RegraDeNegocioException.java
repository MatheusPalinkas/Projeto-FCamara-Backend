package br.com.projetofcamara.projeto.exception;

public class RegraDeNegocioException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public RegraDeNegocioException(String mensagemErro) {
		super(mensagemErro);
	}
	
	public RegraDeNegocioException(String mensagemErro, Throwable throwable) {
		super(mensagemErro, throwable);
	}
}
