package co.edu.uniquindio.juego.model;

import java.io.Serializable;

public class Pista implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    private boolean estado;
	private TipoPista tipoPista;

	public Pista(boolean estado, TipoPista tipoPista) {
		
		this.estado = estado;
		this.tipoPista = tipoPista;
	}

	public Pista() {
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public TipoPista getTipoPista() {
		return tipoPista;
	}

	public void setTipoPista(TipoPista tipoPista) {
		this.tipoPista = tipoPista;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (estado ? 1231 : 1237);
		result = prime * result + ((tipoPista == null) ? 0 : tipoPista.hashCode());
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
		Pista other = (Pista) obj;
		if (estado != other.estado)
			return false;
		if (tipoPista != other.tipoPista)
			return false;
		return true;
	}

	

	
	


}
