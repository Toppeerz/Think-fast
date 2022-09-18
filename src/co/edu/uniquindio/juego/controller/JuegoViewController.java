package co.edu.uniquindio.juego.controller;

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

    @FXML
    private Label labelCronometro;

    @FXML
    private Button btnIniciar;

    @FXML
    void iniciar(ActionEvent event) {
      
      
        (new Thread() {
            public void run(){
                for (int i = 0; i < 5; i++) {
                    try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                labelCronometro.setText("value " + i);
                Platform.runLater(() -> {
                
                    labelCronometro.setText("value ");
               
                });
                

            }
        }
    }).start();    
}

    
    public void setAplicacion(Aplicacion aplicacion) {
        this.aplicacion=aplicacion;
    }


    

}