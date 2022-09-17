package co.edu.uniquindio.juego.model;

import java.io.Serializable;

public class Jugador implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    private String nombre;
	private String cedula;
	private int puntaje;
	private int fallos;
	
	public Jugador(String nombre, String cedula, int puntaje, int fallos) {
		this.nombre = nombre;
		this.cedula = cedula;
		this.puntaje = puntaje;
		this.fallos = fallos;
	}

	public Jugador() {
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public int getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}

	public int getFallos() {
		return fallos;
	}

	public void setFallos(int fallos) {
		this.fallos = fallos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cedula == null) ? 0 : cedula.hashCode());
		result = prime * result + fallos;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + puntaje;
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
		Jugador other = (Jugador) obj;
		if (cedula == null) {
			if (other.cedula != null)
				return false;
		} else if (!cedula.equals(other.cedula))
			return false;
		if (fallos != other.fallos)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (puntaje != other.puntaje)
			return false;
		return true;
	}

	


}
