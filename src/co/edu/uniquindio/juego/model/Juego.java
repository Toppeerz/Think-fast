package co.edu.uniquindio.juego.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;

public class Juego implements Serializable {

	/**
	 *  este comentario inicia la clase juego de la aplicacion jf
	 */
	private static final long serialVersionUID = 1L;
	//atributos
	private String nombre;
    private Hashtable<Integer,Jugador> listaJugadoresPuntuaciones = new Hashtable<Integer,Jugador>();
	private ArrayList<Pregunta> listaPreguntasFaciles = new ArrayList<Pregunta>();
	private ArrayList<Pregunta> listaPreguntasMedias = new ArrayList<Pregunta>();
	private ArrayList<Pregunta> listaPreguntasDificiles = new ArrayList<Pregunta>();
	private ArrayList<Pregunta> listaPreguntas = new ArrayList<Pregunta>();
	private ArrayList<Jugador> listaJugadores = new ArrayList<Jugador>();
	




//d
	
	public Juego(String nombre, Hashtable<Integer, Jugador> listaJugadoresPuntuaciones,
			ArrayList<Pregunta> listaPreguntasFaciles, ArrayList<Pregunta> listaPreguntasMedias,
			ArrayList<Pregunta> listaPreguntasDificiles, ArrayList<Pregunta> listaPreguntas,
			ArrayList<Jugador> listaJugadores) {
		this.nombre = nombre;
		this.listaJugadoresPuntuaciones = listaJugadoresPuntuaciones;
		this.listaPreguntasFaciles = listaPreguntasFaciles;
		this.listaPreguntasMedias = listaPreguntasMedias;
		this.listaPreguntasDificiles = listaPreguntasDificiles;
		this.listaPreguntas = listaPreguntas;
		this.listaJugadores = listaJugadores;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Hashtable<Integer, Jugador> getListaJugadoresPuntuaciones() {
		return listaJugadoresPuntuaciones;
	}

	public void setListaJugadoresPuntuaciones(Hashtable<Integer, Jugador> listaJugadoresPuntuaciones) {
		this.listaJugadoresPuntuaciones = listaJugadoresPuntuaciones;
	}

	public ArrayList<Pregunta> getListaPreguntasFaciles() {
		return listaPreguntasFaciles;
	}

	public void setListaPreguntasFaciles(ArrayList<Pregunta> listaPreguntasFaciles) {
		this.listaPreguntasFaciles = listaPreguntasFaciles;
	}

	public ArrayList<Pregunta> getListaPreguntasMedias() {
		return listaPreguntasMedias;
	}

	public void setListaPreguntasMedias(ArrayList<Pregunta> listaPreguntasMedias) {
		this.listaPreguntasMedias = listaPreguntasMedias;
	}

	public ArrayList<Pregunta> getListaPreguntasDificiles() {
		return listaPreguntasDificiles;
	}

	public void setListaPreguntasDificiles(ArrayList<Pregunta> listaPreguntasDificiles) {
		this.listaPreguntasDificiles = listaPreguntasDificiles;
	}

	public ArrayList<Pregunta> getListaPreguntas() {
		return listaPreguntas;
	}

	public void setListaPreguntas(ArrayList<Pregunta> listaPreguntas) {
		this.listaPreguntas = listaPreguntas;
	}

	public ArrayList<Jugador> getListaJugadores() {
		return listaJugadores;
	}

	public void setListaJugadores(ArrayList<Jugador> listaJugadores) {
		this.listaJugadores = listaJugadores;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((listaJugadores == null) ? 0 : listaJugadores.hashCode());
		result = prime * result + ((listaJugadoresPuntuaciones == null) ? 0 : listaJugadoresPuntuaciones.hashCode());
		result = prime * result + ((listaPreguntas == null) ? 0 : listaPreguntas.hashCode());
		result = prime * result + ((listaPreguntasDificiles == null) ? 0 : listaPreguntasDificiles.hashCode());
		result = prime * result + ((listaPreguntasFaciles == null) ? 0 : listaPreguntasFaciles.hashCode());
		result = prime * result + ((listaPreguntasMedias == null) ? 0 : listaPreguntasMedias.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		Juego other = (Juego) obj;
		if (listaJugadores == null) {
			if (other.listaJugadores != null)
				return false;
		} else if (!listaJugadores.equals(other.listaJugadores))
			return false;
		if (listaJugadoresPuntuaciones == null) {
			if (other.listaJugadoresPuntuaciones != null)
				return false;
		} else if (!listaJugadoresPuntuaciones.equals(other.listaJugadoresPuntuaciones))
			return false;
		if (listaPreguntas == null) {
			if (other.listaPreguntas != null)
				return false;
		} else if (!listaPreguntas.equals(other.listaPreguntas))
			return false;
		if (listaPreguntasDificiles == null) {
			if (other.listaPreguntasDificiles != null)
				return false;
		} else if (!listaPreguntasDificiles.equals(other.listaPreguntasDificiles))
			return false;
		if (listaPreguntasFaciles == null) {
			if (other.listaPreguntasFaciles != null)
				return false;
		} else if (!listaPreguntasFaciles.equals(other.listaPreguntasFaciles))
			return false;
		if (listaPreguntasMedias == null) {
			if (other.listaPreguntasMedias != null)
				return false;
		} else if (!listaPreguntasMedias.equals(other.listaPreguntasMedias))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	
	
	
	
	
}	//fin clase juego

