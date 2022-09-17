package co.edu.uniquindio.juego.model;



public enum TipoPista{

    MITAD(0), SALTARPREGUNTA(1), PISTA(2);

	private int numeroTipoPista;

	private TipoPista(int numeroTipoPista) {
		this.numeroTipoPista = numeroTipoPista;
	}

	public int getNumeroTipoPista() {
		return numeroTipoPista;
	}



}
