package br.com.projetofcamara.projeto.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import br.com.projetofcamara.projeto.entity.Vendedor;

public interface VendedorRepository extends MongoRepository<Vendedor, String>{
}
