package co.edu.uniquindio.juego.controller;

import co.edu.uniquindio.juego.Aplicacion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MenuViewController {
    
    Aplicacion aplicacion;
    ModelFactoryController modelFactoryController;
    
    @FXML
    private Button btnVerTablaPuntuaciones;

    @FXML
    private Button btnIniciarJuego;

    @FXML
    private Button btnVerComoJugar;

    @FXML
    private Button btnCerrarSesion;

    @FXML
    private Label txtNombreLogueado;

    @FXML
    void verTablaPuntuaciones(ActionEvent event) {

    }

    @FXML
    void verComoJugar(ActionEvent event) {

    }

    @FXML
    void iniciarJuego(ActionEvent event) {

    }

    @FXML
    void verCerrarSesion(ActionEvent event) {
        cerrarSesion();

    }

    private void cerrarSesion() {
        aplicacion.cambiarEscena("views/IniciarSesionView.fxml");
    }

    public void setAplicacion(Aplicacion aplicacion) {
        this.aplicacion = aplicacion;
    }

    @FXML
    void initialize() {
        modelFactoryController = ModelFactoryController.getInstance();
        txtNombreLogueado.setText("Logueado como: \n" +"   "+ modelFactoryController.getJugadorLogueado().getNombre());
    }

}
