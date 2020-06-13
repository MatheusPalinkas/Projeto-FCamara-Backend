package br.com.projetofcamara.projeto.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import br.com.projetofcamara.projeto.entity.Comercio;

public interface ComercioRepository extends MongoRepository<Comercio, String>{
		
	
}
