package co.edu.uniquindio.juego.model;

import java.io.Serializable;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.LinkedList;
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


	public LinkedList<Pregunta> generarPreguntasTipoP(){
		Random rand = new Random();
		int numberOfElements = 180;
		LinkedList<Pregunta> preguntasAux = new LinkedList<Pregunta>();
		for (int i = 1; i < numberOfElements+1; i++) {
			preguntasAux.add(listaPreguntas.get(i));
		}
		LinkedList<Pregunta> colaPreguntas = new LinkedList<Pregunta>();
		
	
		for (int i = 0; i < numberOfElements && colaPreguntas.size()<10; i++) {
			int randomIndex = rand.nextInt(preguntasAux.size());
			Pregunta pregunta = preguntasAux.get(randomIndex);
			if(pregunta.getTipoPregunta().equals(TipoPregunta.FACIL)){
				colaPreguntas.add(pregunta);
			}
			preguntasAux.remove(randomIndex);
		}
		for (int i = 0; i < numberOfElements && colaPreguntas.size()<20; i++) {
			int randomIndex = rand.nextInt(preguntasAux.size());
			Pregunta pregunta = preguntasAux.get(randomIndex);
			if(pregunta.getTipoPregunta().equals(TipoPregunta.MEDIA)){
				colaPreguntas.add(pregunta);
			}
			preguntasAux.remove(randomIndex);
		}
		for (int i = 0; i < numberOfElements && colaPreguntas.size()<30; i++) {
			int randomIndex = rand.nextInt(preguntasAux.size());
			Pregunta pregunta = preguntasAux.get(randomIndex);
			if(pregunta.getTipoPregunta().equals(TipoPregunta.DIFICIL)){
				colaPreguntas.add(pregunta);
			}
			preguntasAux.remove(randomIndex);
		}
		return colaPreguntas;
	}

    public LinkedList<Pregunta> generarPreguntasDificultadAumentada(int preguntasQueFaltan, TipoPregunta tipoPregunta) {
		Random rand = new Random();
		int numberOfElements = 180;
		LinkedList<Pregunta> preguntasAux = new LinkedList<Pregunta>();
		for (int i = 1; i < numberOfElements+1; i++) {
			preguntasAux.add(listaPreguntas.get(i));
		}
		LinkedList<Pregunta> colaPreguntas = new LinkedList<Pregunta>();
		
	if(tipoPregunta.equals(TipoPregunta.FACIL)){
		for (int i = 0; i < numberOfElements && colaPreguntas.size()<preguntasQueFaltan-10; i++) {
			int randomIndex = rand.nextInt(preguntasAux.size());
			Pregunta pregunta = preguntasAux.get(randomIndex);
			if(pregunta.getTipoPregunta().equals(TipoPregunta.MEDIA)){
				colaPreguntas.add(pregunta);
			}
			preguntasAux.remove(randomIndex);
		}

		for (int i = 0; i < numberOfElements && colaPreguntas.size()<preguntasQueFaltan; i++) {
			int randomIndex = rand.nextInt(preguntasAux.size());
			Pregunta pregunta = preguntasAux.get(randomIndex);
			if(pregunta.getTipoPregunta().equals(TipoPregunta.DIFICIL)){
				colaPreguntas.add(pregunta);
			}
			preguntasAux.remove(randomIndex);
		}
	}else if(tipoPregunta.equals(TipoPregunta.MEDIA)){
		for (int i = 0; i < numberOfElements && colaPreguntas.size()<preguntasQueFaltan; i++) {
			int randomIndex = rand.nextInt(preguntasAux.size());
			Pregunta pregunta = preguntasAux.get(randomIndex);
			if(pregunta.getTipoPregunta().equals(TipoPregunta.DIFICIL)){
				colaPreguntas.add(pregunta);
			}
			preguntasAux.remove(randomIndex);
		}
	}
		return colaPreguntas;
	}
    
	

} // fin clase juego
