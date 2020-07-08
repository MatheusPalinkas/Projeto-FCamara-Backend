package br.com.projetofcamara.projeto.controller;

import java.io.IOException;
import java.util.Optional;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import br.com.projetofcamara.projeto.controller.dto.ImagemDto;
import br.com.projetofcamara.projeto.entity.Imagem;
import br.com.projetofcamara.projeto.service.ImagemService;

@RestController
@RequestMapping("/imagem")
public class ImagemController {

	@Autowired
	ImagemService imagemService;
	
	@GetMapping(value = "/{id}", produces = { "image/png"} )
	public ResponseEntity<byte[]> carregaImagem(@PathVariable String id) {
		Optional<Imagem> imagemBanco = imagemService.buscarImagemPeloId(id);
	
		if(imagemBanco.isPresent()) {
			return new ResponseEntity<byte[]>( imagemBanco.get().getBinario().getData(), HttpStatus.OK );
		}
		
		return ResponseEntity.notFound().build();
	}
			
	@PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<ImagemDto> adicionarImagem(@RequestParam("binario") MultipartFile binario) throws IOException{
		
		Imagem imagem = new Imagem();
		imagem.setBinario( new Binary(BsonBinarySubType.BINARY, binario.getBytes()) );				
		Optional<Imagem> imagemBd = imagemService.uploadImagem(imagem);
		
		if(imagemBd.isPresent()) {
			return new ResponseEntity<>( new ImagemDto(imagemBd.get()), HttpStatus.CREATED);
		}
		
		return ResponseEntity.badRequest().body(new ImagemDto(imagemBd.get()));
	}
		
	@DeleteMapping("/{id}")
	public ResponseEntity<?> remover(@PathVariable String id){
		
		Optional<Imagem> imagemBd = imagemService.buscarImagemPeloId(id);
		
		if(imagemBd.isPresent()) {
			imagemService.excluirImagem(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
}
