package co.edu.uniquindio.juego.model;

import java.io.Serializable;
import java.util.Hashtable;

public class Juego implements Serializable {

	private static final long serialVersionUID = 1L;
	//Atributos
	private String nombre;
	private Hashtable<Integer,Pregunta> listaPreguntas = new Hashtable<Integer,Pregunta>();
	private Hashtable<Integer,Jugador> listaJugadores = new Hashtable<Integer,Jugador>();
	//registrarPregunta( listaPreguntas);

//
	
public Juego(String nombre, Hashtable<Integer, Pregunta> listaPreguntas, Hashtable<Integer, Jugador> listaJugadores) {
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

	
	
}	//fin clase juego

