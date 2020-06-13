package br.com.projetofcamara.projeto.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.projetofcamara.projeto.controller.dto.CategoriaDto;
import br.com.projetofcamara.projeto.controller.form.AtualizaCategoriaForm;
import br.com.projetofcamara.projeto.controller.form.CategoriaForm;
import br.com.projetofcamara.projeto.entity.Categoria;
import br.com.projetofcamara.projeto.service.CategoriaService;


@RestController
@RequestMapping("/categoria")
public class CategoriaController {
	
	@Autowired
	CategoriaService categoriaService;
	
	@GetMapping
	public ResponseEntity<List<CategoriaDto>> listarCategoriasAtivas(){
		
		Optional<List<Categoria>> categoriaBanco = categoriaService.listarCategoriasAtivas();
		
		if(categoriaBanco.isPresent()) {
			List<CategoriaDto> listaDto = new ArrayList<CategoriaDto>();
			for (Categoria categoria : categoriaBanco.get()) {
				listaDto.add(new CategoriaDto(categoria));
			}			

		return new ResponseEntity<List<CategoriaDto>>( listaDto, HttpStatus.OK );
		}

	return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<CategoriaDto> criarCategoria(@RequestBody @Valid CategoriaForm CategoriaForm){
		
		 Categoria categoria = CategoriaForm.converter();
		
		Optional<Categoria> CategoriaBd = categoriaService.criarCategoria(categoria);
		
		if(CategoriaBd.isPresent()) {
			return new ResponseEntity<>( new CategoriaDto(CategoriaBd.get()), HttpStatus.CREATED);
		}
		
		return ResponseEntity.badRequest().body(new CategoriaDto(categoria));
	}
	
	@PutMapping
	public ResponseEntity<CategoriaDto> atualizarCategoria( @RequestBody @Valid AtualizaCategoriaForm form) {
		
		Categoria categoria = form.converter();
		Optional<Categoria> categoriaBd = categoriaService.alterarCategoria(categoria);
		
		if(categoriaBd.isPresent()) {
			return new ResponseEntity<>(new CategoriaDto(categoriaBd.get()), HttpStatus.OK);
		}
		
		return ResponseEntity.badRequest().body(new CategoriaDto(categoria));	
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CategoriaDto> buscarPorId(@PathVariable String id){
		
		Optional<Categoria> categoriaBd = categoriaService.buscarCategoriaPeloId(id);
		
		if(categoriaBd.isPresent()) {
			return ResponseEntity.ok( new CategoriaDto(categoriaBd.get()));
		}
		
		return ResponseEntity.notFound().build();
	}
}
