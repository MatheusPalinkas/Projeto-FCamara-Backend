package br.com.projetofcamara.projeto.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import br.com.projetofcamara.projeto.entity.Endereco;
import br.com.projetofcamara.projeto.enums.TipoDetentor;
import br.com.projetofcamara.projeto.repository.EnderecoRepository;
import br.com.projetofcamara.projeto.service.EnderecoService;

@Service
public class EnderecoServiceImpl implements EnderecoService{
	
	@Autowired
	EnderecoRepository enderecoRepository;

	@Override
	public Optional<Endereco> criarEndereco(Endereco endereco) {
		if(!TipoDetentor.PRODUTO.equals(endereco.getDetentor())){
			return Optional.ofNullable(enderecoRepository.save(endereco));
		}
		return Optional.empty();
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
