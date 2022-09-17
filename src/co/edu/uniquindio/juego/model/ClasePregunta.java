package co.edu.uniquindio.juego.model;



public enum ClasePregunta{


    HISTORIA(0), DEPORTE(1), ARTE(2), ENTRETENIMIENTO(3), MATEMATICA(4), GEOGRAFIA(5);

	private int numeroClasePregunta;

	private ClasePregunta(int numeroClasePregunta) {
		this.numeroClasePregunta = numeroClasePregunta;
	}

	public int getNumeroClasePregunta() {
		return numeroClasePregunta;
	}

}


