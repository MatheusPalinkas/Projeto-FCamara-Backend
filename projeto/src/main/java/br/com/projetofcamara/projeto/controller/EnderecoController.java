package br.com.projetofcamara.projeto.controller;

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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.projetofcamara.projeto.controller.dto.EnderecoDto;
import br.com.projetofcamara.projeto.controller.form.AtualizaEnderecoForm;
import br.com.projetofcamara.projeto.controller.form.EnderecoForm;
import br.com.projetofcamara.projeto.entity.Endereco;
import br.com.projetofcamara.projeto.enums.TipoDetentor;
import br.com.projetofcamara.projeto.service.EnderecoService;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
	
	@Autowired
	EnderecoService enderecoService;
	
	@GetMapping(value= "{tipoDetentor}/{id}" )
	public ResponseEntity<List<EnderecoDto>> listarEndereco(@PathVariable String tipoDetentor, @PathVariable String id) {
		Optional<List<Endereco>> enderecoBanco = enderecoService.todosOsEnderecos(TipoDetentor.getEnumFromText(tipoDetentor), id);
	
		if(enderecoBanco.isPresent()) {
			List<EnderecoDto> listaDto = new ArrayList<EnderecoDto>();
			for (Endereco endereco : enderecoBanco.get()) {
				listaDto.add(new EnderecoDto(endereco));
			}
			
		return new ResponseEntity<List<EnderecoDto>>( listaDto, HttpStatus.OK );
		}

		return ResponseEntity.notFound().build();
	}	
	
	@PostMapping("/{tipoDetentor}")
	public ResponseEntity<EnderecoDto> cadastrarEndereco(@PathVariable String tipoDetentor,@RequestBody @Valid EnderecoForm enderecoForm){
		
		Endereco endereco = enderecoForm.converter();
		endereco.setDetentor(TipoDetentor.getEnumFromText(tipoDetentor));
		Optional<Endereco> enderecoBd = enderecoService.criarEndereco(endereco);
		
		if(enderecoBd.isPresent()) {		
			return new ResponseEntity<>( new EnderecoDto(enderecoBd.get()), HttpStatus.CREATED);
		}
		
		return ResponseEntity.badRequest().body(new EnderecoDto(endereco));
	}
		
	@PutMapping
	public ResponseEntity<EnderecoDto> atualizarEndereco(@RequestBody @Valid AtualizaEnderecoForm form) {
		
		Endereco endereco = form.converter();
		Optional<Endereco> enderecoBd = enderecoService.alterarEndereco(endereco);
		
		if(enderecoBd.isPresent()) {
			return new ResponseEntity<>(new EnderecoDto(enderecoBd.get()), HttpStatus.OK);
		}
		
		return ResponseEntity.badRequest().body(new EnderecoDto(endereco));	
	}
			
	@GetMapping("/{id}")
	public ResponseEntity<EnderecoDto> buscarEndereco(@PathVariable String id){
		
		Optional<Endereco> enderecoBd = enderecoService.buscarEnderecoPeloId(id);
		
		if(enderecoBd.isPresent()) {
			return ResponseEntity.ok( new EnderecoDto(enderecoBd.get()));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> remover(@PathVariable String id){
		
		Optional<Endereco> enderecoBd = enderecoService.buscarEnderecoPeloId(id);
		
		if(enderecoBd.isPresent()) {
			enderecoService.excluirEndereco(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
}
