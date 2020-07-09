package br.com.projetofcamara.projeto.controller;

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
import br.com.projetofcamara.projeto.controller.dto.PedidoDto;
import br.com.projetofcamara.projeto.controller.form.AvaliarPedidoForm;
import br.com.projetofcamara.projeto.controller.form.PedidoForm;
import br.com.projetofcamara.projeto.entity.Avaliacao;
import br.com.projetofcamara.projeto.entity.Pedido;
import br.com.projetofcamara.projeto.enums.StatusPedido;
import br.com.projetofcamara.projeto.service.PedidoService;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
	
	@Autowired
	PedidoService pedidoService;	


	@GetMapping("cliente/{idCliente}")
	public List<PedidoDto> listarPedidoCliente(@PathVariable String idCliente) {
		
		List<Pedido> pedido = pedidoService.listarPedidoCliente(idCliente);
		return PedidoDto.converter(pedido);
	}
	
	@GetMapping("comercio/{idComercio}")
	public List<PedidoDto> listarPedidoComercio(@PathVariable String idComercio) {
		
		List<Pedido> pedido = pedidoService.listarPedidoComercio(idComercio);
		return PedidoDto.converter(pedido);
	}
	
	@PostMapping
	public ResponseEntity<PedidoDto> criarPedido(@RequestBody @Valid PedidoForm form ){
		Pedido pedido = form.converter();
		
		Optional<Pedido> pedidoBd = pedidoService.criarPedido(pedido);
		
		if(pedidoBd.isPresent()) {
			return new ResponseEntity<>( new PedidoDto(pedidoBd.get()), HttpStatus.CREATED);
		}
		
		return ResponseEntity.badRequest().body(new PedidoDto(pedido));
	}	
	
	@PutMapping("/{id}/{status}")
	public ResponseEntity<PedidoDto> atualizaStatus(@PathVariable String id, @PathVariable String status){
		
		Optional<Pedido> pedidoBd = Optional.empty();
		Pedido pedido = new Pedido();
		pedido.setId(id);
		pedido.setStatusPedido(StatusPedido.getEnumByText(status));				
		
		switch (pedido.getStatusPedido()) {
			case ACEITO:
				pedidoBd = pedidoService.aceitaPedido(pedido);
				break;
			case NEGADO:
				pedidoBd = pedidoService.negarPedido(pedido);
				break;
			case ENVIADO:
				pedidoBd = pedidoService.enviarPedido(pedido);
				break;
			case ENTREGUE:
				pedidoBd = pedidoService.entregarPedido(pedido);
				break;
			default:
				break;
		}
		
		if(pedidoBd.isPresent()) {
			return new ResponseEntity<>( new PedidoDto(pedidoBd.get()), HttpStatus.OK);
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
	
	@PostMapping("/{idPedido}/avaliar/{avaliado}")
	public ResponseEntity<PedidoDto> avaliarPedido(@PathVariable String avaliado,@PathVariable String idPedido, @RequestBody @Valid AvaliarPedidoForm avaliarPedidoForm ){
		
		Avaliacao avaliaPedido = avaliarPedidoForm.converter();
		
		Optional<Pedido> avaliaBd = pedidoService.criarAvaliacao(avaliaPedido, avaliado, idPedido);
		if(avaliaBd.isPresent()) {
			return new ResponseEntity<>( new PedidoDto(avaliaBd.get()), HttpStatus.CREATED);
		}
		return ResponseEntity.notFound().build();
	}
}
