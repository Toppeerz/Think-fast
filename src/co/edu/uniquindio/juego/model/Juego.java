package co.edu.uniquindio.juego.model;

import java.io.Serializable;
import java.util.Enumeration;
import java.util.Hashtable;

import co.edu.uniquindio.juego.exceptions.JuegoException;

public class Juego implements Serializable {

	private static final long serialVersionUID = 1L;
	// Atributos
	private String nombre;
	private Hashtable<Integer, Pregunta> listaPreguntas = new Hashtable<Integer, Pregunta>();
	private Hashtable<Integer, Jugador> listaJugadores = new Hashtable<Integer, Jugador>();
	// registrarPregunta( listaPreguntas);

	//

	public Juego(String nombre, Hashtable<Integer, Pregunta> listaPreguntas,
			Hashtable<Integer, Jugador> listaJugadores) {
		this.nombre = nombre;
		this.listaPreguntas = listaPreguntas;
		this.listaJugadores = listaJugadores;
	}

	public Juego() {
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Hashtable<Integer, Pregunta> getListaPreguntas() {
		return listaPreguntas;
	}

	public void setListaPreguntas(Hashtable<Integer, Pregunta> listaPreguntas) {
		this.listaPreguntas = listaPreguntas;
	}

	public Hashtable<Integer, Jugador> getListaJugadores() {
		return listaJugadores;
	}

	public void setListaJugadores(Hashtable<Integer, Jugador> listaJugadores) {
		this.listaJugadores = listaJugadores;
	}

	public String crearJugador(String nombreJugador, String contrasenia) throws JuegoException {
		String mensaje = "";

		boolean usuarioVerificado = verificarNombre(nombreJugador);

		if (!usuarioVerificado) {
			throw new JuegoException("Ya hay un jugador registrado con ese nombre");
		} else {

            Jugador jugadorNuevo = new Jugador(nombreJugador,contrasenia);

			listaJugadores.put(listaJugadores.size(), jugadorNuevo);

			Enumeration<Integer> enumeracionJugador = listaJugadores.keys();
		     int jugador;
		    while (enumeracionJugador.hasMoreElements()) {
			jugador = enumeracionJugador.nextElement();
			System.out.println(jugador);
			}
		

			mensaje = "Registro del jugador exitoso";

		}
		return mensaje;

	}

	private boolean verificarNombre(String nombreJugador) {

		Enumeration<Jugador> enumeracionJugador = listaJugadores.elements();
		Jugador jugador;
		while (enumeracionJugador.hasMoreElements()) {
			jugador = enumeracionJugador.nextElement();
			if (jugador.getNombre().equalsIgnoreCase(nombreJugador)) {
				return false;
			}
		}

		return true;
	}

	

} // fin clase juego
