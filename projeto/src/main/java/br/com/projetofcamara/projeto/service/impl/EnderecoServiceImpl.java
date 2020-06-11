package br.com.projetofcamara.projeto.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.projetofcamara.projeto.entity.Endereco;
import br.com.projetofcamara.projeto.repository.EnderecoRepository;
import br.com.projetofcamara.projeto.service.EnderecoService;

@Service
public class EnderecoServiceImpl implements EnderecoService{
	
	@Autowired
	EnderecoRepository enderecoRepository;

	@Override
	public Optional<Endereco> criarEndereco(Endereco endereco) {
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
	public Page<Endereco> todosOsEnderecos(int pagina, int count) {
		return this.enderecoRepository.findAll( PageRequest.of( pagina, count) );
	}

}
