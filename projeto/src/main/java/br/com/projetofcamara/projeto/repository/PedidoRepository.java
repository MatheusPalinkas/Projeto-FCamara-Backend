package br.com.projetofcamara.projeto.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import br.com.projetofcamara.projeto.entity.Cliente;
import br.com.projetofcamara.projeto.entity.Comercio;
import br.com.projetofcamara.projeto.entity.Pedido;

public interface PedidoRepository extends MongoRepository<Pedido, String>{

	Page<Pedido> findByCliente(Cliente cliente, Pageable paginacao);
	Page<Pedido> findByComercio(Comercio comercio, Pageable paginacao);
}
