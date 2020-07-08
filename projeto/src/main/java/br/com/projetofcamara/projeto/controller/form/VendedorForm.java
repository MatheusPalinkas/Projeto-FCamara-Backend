package br.com.projetofcamara.projeto.controller.form;

import br.com.projetofcamara.projeto.entity.Vendedor;

public class VendedorForm extends UsuarioForm{
	
	private String codigoComercio;
	
	public String getCodigoComercio() {
		return codigoComercio;
	}

	public void setCodigoComercio(String codigoComercio) {
		this.codigoComercio = codigoComercio;
	}	
		
	public Vendedor converter() {
		
		Vendedor vendedor = new Vendedor();
		vendedor.setNome(nome);
		vendedor.setEmail(email);
		vendedor.setSenha(senha);
		vendedor.setDataNascimento(dataNascimento);
		vendedor.setCpf(cpf);
		vendedor.setTelefone(telefone);	
		vendedor.setUrlFoto(urlFoto);
		vendedor.setCodigoComercio(codigoComercio);
		
		return vendedor;
	}		
}
