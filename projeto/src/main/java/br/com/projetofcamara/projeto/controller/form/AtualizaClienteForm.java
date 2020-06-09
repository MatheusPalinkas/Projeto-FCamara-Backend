package br.com.projetofcamara.projeto.controller.form;

import br.com.projetofcamara.projeto.entity.Cliente;


public class AtualizaClienteForm extends AtualizarUsuarioForm{

	public Cliente converter() {
		
		Cliente cliente = new Cliente();
		cliente.setId(id);
		cliente.setNome(nome);
		cliente.setSenha(senha);
		cliente.setTelefone(telefone);
		
		return cliente;
	}

}
