package co.edu.uniquindio.juego.controller;

import java.io.File;

import co.edu.uniquindio.juego.Aplicacion;
import co.edu.uniquindio.juego.model.Juego;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class JuegoViewController {

    MediaPlayer mediaPlayer;



    public static boolean corriendoCronometro;
    Aplicacion aplicacion;
    Juego juego = new Juego();
    long interval = 30;
    boolean isCorriendo = false;
    hilo hilo = new hilo();

    @FXML
    public Label labelCronometro;

    @FXML
    private Button btnIniciar;

    @FXML
    private Button btnParar;

    @FXML
    void iniciar(ActionEvent event) {

        if (isCorriendo == false) {
            isCorriendo = true;
            hilo = new hilo();
            hilo.setControlador(this, isCorriendo);
            
            String fileName = "fondo.mp4";
            reproducirSonido(fileName);
            hilo.start();
        } else {
            System.out.println("Ya esta corriendo");
        }
    }

    public void setAplicacion(Aplicacion aplicacion) {
        this.aplicacion = aplicacion;
    }

    @FXML
    void parar(ActionEvent event) {
        if (isCorriendo == true && hilo.isCorriendo == true) {

            hilo.setCorriendo(false);
            isCorriendo = false;

        } else {
            System.out.println("No se puede parar el contador porque no esta corriendo");
        }
    }

    public void setCorriendo(boolean isCorriendo) {
        this.isCorriendo = isCorriendo;
    }

    private void reproducirSonido(String filename){
        String patch = getClass().getResource(filename).getPath();
        System.out.println(patch);
        Media media= new Media(new File(patch).toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();

    }
}