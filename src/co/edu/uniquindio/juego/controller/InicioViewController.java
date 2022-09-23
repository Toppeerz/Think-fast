package co.edu.uniquindio.juego.controller;

import co.edu.uniquindio.juego.Aplicacion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class InicioViewController {


    Aplicacion aplicacion;
    ModelFactoryController modelFactoryController;

    @FXML
    private Button btnIniciarSesion;

    @FXML
    private Button btnVerTablaPuntuaciones;

    @FXML
    private Label btnRegistrarse;

    
    @FXML
    void iniciarSesion(ActionEvent event) {
         iniciarSesion();
    }

    private void iniciarSesion() {
        aplicacion.cambiarEscena("views/IniciarSesionView.fxml");
    }

    @FXML
    void verTablaPuntuaciones(ActionEvent event) {
       verTablaPuntuaciones();
    }

    private void verTablaPuntuaciones() {
    }

    @FXML
    void registrarse(ActionEvent event) {
        registrarse();
    }

    private void registrarse() {
    }

    public void setAplicacion(Aplicacion aplicacion) {
        this.aplicacion=aplicacion;
    }


    @FXML
        void initialize() {
            modelFactoryController = ModelFactoryController.getInstance();
        }



}
