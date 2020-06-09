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
import br.com.projetofcamara.projeto.controller.form.AtualizaVendedorForm;
import br.com.projetofcamara.projeto.controller.form.VendedorForm;
import br.com.projetofcamara.projeto.entity.Vendedor;
import br.com.projetofcamara.projeto.service.VendedorService;

@RestController
@RequestMapping("/vendedor")
public class VendedorController {

	@Autowired	
	VendedorService vendedorService;
	
	
	@PostMapping
	public ResponseEntity<UsuarioDto> cadastrar(@RequestBody @Valid VendedorForm form) {
		
		Vendedor vendedor = form.converter();
		Optional<Vendedor> vendedorBd = vendedorService.criarVendedor(vendedor);
		
		if(vendedorBd.isPresent()) {
			return new ResponseEntity<>(new UsuarioDto(vendedorBd.get()), HttpStatus.CREATED);
		}
		
		return ResponseEntity.badRequest().body(new UsuarioDto(vendedor));
	}
	
	@PutMapping()
	public ResponseEntity<UsuarioDto> atualizar( @RequestBody @Valid AtualizaVendedorForm form) {
		
		Vendedor vendedor = form.converter();
		Optional<Vendedor> vendedorBd = vendedorService.alterarVendedor(vendedor);
		
		if(vendedorBd.isPresent()) {
			return new ResponseEntity<>(new UsuarioDto(vendedorBd.get()), HttpStatus.OK);
		}
		
		return ResponseEntity.badRequest().body(new UsuarioDto(vendedor));	
	
	}	
	
	@GetMapping("/{id}")
	public ResponseEntity<UsuarioDto> buscarPorId(@PathVariable String id){
		
		Optional<Vendedor> vendedorBd = vendedorService.buscarVendedorPeloId(id);
		
		if(vendedorBd.isPresent()) {
			return ResponseEntity.ok( new UsuarioDto(vendedorBd.get()));
		}
		
		return ResponseEntity.notFound().build();
	}
	

	@DeleteMapping("/{id}")
	public ResponseEntity<?> remover(@PathVariable String id){
		
		Optional<Vendedor> vendedorBd = vendedorService.buscarVendedorPeloId(id);
		
		if(vendedorBd.isPresent()) {
			vendedorService.excluirVendedor(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
	
}
