package co.edu.uniquindio.juego.model;

public class Respuesta {

    private String respuesta;
    private boolean correcta;
   
   
    public Respuesta(String respuesta, boolean correcta) {
        this.respuesta = respuesta;
        this.correcta = correcta;
    }


    public Respuesta() {
    }


    public String getRespuesta() {
        return respuesta;
    }


    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }


    public boolean isCorrecta() {
        return correcta;
    }


    public void setCorrecta(boolean correcta) {
        this.correcta = correcta;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (correcta ? 1231 : 1237);
        result = prime * result + ((respuesta == null) ? 0 : respuesta.hashCode());
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
        Respuesta other = (Respuesta) obj;
        if (correcta != other.correcta)
            return false;
        if (respuesta == null) {
            if (other.respuesta != null)
                return false;
        } else if (!respuesta.equals(other.respuesta))
            return false;
        return true;
    }

    
    
}
