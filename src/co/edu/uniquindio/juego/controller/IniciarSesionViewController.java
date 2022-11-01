package co.edu.uniquindio.juego.controller;

import java.io.File;
import java.util.Enumeration;
import java.util.Hashtable;

import co.edu.uniquindio.juego.Aplicacion;
import co.edu.uniquindio.juego.model.Jugador;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class IniciarSesionViewController {

    Aplicacion aplicacion;
    ModelFactoryController modelFactoryController;

    @FXML
    private Button btnIniciarSesion;


    @FXML
    private TextField txtNombre;

    @FXML
    private Button btnVolver;

    @FXML
    private TextField txtContrasenia;

    @FXML
    private Button btnVerTablaPuntuaciones;

    @FXML
    private Button btnRegistrarse;

    @FXML
    void iniciarSesion(ActionEvent event) {
        iniciarSesion();
    }

    private void iniciarSesion() {
        String nombre = txtNombre.getText();
        String contrasenia = txtContrasenia.getText();

            Hashtable<Integer, Jugador> listaJugadores = modelFactoryController.obtenerJugadores();
            if (!listaJugadores.isEmpty()) {
                Enumeration<Jugador> enumeracionJugador = listaJugadores.elements();
                Jugador jugador;
                String nombreJugador;
                String contraseniaJugador;
                boolean jugadorEncontrado = false;
                while (enumeracionJugador.hasMoreElements() && !jugadorEncontrado ) {
                    jugador = enumeracionJugador.nextElement();
                    nombreJugador = jugador.getNombre();
                    contraseniaJugador = jugador.getContrasenia();
                        if (nombre.equalsIgnoreCase(nombreJugador) && contrasenia.equalsIgnoreCase(contraseniaJugador)) {
                            jugadorEncontrado= true;
                            modelFactoryController.setJugadorLogueado(jugador);
                            aplicacion.cambiarEscena("views/MenuView.fxml");
                            
                        } 
                }

              if(!jugadorEncontrado){
                
                    mostrarMensaje("Inicio de sesion", "Datos incorrectos", "El usuario y/o la contrasenia son incorrectos", AlertType.ERROR);
                
              }

            }

            else {
                mostrarMensaje("Inicio de sesion", "No existen jugadores", "No existen jugadores con los cuales iniciar sesion", AlertType.WARNING);
            }

        }
    

    public void mostrarMensaje(String titulo, String header, String contenido, AlertType alertType) {

        Alert alert = new Alert(alertType);
        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(contenido);
        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image(new File("src/resources/imagenes/Logo.png").toURI().toString()));
        stage.showAndWait();
    }


    @FXML
    void verTablaPuntuaciones(ActionEvent event) {
        verTablaPuntuaciones();
    }

    private void verTablaPuntuaciones() {
        aplicacion.cambiarEscena("views/TablaPosiciones.fxml");
    }

    @FXML
    void registrarse(ActionEvent event) {
        registrarse();
    }

    private void registrarse() {
        aplicacion.cambiarEscena("views/RegistroView.fxml");
    }

    public void setAplicacion(Aplicacion aplicacion) {
        this.aplicacion = aplicacion;
    }

    @FXML
    void initialize() {
        modelFactoryController = ModelFactoryController.getInstance();
    }

}
