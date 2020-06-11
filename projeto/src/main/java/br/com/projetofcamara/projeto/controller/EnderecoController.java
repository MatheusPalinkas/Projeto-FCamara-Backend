package br.com.projetofcamara.projeto.controller;


import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
import br.com.projetofcamara.projeto.service.EnderecoService;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
	
	@Autowired
	EnderecoService enderecoService;
	
	@GetMapping	
	public List<EnderecoDto> listaEndereco(){								 
							
		Page<Endereco> endereco = enderecoService.todosOsEnderecos(0, 5);
									   
		return EnderecoDto.converter(endereco);
	}
	
	
	@PostMapping
	public ResponseEntity<EnderecoDto> cadastrar(@RequestBody @Valid EnderecoForm enderecoForm){
		
		Endereco endereco = enderecoForm.converter();
		
		Optional<Endereco> enderecoBd = enderecoService.criarEndereco(endereco);
		
		if(enderecoBd.isPresent()) {
			return new ResponseEntity<>( new EnderecoDto(enderecoBd.get()), HttpStatus.CREATED);
		}
		
		return ResponseEntity.badRequest().body(new EnderecoDto(endereco));
	}
	
	@PutMapping
	public ResponseEntity<EnderecoDto> atualizar( @RequestBody @Valid AtualizaEnderecoForm form) {
		
		Endereco endereco = form.converter();
		Optional<Endereco> enderecoBd = enderecoService.alterarEndereco(endereco);
		
		if(enderecoBd.isPresent()) {
			return new ResponseEntity<>(new EnderecoDto(enderecoBd.get()), HttpStatus.OK);
		}
		
		return ResponseEntity.badRequest().body(new EnderecoDto(endereco));
	
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
