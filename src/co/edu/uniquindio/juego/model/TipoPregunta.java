package co.edu.uniquindio.juego.model;

public enum TipoPregunta{

    FACIL(0), MEDIA(1), DIFICIL(2);

	private int numeroTipoPregunta;

	private TipoPregunta(int numeroTipoPregunta) {
		this.numeroTipoPregunta = numeroTipoPregunta;
	}

	public int getNumeroTipoPregunta() {
		return numeroTipoPregunta;
	}


}
