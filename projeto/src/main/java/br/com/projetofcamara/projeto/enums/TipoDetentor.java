package br.com.projetofcamara.projeto.enums;

import org.springframework.util.StringUtils;

public enum TipoDetentor {

	COMERCIO,
	CLIENTE,
	PRODUTO;
	
	public static TipoDetentor getEnumFromText(String texto) {
		if(StringUtils.isEmpty(texto)) {
			return CLIENTE;
		}
		return TipoDetentor.valueOf(texto.toUpperCase());
	}
}
