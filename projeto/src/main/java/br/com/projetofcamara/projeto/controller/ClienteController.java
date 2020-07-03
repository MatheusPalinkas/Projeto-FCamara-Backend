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
import br.com.projetofcamara.projeto.controller.dto.ClienteDto;
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
	public ResponseEntity<ClienteDto> cadastrar(@RequestBody @Valid ClienteForm clienteForm){
		
		Cliente cliente = clienteForm.converter();
		
		Optional<Cliente> clienteBd = clienteService.criarCliente(cliente);
		
		if(clienteBd.isPresent()) {
			return new ResponseEntity<>( new ClienteDto(clienteBd.get()), HttpStatus.CREATED);
		}
		
		return ResponseEntity.badRequest().body(new ClienteDto(cliente));
	}
	
	@PutMapping
	public ResponseEntity<ClienteDto> atualizar( @RequestBody @Valid AtualizaClienteForm form) {
		
		Cliente cliente = form.converter();
		Optional<Cliente> clienteBd = clienteService.alterarCliente(cliente);
		
		if(clienteBd.isPresent()) {
			return new ResponseEntity<>(new ClienteDto(clienteBd.get()), HttpStatus.OK);
		}
		
		return ResponseEntity.badRequest().body(new ClienteDto(cliente));	
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ClienteDto> buscarPorId(@PathVariable String id){
		
		Optional<Cliente> clienteBd = clienteService.buscarClientePeloId(id);
		
		if(clienteBd.isPresent()) {
			return ResponseEntity.ok( new ClienteDto(clienteBd.get()));
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
	
	@PostMapping("/{idCliente}/favoritar/{idComercio}")
	public ResponseEntity<ClienteDto> favoritarComercio(@PathVariable String idComercio, @PathVariable String idCliente){
		
		Optional<Cliente> clienteBd = clienteService.favoritarComercio(idCliente, idComercio);
		
		if(clienteBd.isPresent()) {
			return new ResponseEntity<>( new ClienteDto(clienteBd.get()), HttpStatus.CREATED);
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{idCliente}/remover/{idComercio}")
	public ResponseEntity<?> removerComercioFavorito(@PathVariable String idComercio, @PathVariable String idCliente){

		Optional<Cliente> clienteBd = clienteService.buscarClientePeloId(idCliente);
		if(clienteBd.isPresent()) {
			clienteService.removerComercioFavorito(idCliente, idComercio);
			return ResponseEntity.ok().build();
		}		
		return ResponseEntity.notFound().build();
	}		
}
