package co.edu.uniquindio.juego.controller;

import javafx.application.Platform;

public class JuegoViewControllerCronometro extends Thread {

    int interval = 30;
    JuegoViewController juegoViewController;
    boolean isCorriendo;

    public void run() {
        try {

            

            while (isCorriendo == true && interval >= 0) {
                Platform.runLater(() -> juegoViewController.txtCronometro.setText("" + interval));
                Thread.sleep(1000);
                interval--;
            }
            isCorriendo = false;
            juegoViewController.setCorriendo(false);
        } catch (Exception e) {
            System.out.println("Error");
        }

    }

    public void setControlador(JuegoViewController juegoViewController2, boolean isCorriendo) {
        this.juegoViewController = juegoViewController2;
        this.isCorriendo = isCorriendo;

    }

    public void setCorriendo(boolean isCorriendo) {
        this.isCorriendo = isCorriendo;
    }

    public boolean isCorriendo() {
        return isCorriendo;
    }

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

   

}
