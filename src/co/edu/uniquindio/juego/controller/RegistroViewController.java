package co.edu.uniquindio.juego.controller;

import java.io.File;

import co.edu.uniquindio.juego.Aplicacion;
import co.edu.uniquindio.juego.exceptions.JuegoException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class RegistroViewController {
    
Aplicacion aplicacion;
ModelFactoryController modelFactoryController;


@FXML
private TextField txtNombre;

@FXML
private Button btnVolver;

@FXML
private Button btnRegistrarJugador;

@FXML
private TextField txtContrasenia;


@FXML
void registrarJugador(ActionEvent event) {
    registrarJugador();
}

private void registrarJugador() {

    String nombre = txtNombre.getText();
    String contrasenia = txtContrasenia.getText();

    String informacionVerificada ="";

    informacionVerificada = verificarInformacionJugador(nombre, contrasenia);

    if(informacionVerificada.equalsIgnoreCase("Ok")){
      try{

        String mensaje ="";

        mensaje = modelFactoryController.registrarJugador(nombre,contrasenia);
		mostrarMensaje("Registro de jugadores", "Registro exitoso", mensaje, AlertType.INFORMATION);
        volver();
        }
        catch(JuegoException e){
            mostrarMensaje("Registro de jugadores", "Registro fallido", e.getMessage(), AlertType.ERROR);
        }

    }else{
        mostrarMensaje("Registro de jugadores", "Registro fallido", informacionVerificada, AlertType.WARNING);
    }
}

private String verificarInformacionJugador(String nombre, String contrasenia) {

    String mensaje ="";

    if(nombre.equalsIgnoreCase("")){
        mensaje += "Por favor ingrese el nombre del jugador \n";
    }
    if(contrasenia.equalsIgnoreCase("")){
        mensaje += "Por favor ingrese la contraseña del jugador \n";
    }
    if(mensaje.equalsIgnoreCase("")){
        mensaje="OK";
    }

    return mensaje;
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
void volver(ActionEvent event) {
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
