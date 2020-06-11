package br.com.projetofcamara.projeto.service;

import java.util.Optional;

import org.springframework.data.domain.Page;

import br.com.projetofcamara.projeto.entity.Endereco;


public interface EnderecoService {
	
	Page<Endereco> todosOsEnderecos(int pagina, int count);
	
	Optional<Endereco> criarEndereco(Endereco endereco);
	
	Optional<Endereco> alterarEndereco(Endereco endereco);	

	Optional<Endereco> buscarEnderecoPeloId(String id);	
	
	void excluirEndereco(String id);

}
