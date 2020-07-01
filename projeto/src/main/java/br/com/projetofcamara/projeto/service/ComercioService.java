package br.com.projetofcamara.projeto.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.projetofcamara.projeto.entity.Avaliacao;
import br.com.projetofcamara.projeto.entity.Comercio;

public interface ComercioService {	
		
	Optional<Comercio> criarComercio(Comercio comercio);
	
	Optional<Comercio> alterarComercio(Comercio comercio);	

	Optional<Comercio> buscarComercioPeloId(String id);		

	Page<Comercio> listarComercios(Pageable paginacao);

	Page<Comercio> listarPorNome(String nome, Pageable paginacao);

	Page<Comercio> listarPorCategoria(String idCategoria, Pageable paginacao);

	void novaAvaliacao(Avaliacao avaliaPedido);
				
}
