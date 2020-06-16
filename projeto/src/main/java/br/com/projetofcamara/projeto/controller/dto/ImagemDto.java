package br.com.projetofcamara.projeto.controller.dto;

import br.com.projetofcamara.projeto.entity.Imagem;
import br.com.projetofcamara.projeto.enums.TipoDetentor;

public class ImagemDto {

	private String id;
	private TipoDetentor detentor;
	private String codigoDetentor;
	
	public ImagemDto(Imagem imagem) {
		this.id = imagem.getId();
		this.detentor = imagem.getDetentor();
		this.codigoDetentor = imagem.getCodigoDetentor();
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public TipoDetentor getDetentor() {
		return detentor;
	}
	public void setDetentor(TipoDetentor detentor) {
		this.detentor = detentor;
	}
	public String getCodigoDetentor() {
		return codigoDetentor;
	}
	public void setCodigoDetentor(String codigoDetentor) {
		this.codigoDetentor = codigoDetentor;
	}
}
