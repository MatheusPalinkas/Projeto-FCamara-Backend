package br.com.projetofcamara.projeto.controller.form;

import br.com.projetofcamara.projeto.entity.Cliente;

public class ClienteForm extends UsuarioForm{

	public Cliente converter() {
		
		Cliente cliente = new Cliente();
		cliente.setNome(nome);
		cliente.setEmail(email);
		cliente.setSenha(senha);
		cliente.setDataNascimento(dataNascimento);
		cliente.setCpf(cpf);
		cliente.setTelefone(telefone);	
		
		return cliente;
	}
	
	
	
	
}
