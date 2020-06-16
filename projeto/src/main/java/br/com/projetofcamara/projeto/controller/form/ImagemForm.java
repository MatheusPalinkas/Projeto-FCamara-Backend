package br.com.projetofcamara.projeto.controller.form;

import java.io.IOException;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.web.multipart.MultipartFile;
import br.com.projetofcamara.projeto.entity.Imagem;

public class ImagemForm {
	
	@NotNull @NotEmpty 
	private String codigoDetentor;
	@NotNull
	private MultipartFile binario;
	

	public String getCodigoDetentor() {
		return codigoDetentor;
	}

	public void setCodigoDetentor(String codigoDetentor) {
		this.codigoDetentor = codigoDetentor;
	}

	public MultipartFile getBinario() {
		return binario;
	}

	public void setBinario(MultipartFile binario) {
		this.binario = binario;
	}
	
	public Imagem converter() throws IOException {
		
		Imagem imagem = new Imagem();
		imagem.setBinario( new Binary(BsonBinarySubType.BINARY, binario.getBytes()) );		
		imagem.setCodigoDetentor( codigoDetentor);
		
		return imagem;
	}
}
