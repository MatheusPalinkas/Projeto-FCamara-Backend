package br.com.projetofcamara.projeto.controller;

import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import br.com.projetofcamara.projeto.controller.dto.ComercioDto;
import br.com.projetofcamara.projeto.controller.form.AtualizaComercioForm;
import br.com.projetofcamara.projeto.controller.form.ComercioForm;
import br.com.projetofcamara.projeto.entity.Comercio;
import br.com.projetofcamara.projeto.service.ComercioService;


@RestController
@RequestMapping("/comercio")
public class ComercioController {
	
	@Autowired
	ComercioService comercioService;
	
	@GetMapping
	public Page<ComercioDto> listaComercio(@RequestParam(required = false) String nome, String idcategoria) {
		
		if (nome != null && idcategoria == null) {
			Page<Comercio> comercio = comercioService.listarPorNome(nome, 0, 10);
			return ComercioDto.converter(comercio);
			
		} 
		if(nome == null && idcategoria != null) {
			Page<Comercio> comercio = comercioService.listarPorCategoria(idcategoria, 0, 10);
			return ComercioDto.converter(comercio);
			
		} 
		if(nome == null && idcategoria == null) {
			Page<Comercio> comercio = comercioService.listarTodosComercios(0, 10);
			return ComercioDto.converter(comercio);
		}
		return null;		
	}
	
	@PostMapping
	public ResponseEntity<ComercioDto> criarComercio(@RequestBody @Valid ComercioForm ComercioForm){
		
		 Comercio comercio = ComercioForm.converter();
		
		Optional<Comercio> ComercioBd = comercioService.criarComercio(comercio);
		
		if(ComercioBd.isPresent()) {
			return new ResponseEntity<>( new ComercioDto(ComercioBd.get()), HttpStatus.CREATED);
		}
		
		return ResponseEntity.badRequest().body(new ComercioDto(comercio));
	}
	
	@PutMapping
	public ResponseEntity<ComercioDto> atualizarComercio( @RequestBody @Valid AtualizaComercioForm form) {
		
		Comercio comercio = form.converter();
		Optional<Comercio> comercioBd = comercioService.alterarComercio(comercio);
		
		if(comercioBd.isPresent()) {
			return new ResponseEntity<>(new ComercioDto(comercioBd.get()), HttpStatus.OK);
		}
		
		return ResponseEntity.badRequest().body(new ComercioDto(comercio));	
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ComercioDto> buscarPorId(@PathVariable String id){
		
		Optional<Comercio> comercioBd = comercioService.buscarComercioPeloId(id);
		
		if(comercioBd.isPresent()) {
			return ResponseEntity.ok( new ComercioDto(comercioBd.get()));
		}
		
		return ResponseEntity.notFound().build();
	}
}
