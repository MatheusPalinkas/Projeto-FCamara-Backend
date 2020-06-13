package br.com.projetofcamara.projeto.service;

import java.util.List;
import java.util.Optional;
import br.com.projetofcamara.projeto.entity.Categoria;

public interface CategoriaService {	
		
	Optional<Categoria> criarCategoria(Categoria categoria);
	
	Optional<Categoria> alterarCategoria(Categoria categoria);	

	Optional<Categoria> buscarCategoriaPeloId(String id);	
	
	Optional<List<Categoria>> listarCategoriasAtivas();
	
}
