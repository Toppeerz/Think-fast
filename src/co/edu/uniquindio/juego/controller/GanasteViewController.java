package co.edu.uniquindio.juego.controller;

import co.edu.uniquindio.juego.Aplicacion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class GanasteViewController {

    
    Aplicacion aplicacion;
    ModelFactoryController modelFactoryController;
    
    @FXML
    private Button btnRegresar;

    @FXML
    void regresar(ActionEvent event) {
    volver();
    }


    
    private void volver() {
        aplicacion.cambiarEscena("views/IniciarSesionView.fxml");
    }


    public void setAplicacion(Aplicacion aplicacion) {
        this.aplicacion=aplicacion;
    }


    @FXML
        void initialize() {
            modelFactoryController = ModelFactoryController.getInstance();
        }
}
