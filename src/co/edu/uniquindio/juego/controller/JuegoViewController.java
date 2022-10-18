package co.edu.uniquindio.juego.controller;

import java.io.File;
import java.util.LinkedList;

import co.edu.uniquindio.juego.Aplicacion;
import co.edu.uniquindio.juego.model.Pregunta;
import co.edu.uniquindio.juego.model.TipoPregunta;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.image.ImageView;
public class JuegoViewController {

    MediaPlayer mediaPlayer;
    Aplicacion aplicacion;
    ModelFactoryController modelFactoryController;
    int cantidadCorrectasSeguidas = 0;
    boolean cronometroCorriendo = false;
    JuegoViewControllerCronometro cronometro = new JuegoViewControllerCronometro();
    LinkedList<Pregunta> colaPreguntas = new LinkedList<Pregunta>();
    @FXML
    private Label txtPregunta;

    @FXML
    private Button btnPistaPista;

    @FXML
    private Button btnPistaSaltar;

    @FXML
    private Button btnPista5050;

    @FXML
    private Button btnRendirse;

    @FXML
    private ImageView vida1;

    @FXML
    private ImageView vida2;

    @FXML
    private ImageView vida3;

    @FXML
    public Label txtCronometro;

    @FXML
    private Button btnResponder1;

    @FXML
    private Button btnResponder2;

    @FXML
    private Button btnResponder3;

    @FXML
    private Button btnResponder4;

    @FXML
    private Label txtPuntuacion;

    @FXML
    void rendirse(ActionEvent event) {
        rendirse();
     
    }

    private void rendirse() {
        mediaPlayer.stop();
     cronometro.setCorriendo(false);
     cronometroCorriendo = false;
     aplicacion.cambiarEscena("views/MenuView.fxml");
    }

    @FXML
    void responder1(ActionEvent event) {

    }

    @FXML
    void responder2(ActionEvent event) {

    }

    @FXML
    void responder3(ActionEvent event) {

    }

    @FXML
    void responder4(ActionEvent event) {

    }

    @FXML
    void usarPista5050(ActionEvent event) {
        rendirse();
    }

    @FXML
    void usarPistaPista(ActionEvent event) {
        rendirse();
    }

    @FXML
    void usarPistaSaltar(ActionEvent event) {
        rendirse();
    }


    // @FXML
    // void parar(ActionEvent event) {
    //     if (cronometroCorriendo == true && cronometro.isCorriendo == true) {

    //         cronometro.setCorriendo(false);
    //         cronometroCorriendo = false;

    //     } else {
    //         System.out.println("No se puede parar el contador porque no esta corriendo");
    //     }
    // }



    public void setAplicacion(Aplicacion aplicacion) {
        this.aplicacion = aplicacion;
    }

    @FXML
    void initialize() {
        modelFactoryController = ModelFactoryController.getInstance();

        getColaData(TipoPregunta.FACIL);

        Pregunta preguntaPantalla = new Pregunta();

        preguntaPantalla=colaPreguntas.poll();

        txtPregunta.setText(preguntaPantalla.getPregunta());

        btnResponder1.setText(preguntaPantalla.getRespuestasIncorrectas().get(0).getRespuesta());
        btnResponder2.setText(preguntaPantalla.getRespuestasIncorrectas().get(1).getRespuesta()); 
        btnResponder3.setText(preguntaPantalla.getRespuestasIncorrectas().get(2).getRespuesta());  
        btnResponder4.setText(preguntaPantalla.getRespuestasIncorrectas().get(3).getRespuesta());

        iniciarCronometro();


    }

    private void getColaData(TipoPregunta tipoPregunta) {
        colaPreguntas.addAll(modelFactoryController.obtenerColaPreguntas(tipoPregunta));
    
    }

    private void iniciarCronometro() {

        cronometroCorriendo = true;
        cronometro = new JuegoViewControllerCronometro();
        cronometro.setControlador(this, cronometroCorriendo);
        
        String fileName = "src/resources/musica/Fondo.mp3";
        reproducirSonido(fileName);
        cronometro.start();
    }


    private void reproducirSonido(String filename){
        Media media= new Media(new File(filename).toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();
    }

    public void setCorriendo(boolean isCorriendo) {
        this.cronometroCorriendo = isCorriendo;
    }
}