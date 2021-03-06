package br.com.projetofcamara.projeto.service;

import java.util.Optional;
import br.com.projetofcamara.projeto.entity.Avaliacao;
import br.com.projetofcamara.projeto.entity.Cliente;

public interface ClienteService {	
		
	Optional<Cliente> criarCliente(Cliente cliente);
	
	Optional<Cliente> alterarCliente(Cliente cliente);

	Optional<Cliente> buscarClientePeloId(String id);	
	
	void excluirCliente(String id);

	void novaAvaliacao(Avaliacao avaliaPedido);
	
	void removerComercioFavorito(String idCliente, String idComercio);
	
	Optional<Cliente> favoritarComercio(String idCliente, String idComercio);	

}
