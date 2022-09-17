package co.edu.uniquindio.juego;

import co.edu.uniquindio.juego.model.Juego;
import co.edu.uniquindio.juego.persistencia.Persistencia;

public class Aplicacion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Juego juego=Persistencia.cargarRecursoBancoXML();
		System.out.println(juego.getPrueba());
	}

}
