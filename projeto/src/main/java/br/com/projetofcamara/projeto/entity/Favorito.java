package br.com.projetofcamara.projeto.entity;

public class Favorito {
	private String codigoComercio;
	private String nomeComercio;
	
	public Favorito(String codigoComercio, String nomeComercio) {
		this.codigoComercio = codigoComercio;
		this.nomeComercio = nomeComercio;
	}

	public String getCodigoComercio() {
		return codigoComercio;
	}
	
	public void setCodigoComercio(String codigoComercio) {
		this.codigoComercio = codigoComercio;
	}
	
	public String getNomeComercio() {
		return nomeComercio;
	}
	
	public void setNomeComercio(String nomeComercio) {
		this.nomeComercio = nomeComercio;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoComercio == null) ? 0 : codigoComercio.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Favorito other = (Favorito) obj;
		if (codigoComercio == null) {
			if (other.codigoComercio != null)
				return false;
		} else if (!codigoComercio.equals(other.codigoComercio))
			return false;
		return true;
	}		
}
