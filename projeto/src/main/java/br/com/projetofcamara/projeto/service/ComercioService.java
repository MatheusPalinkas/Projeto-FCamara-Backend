package br.com.projetofcamara.projeto.service;

import java.util.Optional;
import org.springframework.data.domain.Page;
import br.com.projetofcamara.projeto.entity.Comercio;

public interface ComercioService {	
		
	Optional<Comercio> criarComercio(Comercio comercio);
	
	Optional<Comercio> alterarComercio(Comercio comercio);	

	Optional<Comercio> buscarComercioPeloId(String id);	
	
	Page<Comercio> listarTodosComercios(int page, int count);	
	
	Page<Comercio> listarPorNome(String nome, int page, int count);

	Page<Comercio> listarPorCategoria(String idCategoria, int page, int count);
	
}
