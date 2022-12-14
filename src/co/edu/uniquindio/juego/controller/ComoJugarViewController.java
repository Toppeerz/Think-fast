package co.edu.uniquindio.juego.controller;

import co.edu.uniquindio.juego.Aplicacion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ComoJugarViewController {
    Aplicacion aplicacion;
    ModelFactoryController modelFactoryController;


    @FXML
    private Button btnRegresar;

    @FXML
    void regresar(ActionEvent event) {
        regresarVentana();
    }

    private void regresarVentana() {
        aplicacion.cambiarEscena("views/MenuView.fxml");
    }

    public void setAplicacion(Aplicacion aplicacion) {
        this.aplicacion = aplicacion;
    }
    
    @FXML
    void initialize() {
        modelFactoryController = ModelFactoryController.getInstance();
    }

}
