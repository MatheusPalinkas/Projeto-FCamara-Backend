package br.com.projetofcamara.projeto.controller;

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
import br.com.projetofcamara.projeto.controller.dto.UsuarioDto;
import br.com.projetofcamara.projeto.controller.form.AtualizaClienteForm;
import br.com.projetofcamara.projeto.controller.form.ClienteForm;
import br.com.projetofcamara.projeto.entity.Cliente;
import br.com.projetofcamara.projeto.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	ClienteService clienteService;
	
	@PostMapping
	public ResponseEntity<UsuarioDto> cadastrar(@RequestBody @Valid ClienteForm clienteForm){
		
		Cliente cliente = clienteForm.converter();
		
		Optional<Cliente> clienteBd = clienteService.criarCliente(cliente);
		
		if(clienteBd.isPresent()) {
			return new ResponseEntity<>( new UsuarioDto(clienteBd.get()), HttpStatus.CREATED);
		}
		
		return ResponseEntity.badRequest().body(new UsuarioDto(cliente));
	}
	
	@PutMapping
	public ResponseEntity<UsuarioDto> atualizar( @RequestBody @Valid AtualizaClienteForm form) {
		
		Cliente cliente = form.converter();
		Optional<Cliente> clienteBd = clienteService.alterarCliente(cliente);
		
		if(clienteBd.isPresent()) {
			return new ResponseEntity<>(new UsuarioDto(clienteBd.get()), HttpStatus.OK);
		}
		
		return ResponseEntity.badRequest().body(new UsuarioDto(cliente));
		
	
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UsuarioDto> buscarPorId(@PathVariable String id){
		
		Optional<Cliente> clienteBd = clienteService.buscarClientePeloId(id);
		
		if(clienteBd.isPresent()) {
			return ResponseEntity.ok( new UsuarioDto(clienteBd.get()));
		}
		
		return ResponseEntity.notFound().build();
	}

	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> remover(@PathVariable String id){
		
		Optional<Cliente> clienteBd = clienteService.buscarClientePeloId(id);
		
		if(clienteBd.isPresent()) {
			clienteService.excluirCliente(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
}
