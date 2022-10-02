package co.edu.uniquindio.juego;

import java.io.File;
import java.io.IOException;

import co.edu.uniquindio.juego.controller.IniciarSesionViewController;
import co.edu.uniquindio.juego.controller.MenuViewController;
import co.edu.uniquindio.juego.controller.RegistroViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
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
		primaryStage.getIcons().add(new Image(new File("src/resources/imagenes/Logo.png").toURI().toString()));
		this.primaryStage.setTitle("Think Fast");
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
			loader.setLocation(Aplicacion.class.getResource("views/IniciarSesionView.fxml"));
			AnchorPane rootLayout = (AnchorPane)loader.load();
			IniciarSesionViewController iniciarSesionViewController = loader.getController();
			iniciarSesionViewController.setAplicacion(this);
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo que permite cambiar de una vista a otra
	 * @author Juan David Ortega
	 *
	 */

	public void cambiarEscena(String fxmlFile)
	{

	    FXMLLoader loader = new FXMLLoader(getClass() .getResource(fxmlFile));
	    Parent root;
	    try
	    {
	        root = (Parent)loader.load();
	        if(fxmlFile.equals("views/IniciarSesionView.fxml"))
	        {
	        	IniciarSesionViewController iniciarSesionViewController = loader.getController();
	        	iniciarSesionViewController.setAplicacion(this);
	        } else if(fxmlFile.equals("views/RegistroView.fxml"))
	        {
	        	RegistroViewController registroViewController = loader.getController();
	        	registroViewController.setAplicacion(this);
	        }else if(fxmlFile.equals("views/MenuView.fxml"))
	        {
	        	MenuViewController menuViewController = loader.getController();
	        	menuViewController.setAplicacion(this);
	        }
	        this.primaryStage.setScene(new Scene(root));
	    }
	    catch (IOException e)
	    {
	        e.printStackTrace();
	    }

	}

}


