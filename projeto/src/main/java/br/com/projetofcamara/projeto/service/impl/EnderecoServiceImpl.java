package br.com.projetofcamara.projeto.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import br.com.projetofcamara.projeto.entity.Cliente;
import br.com.projetofcamara.projeto.entity.Endereco;
import br.com.projetofcamara.projeto.enums.TipoDetentor;
import br.com.projetofcamara.projeto.exception.RegraDeNegocioException;
import br.com.projetofcamara.projeto.repository.EnderecoRepository;
import br.com.projetofcamara.projeto.service.ClienteService;
import br.com.projetofcamara.projeto.service.EnderecoService;

@Service
public class EnderecoServiceImpl implements EnderecoService{
	
	@Autowired
	EnderecoRepository enderecoRepository;
	
	@Autowired
	ClienteService clienteService;
		
	@Override
	public Optional<Endereco> criarEndereco(Endereco endereco) {		
		
		if(TipoDetentor.CLIENTE.equals(endereco.getDetentor()) && !TipoDetentor.COMERCIO.equals(endereco.getDetentor())) {
			Optional<Cliente> clienteBd = clienteService.buscarClientePeloId(endereco.getCodigoDetentor());
			
			if(!clienteBd.isPresent()) {
				throw new RegraDeNegocioException("Cliente inexistente");
			}				
		}
		
		if(TipoDetentor.PRODUTO.equals(endereco.getDetentor()) ){
			throw new RegraDeNegocioException("Produto não possui endereço");
		}
		
		if(TipoDetentor.VENDEDOR.equals(endereco.getDetentor()) ){
			throw new RegraDeNegocioException("Vendedor não possui endereço");
		}
		return Optional.ofNullable(enderecoRepository.save(endereco));
	}

	@Override
	public Optional<Endereco> alterarEndereco(Endereco endereco) {
		
		Optional<Endereco> enderecoBanco = enderecoRepository.findById(endereco.getId());
		
		if(enderecoBanco.isPresent()) {
			enderecoBanco.get().setCep(endereco.getCep());
			enderecoBanco.get().setBairro(endereco.getBairro());
			enderecoBanco.get().setCidade(endereco.getCidade());
			enderecoBanco.get().setComplemento(endereco.getComplemento());
			enderecoBanco.get().setLogradouro(endereco.getLogradouro());
			enderecoBanco.get().setNumero(endereco.getNumero());
			enderecoBanco.get().setUf(endereco.getUf());			
		}else {
			throw new RegraDeNegocioException("Endereco inexistente");
		}		
		return Optional.ofNullable(enderecoRepository.save(enderecoBanco.get()));
	}

	@Override
	public Optional<Endereco> buscarEnderecoPeloId(String id) {
		return enderecoRepository.findById(id);
	}

	@Override
	public void excluirEndereco(String id) {
		this.enderecoRepository.deleteById(id);		
	}

	@Override
	public Optional<List<Endereco>> todosOsEnderecos(TipoDetentor detentor, String codigoDetentor) {
		return Optional.of(enderecoRepository.findAll( Example.of( new Endereco(detentor, codigoDetentor))));
	}
	
}
