package br.com.projetofcamara.projeto.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projetofcamara.projeto.controller.dto.PedidoDto;
import br.com.projetofcamara.projeto.controller.form.PedidoForm;
import br.com.projetofcamara.projeto.entity.Pedido;
import br.com.projetofcamara.projeto.service.PedidoService;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
	
	@Autowired
	PedidoService pedidoService;	


	@GetMapping("cliente/{idCliente}")
	public Page<PedidoDto> listarPedidoCliente(@PathVariable String idCliente, Pageable paginacao) {
		
		Page<Pedido> pedido = pedidoService.listarPedidoCliente(idCliente, paginacao);
		return PedidoDto.converter(pedido);
	}
	
	@GetMapping("comercio/{idComercio}")
	public Page<PedidoDto> listarPedidoComercio(@PathVariable String idComercio, Pageable paginacao) {
		
		Page<Pedido> pedido = pedidoService.listarPedidoComercio(idComercio, paginacao);
		return PedidoDto.converter(pedido);
	}
	
	@PostMapping
	public ResponseEntity<PedidoDto> criarPedido(@RequestBody @Valid PedidoForm form ) throws Exception{
		Pedido pedido = form.converter();
		
		Optional<Pedido> pedidoBd = pedidoService.criarPedido(pedido);
		
		if(pedidoBd.isPresent()) {
			return new ResponseEntity<>( new PedidoDto(pedidoBd.get()), HttpStatus.CREATED);
		}
		
		return ResponseEntity.badRequest().body(new PedidoDto(pedido));
	}	
	
	@GetMapping("/{id}")
	public ResponseEntity<PedidoDto> buscarPorId(@PathVariable String id){
		
		Optional<Pedido> pedidoBd = pedidoService.buscarPedidoId(id);
		
		if(pedidoBd.isPresent()) {
			return ResponseEntity.ok( new PedidoDto(pedidoBd.get()));
		}
		
		return ResponseEntity.notFound().build();
	}
}
