package co.edu.uniquindio.juego.controller;

import co.edu.uniquindio.juego.Aplicacion;
import co.edu.uniquindio.juego.model.Jugador;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TablaPosicionesViewController {
    Aplicacion aplicacion;
    ModelFactoryController modelFactoryController;
    ObservableList<Jugador> listaJugadorData = FXCollections.observableArrayList();

    @FXML
    private TableView<Jugador> tablaJugadores;

    @FXML
    private TableColumn<Jugador, String> columnaNombre;

    @FXML
    private TableColumn<Jugador,Integer > columnaPuntuacion;

    @FXML
    private Button btnRegresar;

    @FXML
    void regresar(ActionEvent event) {
        regresarVentana();
    }

    private void regresarVentana() {
        if(modelFactoryController.getJugadorLogueado() != null ){
        aplicacion.cambiarEscena("views/MenuView.fxml");}
        else{
            aplicacion.cambiarEscena("views/IniciarSesionView.fxml");}

        }
    

    public void setAplicacion(Aplicacion aplicacion) {
        this.aplicacion = aplicacion;
    }
    
    @FXML
    void initialize() {
        modelFactoryController = ModelFactoryController.getInstance();

        this.columnaNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		this.columnaPuntuacion.setCellValueFactory(new PropertyValueFactory<>("puntaje"));



		tablaJugadores.getItems().clear();

		tablaJugadores.setItems(getListaJugadoresData());


    }
    private ObservableList<Jugador> getListaJugadoresData() {

		listaJugadorData.addAll(modelFactoryController.obtenerJugadoresOrdenados());
		return listaJugadorData;
	}


}