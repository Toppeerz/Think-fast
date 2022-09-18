package co.edu.uniquindio.juego;

import java.io.IOException;

import co.edu.uniquindio.juego.controller.JuegoViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Aplicacion extends Application {

	private Stage primaryStage;


	/**
	 * Metodo que permite Lanzar la Ventana Principal
	 * @author Juan David Ortega
	 *
	 */

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Marketplace FALCON");
		mostrarVentanaPrincipal();

	}

	public static void main(String[] args) {

		launch(args);


	}

	/**
	 * Metodo que muestra la vista principal (LoginMarketplace)
	 * @author Juan David Ortega
	 *
	 */

	/** * Initializes the root layout. */
	public void mostrarVentanaPrincipal() {

		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("views/JuegoView.fxml"));
			AnchorPane rootLayout = (AnchorPane)loader.load();
			JuegoViewController loginController = loader.getController();
			loginController.setAplicacion(this);
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
