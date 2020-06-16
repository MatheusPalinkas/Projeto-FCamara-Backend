package br.com.projetofcamara.projeto.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import br.com.projetofcamara.projeto.entity.Imagem;
import br.com.projetofcamara.projeto.enums.TipoDetentor;

public interface ImagemService {

	Optional<Imagem> uploadImagem(Imagem imagem) throws IOException;
	
	Optional<Imagem> buscarImagemPeloId(String id);	
	
	Optional<List<Imagem>> buscarImagensDeUmDetentor(TipoDetentor detentor, String id);	
	
	void excluirImagem(String id);
}
