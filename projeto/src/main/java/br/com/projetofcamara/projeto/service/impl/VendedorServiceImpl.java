package br.com.projetofcamara.projeto.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import br.com.projetofcamara.projeto.entity.Vendedor;
import br.com.projetofcamara.projeto.exception.RegraDeNegocioException;
import br.com.projetofcamara.projeto.repository.VendedorRepository;
import br.com.projetofcamara.projeto.service.VendedorService;

@Service
public class VendedorServiceImpl implements VendedorService {
	
	@Autowired
	VendedorRepository vendedorRepository;

	@Override
	public Optional<Vendedor> criarVendedor(Vendedor vendedor) {
		vendedor.setSenha( new BCryptPasswordEncoder().encode( vendedor.getSenha() ) );
		return Optional.ofNullable(vendedorRepository.save(vendedor));
	}
	
	@Override
	public Optional<Vendedor> alterarVendedor(Vendedor vendedor) {
		
		Optional<Vendedor> vendedorBd = vendedorRepository.findById(vendedor.getId());
		if(vendedorBd.isPresent()) {
			vendedorBd.get().setNome(vendedor.getNome());
			if (vendedor.getSenha() != null && !vendedor.getSenha().isEmpty()) {
				vendedorBd.get().setSenha(new BCryptPasswordEncoder().encode( vendedor.getSenha() ));
			}
			vendedorBd.get().setTelefone(vendedor.getTelefone());
		}else {
			throw new RegraDeNegocioException("Vendedor não existe");
		}
		
		return Optional.ofNullable(vendedorRepository.save(vendedorBd.get()));
	}
	
	@Override
	public Optional<Vendedor> buscarVendedorPeloId(String id) {		
		return vendedorRepository.findById(id);
	}

	@Override
	public void excluirVendedor(String id) {
		this.vendedorRepository.deleteById(id);
	}
}
