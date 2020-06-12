package br.com.projetofcamara.projeto.service;

import java.util.List;
import java.util.Optional;
import br.com.projetofcamara.projeto.entity.Endereco;
import br.com.projetofcamara.projeto.enums.TipoDetentor;

public interface EnderecoService {
	
	Optional<List<Endereco>> todosOsEnderecos(TipoDetentor detentor, String codigoDetentor);
	
	Optional<Endereco> criarEndereco(Endereco endereco);
	
	Optional<Endereco> alterarEndereco(Endereco endereco);	

	Optional<Endereco> buscarEnderecoPeloId(String id);	
	
	void excluirEndereco(String id);	
}
