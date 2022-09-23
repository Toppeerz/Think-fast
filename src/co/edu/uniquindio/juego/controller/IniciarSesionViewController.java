package co.edu.uniquindio.juego.controller;

import co.edu.uniquindio.juego.Aplicacion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

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
    private TextField txtCedula;

    

    @FXML
    void iniciarSesion(ActionEvent event) {

    }

    @FXML
    void volver(ActionEvent event) {
     volver();
    }

    private void volver() {
        aplicacion.cambiarEscena("views/InicioView.fxml");
    }

    public void setAplicacion(Aplicacion aplicacion) {
        this.aplicacion=aplicacion;
    }


    @FXML
        void initialize() {
            modelFactoryController = ModelFactoryController.getInstance();
        }


}

