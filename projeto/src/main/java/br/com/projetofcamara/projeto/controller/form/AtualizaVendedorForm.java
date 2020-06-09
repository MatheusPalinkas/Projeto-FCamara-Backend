package br.com.projetofcamara.projeto.controller.form;

import br.com.projetofcamara.projeto.entity.Vendedor;

public class AtualizaVendedorForm extends AtualizarUsuarioForm{

	public Vendedor converter() {
		
		Vendedor vendedor = new Vendedor();
		vendedor.setId(id);
		vendedor.setNome(nome);
		vendedor.setSenha(senha);
		vendedor.setTelefone(telefone);
		
		return vendedor;
	}

}
