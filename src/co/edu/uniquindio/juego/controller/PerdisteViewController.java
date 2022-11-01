package co.edu.uniquindio.juego.controller;

import co.edu.uniquindio.juego.Aplicacion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class PerdisteViewController {

    Aplicacion aplicacion;
    ModelFactoryController modelFactoryController;
    
    @FXML
    private Button btnRegresar;

    @FXML
    private Label txtPuntuacion;

    @FXML
    void regresar(ActionEvent event) {
        volver();
    }

        
    private void volver() {
        aplicacion.cambiarEscena("views/MenuView.fxml");
    }


    public void setAplicacion(Aplicacion aplicacion) {
        this.aplicacion=aplicacion;
    }


    @FXML
        void initialize() {
            modelFactoryController = ModelFactoryController.getInstance();
            txtPuntuacion.setText("Puntuacion: "+ modelFactoryController.getPuntajeTemporal());
        }
}
