package co.edu.uniquindio.juego.controller;

import javafx.application.Platform;

public class hilo extends Thread {

    int interval;
    JuegoViewController juegoViewController;
    boolean isCorriendo;

    public void run() {
        try {

            interval = 30;

            while (isCorriendo == true && interval >= 0) {
                Platform.runLater(() -> juegoViewController.labelCronometro.setText("" + interval));
                System.out.println(interval + Thread.currentThread().getName());
                interval--;
                Thread.sleep(500);
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

}
