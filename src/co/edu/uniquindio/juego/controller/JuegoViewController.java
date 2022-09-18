package co.edu.uniquindio.juego.controller;

import java.util.Timer;
import java.util.TimerTask;

import co.edu.uniquindio.juego.Aplicacion;
import co.edu.uniquindio.juego.model.Juego;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class JuegoViewController{

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
        if(isCorriendo==false){
            isCorriendo=true;
            hilo = new hilo();
            hilo.setControlador(this,isCorriendo);
            hilo.start();
          
    }else{
        System.out.println("Ya esta corriendo");
    }
    }

    
    
    public void setAplicacion(Aplicacion aplicacion) {
        this.aplicacion=aplicacion;
    }

    @FXML
    void parar(ActionEvent event) {
    if(isCorriendo==true && hilo.isCorriendo==true){
        hilo.setCorriendo(false);
        isCorriendo=false;
    }else{
        System.out.println("No se puede parar el contador porque no esta corriendo");
    }
    }




}