package br.com.projetofcamara.projeto.enums;

public enum StatusPedido {
  ACEITO,
  CANCELADO,
  ENTREGUE,
  ENVIADO,
  NEGADO,
  PENDENTE;
	
	//transforma uma string em um Enum
	public static StatusPedido getEnumByText(String status){
		if(status != null && !status.isEmpty()) {
			return StatusPedido.valueOf(status.toUpperCase());
		}
		return null;
	}
}
