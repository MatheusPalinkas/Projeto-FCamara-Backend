package br.com.projetofcamara.projeto.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.projetofcamara.projeto.entity.Categoria;
import br.com.projetofcamara.projeto.exception.RegraDeNegocioException;
import br.com.projetofcamara.projeto.repository.CategoriaRepository;
import br.com.projetofcamara.projeto.service.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService {
	
	@Autowired
	CategoriaRepository categoriaRepository;

	@Override
	public Optional<Categoria> criarCategoria(Categoria categoria) {
		return Optional.ofNullable(categoriaRepository.save(categoria));
	}

	@Override
	public Optional<Categoria> alterarCategoria(Categoria categoria) {
		
		Optional<Categoria> categoriaBanco = categoriaRepository.findById(categoria.getId());
		if(categoriaBanco.isPresent()) {
			categoriaBanco.get().setDescricao(categoria.getDescricao());
			categoriaBanco.get().setNome(categoria.getNome());	
			categoriaBanco.get().setAtivo(categoria.isAtivo());
		}else {
			throw new RegraDeNegocioException("Categoria inexistente");
		}
		return Optional.ofNullable(categoriaRepository.save(categoriaBanco.get()));
	}

	@Override
	public Optional<Categoria> buscarCategoriaPeloId(String id) {
		return categoriaRepository.findById(id);
	}

	@Override
	public Optional<List<Categoria>> listarCategoriasAtivas() {		
		return Optional.of( categoriaRepository.findByAtivo(true) );
	}		
}
