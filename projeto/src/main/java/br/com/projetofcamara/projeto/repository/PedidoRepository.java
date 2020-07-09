package br.com.projetofcamara.projeto.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import br.com.projetofcamara.projeto.entity.Cliente;
import br.com.projetofcamara.projeto.entity.Comercio;
import br.com.projetofcamara.projeto.entity.Pedido;

public interface PedidoRepository extends MongoRepository<Pedido, String>{

	List<Pedido> findByCliente(Cliente cliente);
	List<Pedido> findByComercio(Comercio comercio);
}
