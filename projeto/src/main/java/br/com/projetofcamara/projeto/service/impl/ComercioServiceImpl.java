package br.com.projetofcamara.projeto.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.projetofcamara.projeto.entity.Avaliacao;
import br.com.projetofcamara.projeto.entity.Categoria;
import br.com.projetofcamara.projeto.entity.Comercio;
import br.com.projetofcamara.projeto.entity.Endereco;
import br.com.projetofcamara.projeto.exception.RegraDeNegocioException;
import br.com.projetofcamara.projeto.repository.ComercioRepository;
import br.com.projetofcamara.projeto.service.CategoriaService;
import br.com.projetofcamara.projeto.service.ComercioService;
import br.com.projetofcamara.projeto.service.EnderecoService;
import br.com.projetofcamara.projeto.service.PedidoService;

@Service
public class ComercioServiceImpl implements ComercioService{
	
	@Autowired
	ComercioRepository comercioRespository;
	
	@Autowired
	PedidoService pedidoService;
	
	@Autowired
	CategoriaService categoriaService;
	
	@Autowired
	EnderecoService enderecoService;

	@Override
	public Optional<Comercio> criarComercio(Comercio comercio) {
		
		Optional<Categoria> categoriaBd = categoriaService.buscarCategoriaPeloId(comercio.getCategoria().getId());
		Optional<Endereco> enderecoBd = enderecoService.buscarEnderecoPeloId(comercio.getEndereco().getId());
		
		if(!categoriaBd.isPresent()) {
			throw new RegraDeNegocioException("Categoria inexistente");
		}
		
		if(!enderecoBd.isPresent()) {
			throw new RegraDeNegocioException("Endereco inexistente");
		}
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
			
		}else {
			throw new RegraDeNegocioException("Comercio não existe");
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
		return comercioRespository.findByCategoria(new Categoria(idCategoria), paginacao);
	}

	@Override
	public void novaAvaliacao(Avaliacao avaliacaoComercio) {
		
		Optional<Comercio> comercioAvaliado = this.buscarComercioPeloId(avaliacaoComercio.getCodigoAvaliado());
		
		if(comercioAvaliado.isPresent()) {
			double mediaAvaliacoesAtualizada = comercioAvaliado.get().getMediaAvaliacoes();
			mediaAvaliacoesAtualizada = mediaAvaliacoesAtualizada == 0.0 ? 5.0 : mediaAvaliacoesAtualizada;
			mediaAvaliacoesAtualizada = ( mediaAvaliacoesAtualizada + avaliacaoComercio.getNotaPedido().getValor() ) / 2;
			
			if(comercioAvaliado.get().getMediaAvaliacoes() != mediaAvaliacoesAtualizada) {
				comercioAvaliado.get().setMediaAvaliacoes(mediaAvaliacoesAtualizada);
				comercioRespository.save(comercioAvaliado.get());
			}
		}
		
	}
	
}
