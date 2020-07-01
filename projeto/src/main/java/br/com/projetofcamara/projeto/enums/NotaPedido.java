package br.com.projetofcamara.projeto.enums;

public enum NotaPedido {

	UMA_ESTRELA(1),
	DUAS_ESTRELAS(2),
	TRES_ESTRELAS(3),
	QUATRO_ESTRELAS(4),
	CINCO_ESTRELAS(5);
	
	private int valor;
	
	private NotaPedido(int valor) {
		this.valor = valor;
	}

	public int getValor() {
		return valor;
	}
}
