package co.edu.uniquindio.juego.model;

import java.io.Serializable;
import java.util.ArrayList;


public class Pregunta implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

    private String pregunta;
	private TipoPregunta tipoPregunta;
	private ClasePregunta clasePregunta;
	private ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
	

	


	public Pregunta(String pregunta, String respuestaCorrecta,String respuestaIncorrecta1,String respuestaIncorrecta2,String respuestaIncorrecta3,TipoPregunta tipoPregunta, ClasePregunta clasePregunta) {
		
		this.pregunta = pregunta;
		this.tipoPregunta = tipoPregunta;
		this.clasePregunta = clasePregunta;
        Respuesta respuestaAuxCorrecta = new Respuesta(respuestaCorrecta, true);
		Respuesta respuestaAux1 = new Respuesta(respuestaIncorrecta1, false);
		Respuesta respuestaAux2 = new Respuesta(respuestaIncorrecta2, false);
		Respuesta respuestaAux3 = new Respuesta(respuestaIncorrecta3, false);
		this.respuestas.add(respuestaAuxCorrecta);
		this.respuestas.add(respuestaAux1);
		this.respuestas.add(respuestaAux2);
		this.respuestas.add(respuestaAux3);
	}





	public Pregunta() {
		
	}

	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public TipoPregunta getTipoPregunta() {
		return tipoPregunta;
	}

	public void setTipoPregunta(TipoPregunta tipoPregunta) {
		this.tipoPregunta = tipoPregunta;
	}

	public ClasePregunta getClasePregunta() {
		return clasePregunta;
	}

	public void setClasePregunta(ClasePregunta clasePregunta) {
		this.clasePregunta = clasePregunta;
	}

	public ArrayList<Respuesta> getRespuestas() {
		return respuestas;
	}

	public void setRespuestas(ArrayList<Respuesta> respuestas) {
		this.respuestas = respuestas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clasePregunta == null) ? 0 : clasePregunta.hashCode());
		result = prime * result + ((pregunta == null) ? 0 : pregunta.hashCode());
		result = prime * result + ((respuestas == null) ? 0 : respuestas.hashCode());
		result = prime * result + ((tipoPregunta == null) ? 0 : tipoPregunta.hashCode());
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
		Pregunta other = (Pregunta) obj;
		if (clasePregunta != other.clasePregunta)
			return false;
		if (pregunta == null) {
			if (other.pregunta != null)
				return false;
		} else if (!pregunta.equals(other.pregunta))
			return false;
		if (respuestas == null) {
			if (other.respuestas != null)
				return false;
		} else if (!respuestas.equals(other.respuestas))
			return false;
		if (tipoPregunta != other.tipoPregunta)
			return false;
		return true;
	}

	

	
	


}
