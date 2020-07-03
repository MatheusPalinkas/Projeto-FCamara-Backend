package br.com.projetofcamara.projeto.service.impl;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import br.com.projetofcamara.projeto.entity.Avaliacao;
import br.com.projetofcamara.projeto.entity.Cliente;
import br.com.projetofcamara.projeto.entity.Comercio;
import br.com.projetofcamara.projeto.entity.Favorito;
import br.com.projetofcamara.projeto.exception.RegraDeNegocioException;
import br.com.projetofcamara.projeto.repository.ClienteRepository;
import br.com.projetofcamara.projeto.service.ClienteService;
import br.com.projetofcamara.projeto.service.ComercioService;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	ComercioService comercioService;

	@Override
	public Optional<Cliente> criarCliente(Cliente usuario) {
		usuario.setSenha( new BCryptPasswordEncoder().encode( usuario.getSenha() ) );
		return Optional.ofNullable(clienteRepository.save(usuario));
	}

	@Override
	public Optional<Cliente> alterarCliente(Cliente cliente) {
		
		Optional<Cliente> clienteBd = clienteRepository.findById(cliente.getId());
		
		if(clienteBd.isPresent()) {
			clienteBd.get().setNome(cliente.getNome());
			if (cliente.getSenha() != null && !cliente.getSenha().isEmpty()) {
				clienteBd.get().setSenha(new BCryptPasswordEncoder().encode( cliente.getSenha() ));
			}			
			clienteBd.get().setTelefone(cliente.getTelefone());
			
		}else {
			throw new RegraDeNegocioException("Cliente não existe");
		}
		
		return Optional.ofNullable(clienteRepository.save(clienteBd.get()));
	}
	
	@Override
	public Optional<Cliente> buscarClientePeloId(String id) {		
		return clienteRepository.findById(id);
	}

	@Override
	public void excluirCliente(String id) {
		this.clienteRepository.deleteById(id);
	}

	@Override
	public void novaAvaliacao(Avaliacao avaliacaoCliente) {
		
		Optional<Cliente> clienteAvaliado = this.buscarClientePeloId(avaliacaoCliente.getCodigoAvaliado());
		
		if(clienteAvaliado.isPresent()) {
			double mediaAvaliacoesAtualizada = clienteAvaliado.get().getMediaAvaliacoes();
			mediaAvaliacoesAtualizada = mediaAvaliacoesAtualizada == 0.0 ? 5.0 : mediaAvaliacoesAtualizada;
			mediaAvaliacoesAtualizada = ( mediaAvaliacoesAtualizada + avaliacaoCliente.getNotaPedido().getValor() ) / 2;
						
			if(clienteAvaliado.get().getMediaAvaliacoes() != mediaAvaliacoesAtualizada) {
				clienteAvaliado.get().setMediaAvaliacoes(mediaAvaliacoesAtualizada);
				clienteRepository.save(clienteAvaliado.get());
			}
		}		
	}
	
	@Override
	public Optional<Cliente> favoritarComercio(String idCliente, String idComercio) {
		
		Optional<Cliente> clienteBd = clienteRepository.findById(idCliente);
		Optional<Comercio> comercioBd = comercioService.buscarComercioPeloId(idComercio);		
		
		if(clienteBd.isPresent() && comercioBd.isPresent()) {			
			Favorito favorito = new Favorito(comercioBd.get().getId(), comercioBd.get().getNome());
			clienteBd.get().getFavoritos().add(favorito);
			return Optional.ofNullable(clienteRepository.save(clienteBd.get()));
		}
		return Optional.empty();
	}
	
	@Override
	public void removerComercioFavorito(String idCliente, String idComercio) {
		
		Optional<Cliente> clienteBd = this.buscarClientePeloId(idCliente);
		Optional<Comercio> comercioBd = this.comercioService.buscarComercioPeloId(idComercio);
		
		
		if(clienteBd.isPresent() && comercioBd.isPresent()) {			
			Favorito favorito = new Favorito(comercioBd.get().getId(), comercioBd.get().getNome());
			
			if(clienteBd.get().getFavoritos().contains(favorito)) {
				clienteBd.get().getFavoritos().remove(favorito);
			}	
			clienteRepository.save(clienteBd.get());
		}		
	}	
}
