package co.edu.uniquindio.juego.controller;

import java.util.Optional;

import co.edu.uniquindio.juego.Aplicacion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;

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
    private Button btnBorrarCuenta;

    @FXML
    void borrarCuenta(ActionEvent event) {
        borrarCuenta();
    }

    private void borrarCuenta() {
       

            String mensaje = "";
    
            boolean confirmacion;
            
            confirmacion = mostrarMensajeConfirmacion("Esta seguro?");
    
                    if(confirmacion == true){
                    mensaje = modelFactoryController.eliminarCuenta();
                    mostrarMensaje("Eliminacion de cuentas","Cuenta borrada",mensaje,AlertType.INFORMATION);
                    cerrarSesion();
                    }
                    }

    @FXML
    void verTablaPuntuaciones(ActionEvent event) {
    verTablaPuntuacionesAction();
    }
    

    private void verTablaPuntuacionesAction() {
        aplicacion.cambiarEscena("views/TablaPosiciones.fxml");

    }

    @FXML
    void verComoJugar(ActionEvent event) {
        comoJugar();

    }

    private void comoJugar() {
        aplicacion.cambiarEscena("views/ComoJugarView.fxml");

    }

    @FXML
    void iniciarJuego(ActionEvent event) {
         iniciarJuego();
    }

    private void iniciarJuego() {
        aplicacion.cambiarEscena("views/JuegoView.fxml");
    }

    @FXML
    void verCerrarSesion(ActionEvent event) {
        cerrarSesion();

    }

    private void cerrarSesion() {
        modelFactoryController.setJugadorLogueado(null);
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


    public void mostrarMensaje(String titulo, String header, String contenido, AlertType alertType) {

    	Alert alert = new Alert(alertType);
    	alert.setTitle(titulo);
    	alert.setHeaderText(header);
    	alert.setContentText(contenido);
    	alert.showAndWait();
    }


	/**
     * M�todo que permite mostrar un mensaje de confirmacion
     *
     * @param mensaje
     *
     * @return boolean
     */
	private boolean mostrarMensajeConfirmacion(String mensaje) {

		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setHeaderText(null);
		alert.setTitle("Confirmacion");
		alert.setContentText(mensaje);
		Optional<ButtonType> action = alert.showAndWait();

		if (action.get() == ButtonType.OK) {
			return true;
		} else {
			return false;
		}
	}
}

