package co.edu.uniquindio.juego.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import co.edu.uniquindio.juego.exceptions.JuegoException;

public class Juego implements Serializable {

	private static final long serialVersionUID = 1L;
	// Atributos
	private String nombre;
	private Hashtable<Integer, Pregunta> listaPreguntas = new Hashtable<Integer, Pregunta>();
	private Hashtable<Integer, Jugador> listaJugadores = new Hashtable<Integer, Jugador>();
	

	

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


	private LinkedList<Pregunta> generarPreguntasTipoP(TipoPregunta tipoP){
		LinkedList <Pregunta> colaPreguntas = new LinkedList<Pregunta>();
		List<Integer> numeros = new ArrayList<>(180);

		for (int i=1;i<181;i++){
		numeros.add(i);
		}
		Random random = new Random();
		while (colaPreguntas.size()<10){

		int posicionPregunta = random.nextInt(numeros.size())+1;
		Pregunta preguntaAux = listaPreguntas.get(posicionPregunta);

		if(preguntaAux.getTipoPregunta().equals(tipoP))
		{
			colaPreguntas.add(preguntaAux);
		}
		numeros.remove(posicionPregunta);
		}
		return colaPreguntas;
	}


	

} // fin clase juego
