package br.com.projetofcamara.projeto.service;

import java.util.Optional;
import br.com.projetofcamara.projeto.entity.Vendedor;

public interface VendedorService {	
		
	Optional<Vendedor> criarVendedor(Vendedor vendedor);
	
	Optional<Vendedor> alterarVendedor(Vendedor vendedor);
	
	Optional<Vendedor> buscarVendedorPeloEmail(String email);	

	Optional<Vendedor> buscarVendedorPeloId(String id);	
	
	void excluirVendedor(String id);
}
