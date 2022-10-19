package co.edu.uniquindio.juego.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

import co.edu.uniquindio.juego.Aplicacion;
import co.edu.uniquindio.juego.model.Pregunta;
import co.edu.uniquindio.juego.model.Respuesta;
import co.edu.uniquindio.juego.model.TipoPregunta;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class JuegoViewController {

    MediaPlayer mediaPlayer;
    Aplicacion aplicacion;
    ModelFactoryController modelFactoryController;
    int cantidadCorrectasSeguidas = 0;
    boolean cronometroCorriendo = false;
    JuegoViewControllerCronometro cronometro = new JuegoViewControllerCronometro();
    LinkedList<Pregunta> colaPreguntas = new LinkedList<Pregunta>();
    Pregunta preguntaPantalla = new Pregunta();
    int vidas;
    int puntuacion;

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
        seleccionarRespuesta(btnResponder1, preguntaPantalla.getRespuestas().get(0));
       
    }


    @FXML
    void responder2(ActionEvent event) {
        seleccionarRespuesta(btnResponder2, preguntaPantalla.getRespuestas().get(1));
       
    }

    @FXML
    void responder3(ActionEvent event) {
        seleccionarRespuesta(btnResponder3, preguntaPantalla.getRespuestas().get(2));
     
    }

    @FXML
    void responder4(ActionEvent event) {
        seleccionarRespuesta(btnResponder4, preguntaPantalla.getRespuestas().get(3));
        
    }
   

    private void seleccionarRespuesta(Button boton, Respuesta respuesta) {
        pararCronometro();
        boton.getStyleClass().add("respuestaSeleccionada");
        PauseTransition pause = new PauseTransition(
        Duration.seconds(1));
        PauseTransition pause2 = new PauseTransition(
        Duration.seconds(1));
        pause.setOnFinished(event -> {
           boton.getStyleClass().remove("respuestaSeleccionada");
           revelarRespuestas();
           responder(respuesta);
           pause2.play();
        });
        pause2.setOnFinished(event -> {
            removerRespuestas();
            cambiarPreguntaPantalla();
         });
        pause.play();

    }

    private void responder(Respuesta respuesta) {
        if(respuesta.isCorrecta()){
            cantidadCorrectasSeguidas++;
            puntuacion += 300*Integer.parseInt(txtCronometro.getText()); 
            txtPuntuacion.setText("Puntuacion: "+puntuacion);
        }else{
            cantidadCorrectasSeguidas=0;
            removerVida();
        }
        if(cantidadCorrectasSeguidas==5 && !preguntaPantalla.getTipoPregunta().equals(TipoPregunta.DIFICIL)){
            aumentarDificultadColaPreguntas();
            cantidadCorrectasSeguidas=0;
        }
    }

    private void aumentarDificultadColaPreguntas() {
        int preguntasQueFaltan = colaPreguntas.size();
        getColaDificultadAumentadaData(preguntasQueFaltan,preguntaPantalla.getTipoPregunta());
    }

    private void getColaDificultadAumentadaData(int preguntasQueFaltan, TipoPregunta tipoPregunta) {
        colaPreguntas.clear();
        colaPreguntas.addAll(modelFactoryController.obtenerColaDificultadAumentadaPreguntas(preguntasQueFaltan,tipoPregunta));
    }

    private void removerVida() {
        if(vidas==3){
            vida3.setImage(new Image(new File("src/resources/imagenes/Malo.png").toURI().toString()));
            vidas--;
        }else if(vidas==2){
            vida2.setImage(new Image(new File("src/resources/imagenes/Malo.png").toURI().toString()));
            vidas--;
        }else if(vidas==1){
            vida1.setImage(new Image(new File("src/resources/imagenes/Malo.png").toURI().toString()));
            vidas--;
        }else if(vidas==0){
           rendirse();}
    }

    
    private void cambiarPreguntaPantalla() {

        if(!btnPista5050.isVisible()){
            btnResponder1.setVisible(true);
            btnResponder2.setVisible(true);
            btnResponder3.setVisible(true);
            btnResponder4.setVisible(true);

        }

        preguntaPantalla = colaPreguntas.poll();

        Collections.shuffle(preguntaPantalla.getRespuestas());

        txtPregunta.setText(preguntaPantalla.getPregunta());

        btnResponder1.setText(preguntaPantalla.getRespuestas().get(0).getRespuesta());
        btnResponder2.setText(preguntaPantalla.getRespuestas().get(1).getRespuesta());
        btnResponder3.setText(preguntaPantalla.getRespuestas().get(2).getRespuesta());
        btnResponder4.setText(preguntaPantalla.getRespuestas().get(3).getRespuesta());
        iniciarCronometro();
    }

    private void revelarRespuestas() {

        ArrayList<Respuesta> respuestas = preguntaPantalla.getRespuestas();

        if(respuestas.get(0).isCorrecta()){
            btnResponder1.getStyleClass().add("respuestaCorrecta");
        }else{
            btnResponder1.getStyleClass().add("respuestaIncorrecta");
        }
        if(respuestas.get(1).isCorrecta()){
            btnResponder2.getStyleClass().add("respuestaCorrecta");
        }else{
            btnResponder2.getStyleClass().add("respuestaIncorrecta");
        }
        if(respuestas.get(2).isCorrecta()){
            btnResponder3.getStyleClass().add("respuestaCorrecta");
        }else{
            btnResponder3.getStyleClass().add("respuestaIncorrecta");
        }
        if(respuestas.get(3).isCorrecta()){
            btnResponder4.getStyleClass().add("respuestaCorrecta");
        }else{
            btnResponder4.getStyleClass().add("respuestaIncorrecta");
        }
       }

       private void removerRespuestas() {

        ArrayList<Respuesta> respuestas = preguntaPantalla.getRespuestas();

        if(respuestas.get(0).isCorrecta()){
            btnResponder1.getStyleClass().remove("respuestaCorrecta");
        }else{
            btnResponder1.getStyleClass().remove("respuestaIncorrecta");
        }
        if(respuestas.get(1).isCorrecta()){
            btnResponder2.getStyleClass().remove("respuestaCorrecta");
        }else{
            btnResponder2.getStyleClass().remove("respuestaIncorrecta");
        }
        if(respuestas.get(2).isCorrecta()){
            btnResponder3.getStyleClass().remove("respuestaCorrecta");
        }else{
            btnResponder3.getStyleClass().remove("respuestaIncorrecta");
        }
        if(respuestas.get(3).isCorrecta()){
            btnResponder4.getStyleClass().remove("respuestaCorrecta");
        }else{
            btnResponder4.getStyleClass().remove("respuestaIncorrecta");
        }
       }

    @FXML
    void usarPista5050(ActionEvent event) {
        usarPista5050();
    }

    private void usarPista5050() {
        ArrayList<Button> botones = new ArrayList<Button>();

        botones.add(btnResponder1);
        botones.add(btnResponder2);
        botones.add(btnResponder3);
        botones.add(btnResponder4);
        String respuestaCorrecta ="";
        
        for (int i = 0; i < preguntaPantalla.getRespuestas().size(); i++) {
            if(preguntaPantalla.getRespuestas().get(i).isCorrecta()){
             respuestaCorrecta = preguntaPantalla.getRespuestas().get(i).getRespuesta();
            }
        }

        for (int i = 0; i < botones.size(); i++) {
            if(botones.get(i).getText().equalsIgnoreCase(respuestaCorrecta)){
                botones.remove(i);
            }
        }

       
            
         Random rand = new Random();


         int n = rand.nextInt(3);

         botones.remove(n);



        for (int i = 0; i < botones.size(); i++) {
          botones.get(i).setVisible(false);
        }
        
        btnPista5050.setVisible(false);

    }

    @FXML
    void usarPistaPista(ActionEvent event) {
        rendirse();
    }

    @FXML
    void usarPistaSaltar(ActionEvent event) {
        rendirse();
    }



    public void setAplicacion(Aplicacion aplicacion) {
        this.aplicacion = aplicacion;
    }

    @FXML
    void initialize() {

        vidas = 3;
        puntuacion = 0;

        modelFactoryController = ModelFactoryController.getInstance();

        getColaData(TipoPregunta.FACIL);

        preguntaPantalla = colaPreguntas.poll();

        Collections.shuffle(preguntaPantalla.getRespuestas());

        txtPregunta.setText(preguntaPantalla.getPregunta());

        btnResponder1.setText(preguntaPantalla.getRespuestas().get(0).getRespuesta());
        btnResponder2.setText(preguntaPantalla.getRespuestas().get(1).getRespuesta());
        btnResponder3.setText(preguntaPantalla.getRespuestas().get(2).getRespuesta());
        btnResponder4.setText(preguntaPantalla.getRespuestas().get(3).getRespuesta());

        reproducirSonido();
        iniciarCronometro();

        txtCronometro.textProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue.equals("0")){
                rendirse();
            }
        });

    }

    private void getColaData(TipoPregunta tipoPregunta) {
        colaPreguntas.addAll(modelFactoryController.obtenerColaPreguntas());

    }

    private void iniciarCronometro() {

        cronometroCorriendo = true;
        cronometro = new JuegoViewControllerCronometro();
        cronometro.setControlador(this, cronometroCorriendo);
        cronometro.start();
    }

    private void pararCronometro() {
        cronometro.setCorriendo(false);
        cronometroCorriendo = false;

    }

    private void reproducirSonido() {
        String fileName = "src/resources/musica/Fondo.mp3";
        Media media = new Media(new File(fileName).toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();
    }

    public void setCorriendo(boolean isCorriendo) {
        this.cronometroCorriendo = isCorriendo;
    }
}