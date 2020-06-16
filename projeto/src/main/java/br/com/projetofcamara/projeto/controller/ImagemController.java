package br.com.projetofcamara.projeto.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.projetofcamara.projeto.controller.dto.ImagemDto;
import br.com.projetofcamara.projeto.controller.form.ImagemForm;
import br.com.projetofcamara.projeto.entity.Imagem;
import br.com.projetofcamara.projeto.enums.TipoDetentor;
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
		
	@GetMapping(value = "{tipoDetentor}/{id}")
	public ResponseEntity<List<ImagemDto>> buscarImagens(@PathVariable String tipoDetentor, @PathVariable String id) {
		Optional<List<Imagem>> imagemBanco = imagemService.buscarImagensDeUmDetentor(TipoDetentor.getEnumFromText(tipoDetentor), id);
	
		if(imagemBanco.isPresent()) {
			List<ImagemDto> listDto = new ArrayList<ImagemDto>();
			for (Imagem imagem : imagemBanco.get()) {
				listDto.add(new ImagemDto(imagem));
			}
			
			return new ResponseEntity<List<ImagemDto>>( listDto, HttpStatus.OK );
		}
	
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping("/{tipoDetentor}")
	public ResponseEntity<ImagemDto> adicionarImagem(@PathVariable String tipoDetentor, @Valid ImagemForm imagemForm) throws IOException{
		
		Imagem imagemEntity = imagemForm.converter();
		imagemEntity.setDetentor(TipoDetentor.getEnumFromText(tipoDetentor));
		Optional<Imagem> imagemBd = imagemService.uploadImagem(imagemEntity);
		
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
