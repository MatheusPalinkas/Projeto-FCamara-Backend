package br.com.projetofcamara.projeto.service;

import java.io.IOException;
import java.util.Optional;
import br.com.projetofcamara.projeto.entity.Imagem;

public interface ImagemService {

	Optional<Imagem> uploadImagem(Imagem imagem) throws IOException;
	
	Optional<Imagem> buscarImagemPeloId(String id);		
	
	void excluirImagem(String id);
}
