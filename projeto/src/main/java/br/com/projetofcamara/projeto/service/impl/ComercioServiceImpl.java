package br.com.projetofcamara.projeto.service.impl;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import br.com.projetofcamara.projeto.entity.Comercio;
import br.com.projetofcamara.projeto.repository.ComercioRepository;
import br.com.projetofcamara.projeto.service.ComercioService;

@Service
public class ComercioServiceImpl implements ComercioService{
	
	@Autowired
	ComercioRepository comercioRespository;

	@Override
	public Optional<Comercio> criarComercio(Comercio comercio) {
		return Optional.ofNullable(comercioRespository.save(comercio));
	}

	@Override
	public Optional<Comercio> alterarComercio(Comercio comercio) {
		Optional<Comercio> comercioBanco = comercioRespository.findById(comercio.getId());
		
		if(comercioBanco.isPresent()) {
			comercioBanco.get().setPossuiServicoEntrega(comercio.isPossuiServicoEntrega());
			comercioBanco.get().setPagamentoCartao(comercio.isPagamentoCartao());
			comercioBanco.get().setPagamentoDinheiro(comercio.isPagamentoDinheiro());
			comercioBanco.get().setHorarioAbertura(comercio.getHorarioAbertura());
			comercioBanco.get().setHorarioFechamento(comercio.getHorarioFechamento());
			comercioBanco.get().setLocalAtendimento(comercio.isLocalAtendimento());	
			comercioBanco.get().setTempoEntrega(comercio.getTempoEntrega());
			comercioBanco.get().setUrlFoto(comercio.getUrlFoto());
			comercioBanco.get().setValorEntrega(comercio.getValorEntrega());
		}
		
		return Optional.ofNullable(comercioRespository.save(comercioBanco.get()));
		
	}

	@Override
	public Optional<Comercio> buscarComercioPeloId(String id) {
		return comercioRespository.findById(id);
	}

	@Override
	public Page<Comercio> listarComercios(Pageable paginacao) {		
		return comercioRespository.findAll(paginacao);
	}

	@Override
	public Page<Comercio> listarPorNome(String nome, Pageable paginacao) {
		return comercioRespository.findByNomeIgnoreCaseLike(nome, paginacao);
	}

	@Override
	public Page<Comercio> listarPorCategoria(String idCategoria, Pageable paginacao) {
		return comercioRespository.findByIdCategoria(idCategoria, paginacao);
	}
	
}
