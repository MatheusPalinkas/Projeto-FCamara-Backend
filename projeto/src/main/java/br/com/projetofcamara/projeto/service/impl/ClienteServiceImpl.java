package br.com.projetofcamara.projeto.service.impl;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.projetofcamara.projeto.entity.Cliente;
import br.com.projetofcamara.projeto.repository.ClienteRepository;
import br.com.projetofcamara.projeto.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	ClienteRepository clienteRepository;

	@Override
	public Optional<Cliente> criarCliente(Cliente usuario) {
		return Optional.ofNullable(clienteRepository.save(usuario));
	}

	@Override
	public Optional<Cliente> alterarCliente(Cliente cliente) {
		
		Optional<Cliente> clienteBd = clienteRepository.findById(cliente.getId());
		
		if(clienteBd.isPresent()) {
			clienteBd.get().setNome(cliente.getNome());
			if (cliente.getSenha() != null && !cliente.getSenha().isEmpty()) {
				clienteBd.get().setSenha(cliente.getSenha());
			}
			
			clienteBd.get().setTelefone(cliente.getTelefone());
		}
		
		return Optional.ofNullable(clienteRepository.save(clienteBd.get()));
	}
	
	@Override
	public Optional<Cliente> buscarClientePeloEmail(String email) {		
		return Optional.ofNullable(clienteRepository.findByEmail(email));
	}
	
	@Override
	public Optional<Cliente> buscarClientePeloId(String id) {		
		return clienteRepository.findById(id);
	}

	@Override
	public void excluirCliente(String id) {
		this.clienteRepository.deleteById(id);
	}
}
