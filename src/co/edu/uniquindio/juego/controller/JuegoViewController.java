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

    @FXML
    private Label labelCronometro;

    @FXML
    private Button btnIniciar;

    @FXML
    void iniciar(ActionEvent event) {
    
       Timer timer = new Timer();
           timer.scheduleAtFixedRate(new TimerTask() {
           public void run() {
            if(interval >= 0)
            {
                Platform.runLater(() -> labelCronometro.setText(""+interval));
                System.out.println(interval);
                interval--;
            }
            else
                timer.cancel();
        }
    }, 1000L,1000L);
}

    
    public void setAplicacion(Aplicacion aplicacion) {
        this.aplicacion=aplicacion;
    }


    

}