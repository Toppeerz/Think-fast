package co.edu.uniquindio.juego.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Pregunta implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

    private String pregunta;
	private String respuesta;
	private TipoPregunta tipoPregunta;
	private ClasePregunta clasePregunta;
	private ArrayList<String> respuestasIncorrectas = new ArrayList<String>();
	
	public Pregunta(String pregunta, String respuesta, TipoPregunta tipoPregunta, ClasePregunta clasePregunta) {
		
		this.pregunta = pregunta;
		this.respuesta = respuesta;
		this.tipoPregunta = tipoPregunta;
		this.clasePregunta = clasePregunta;
	}

	public Pregunta() {
		
	}

	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
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

	public ArrayList<String> getRespuestasIncorrectas() {
		return respuestasIncorrectas;
	}

	public void setRespuestasIncorrectas(ArrayList<String> respuestasIncorrectas) {
		this.respuestasIncorrectas = respuestasIncorrectas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clasePregunta == null) ? 0 : clasePregunta.hashCode());
		result = prime * result + ((pregunta == null) ? 0 : pregunta.hashCode());
		result = prime * result + ((respuesta == null) ? 0 : respuesta.hashCode());
		result = prime * result + ((respuestasIncorrectas == null) ? 0 : respuestasIncorrectas.hashCode());
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
		if (respuesta == null) {
			if (other.respuesta != null)
				return false;
		} else if (!respuesta.equals(other.respuesta))
			return false;
		if (respuestasIncorrectas == null) {
			if (other.respuestasIncorrectas != null)
				return false;
		} else if (!respuestasIncorrectas.equals(other.respuestasIncorrectas))
			return false;
		if (tipoPregunta != other.tipoPregunta)
			return false;
		return true;
	}

	

	
	


}
