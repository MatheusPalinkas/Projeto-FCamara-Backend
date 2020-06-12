package br.com.projetofcamara.projeto.controller.form;

import br.com.projetofcamara.projeto.entity.Vendedor;

public class VendedorForm extends UsuarioForm{
		
	public Vendedor converter() {
		
		Vendedor vendedor = new Vendedor();
		vendedor.setNome(nome);
		vendedor.setEmail(email);
		vendedor.setSenha(senha);
		vendedor.setDataNascimento(dataNascimento);
		vendedor.setCpf(cpf);
		vendedor.setTelefone(telefone);	
		
		return vendedor;
	}		
}
