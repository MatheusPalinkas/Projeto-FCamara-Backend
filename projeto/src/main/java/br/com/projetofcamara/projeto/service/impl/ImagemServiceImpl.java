package br.com.projetofcamara.projeto.service.impl;

import java.io.IOException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.projetofcamara.projeto.entity.Imagem;
import br.com.projetofcamara.projeto.repository.ImagemRepository;
import br.com.projetofcamara.projeto.service.ImagemService;

@Service
public class ImagemServiceImpl implements ImagemService{

	@Autowired
	ImagemRepository imagemRepository;
		
	@Override
	public Optional<Imagem> uploadImagem(Imagem imagem) throws IOException {		
		return Optional.ofNullable( imagemRepository.insert(imagem) );
	}

	@Override
	public Optional<Imagem> buscarImagemPeloId(String id) {
		return imagemRepository.findById(id);
	}
	
	@Override
	public void excluirImagem(String id) {
		this.imagemRepository.deleteById(id);		
	}

}
