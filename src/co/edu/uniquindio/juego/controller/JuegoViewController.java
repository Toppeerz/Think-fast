package co.edu.uniquindio.juego.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

import co.edu.uniquindio.juego.Aplicacion;
import co.edu.uniquindio.juego.model.Jugador;
import co.edu.uniquindio.juego.model.Pregunta;
import co.edu.uniquindio.juego.model.Respuesta;
import co.edu.uniquindio.juego.model.TipoPregunta;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class JuegoViewController {

    Jugador jugadorLogueado;
    boolean perdio;
    MediaPlayer mediaPlayer;
    Aplicacion aplicacion;
    ModelFactoryController modelFactoryController;
    int cantidadCorrectasSeguidas = 0;
    boolean cronometroCorriendo = false;
    JuegoViewControllerCronometro cronometro = new JuegoViewControllerCronometro();
    LinkedList<Pregunta> colaPreguntas = new LinkedList<Pregunta>();
    Pregunta preguntaPantalla = new Pregunta();
    int vidas;
    int puntuacion = 0;
    PauseTransition pausaPista = new PauseTransition(
            Duration.seconds(10));
    PauseTransition pausaUno = new PauseTransition(
            Duration.seconds(2));
    PauseTransition pausaDos = new PauseTransition(
            Duration.seconds(2));

    @FXML
    private Label txtPregunta;

    @FXML
    private Button btnPistaParar;

    @FXML
    private Label txtClasePregunta;

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
        rendirse("views/PerdisteView.fxml");

    }

    private void rendirse(String fxmlFile) {
        detenerTodo();
        mediaPlayer.stop();
        pararCronometro();
        cambiarPuntaje();
        aplicacion.cambiarEscena(fxmlFile);
    }

    private void detenerTodo() {
        pausaPista.stop();
        pausaDos.stop();
        pausaUno.stop();
    }

    private void cambiarPuntaje() {
        if (jugadorLogueado.getPuntaje() < puntuacion) {
            modelFactoryController.cambiarPuntaje(puntuacion);
        }
        modelFactoryController.setPuntajeTemporal(puntuacion);
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
        cambiarEstadoBotones(true);
        pausaPista.stop();
        pararCronometro();
        boton.getStyleClass().add("respuestaSeleccionada");
        pausaUno.setOnFinished(event -> {
            boton.getStyleClass().remove("respuestaSeleccionada");
            revelarRespuestas();
            responder(respuesta);
            pausaDos.play();
        });
        pausaDos.setOnFinished(event -> {
            removerRespuestas();
            cambiarPreguntaPantalla();
        });
        pausaUno.play();

    }

    private void cambiarEstadoBotones(boolean b) {
        btnResponder1.setDisable(b);
        btnResponder2.setDisable(b);
        btnResponder3.setDisable(b);
        btnResponder4.setDisable(b);
    }

    private void responder(Respuesta respuesta) {
        if (respuesta.isCorrecta()) {
            cantidadCorrectasSeguidas++;
            puntuacion += 300 * Integer.parseInt(txtCronometro.getText());
            txtPuntuacion.setText("Puntuacion: " + puntuacion);
        } else {
            cantidadCorrectasSeguidas = 0;
            puntuacion -= 100;
            txtPuntuacion.setText("Puntuacion: " + puntuacion);
            removerVida();
        }
        if (cantidadCorrectasSeguidas == 5 && !preguntaPantalla.getTipoPregunta().equals(TipoPregunta.DIFICIL)) {
            aumentarDificultadColaPreguntas();
            cantidadCorrectasSeguidas = 0;
        }
    }

    private void aumentarDificultadColaPreguntas() {
        int preguntasQueFaltan = colaPreguntas.size();
        getColaDificultadAumentadaData(preguntasQueFaltan, preguntaPantalla.getTipoPregunta());
    }

    private void getColaDificultadAumentadaData(int preguntasQueFaltan, TipoPregunta tipoPregunta) {
        colaPreguntas.clear();
        colaPreguntas.addAll(
                modelFactoryController.obtenerColaDificultadAumentadaPreguntas(preguntasQueFaltan, tipoPregunta));
    }

    private void removerVida() {
        if (vidas == 3) {
            vida3.setImage(new Image(new File("src/resources/imagenes/Malo.png").toURI().toString()));
            vidas--;
        } else if (vidas == 2) {
            vida2.setImage(new Image(new File("src/resources/imagenes/Malo.png").toURI().toString()));
            vidas--;
        } else if (vidas == 1) {
            vida1.setImage(new Image(new File("src/resources/imagenes/Malo.png").toURI().toString()));
            vidas--;
        } else if (vidas == 0) {
            perdio = true;
            rendirse("views/PerdisteView.fxml");
        }
    }

    private void cambiarPreguntaPantalla() {
        if (!perdio) {
            if (!btnPista5050.isVisible()) {
                btnResponder1.setVisible(true);
                btnResponder2.setVisible(true);
                btnResponder3.setVisible(true);
                btnResponder4.setVisible(true);

            }

            cambiarEstadoBotones(false);

            if (!colaPreguntas.isEmpty()) {
                preguntaPantalla = colaPreguntas.poll();

                Collections.shuffle(preguntaPantalla.getRespuestas());

                txtClasePregunta.setText(preguntaPantalla.getClasePregunta().name());

                txtPregunta.setText(preguntaPantalla.getPregunta());

                btnResponder1.setText(preguntaPantalla.getRespuestas().get(0).getRespuesta());
                btnResponder2.setText(preguntaPantalla.getRespuestas().get(1).getRespuesta());
                btnResponder3.setText(preguntaPantalla.getRespuestas().get(2).getRespuesta());
                btnResponder4.setText(preguntaPantalla.getRespuestas().get(3).getRespuesta());
                iniciarCronometro();
            } else {

                rendirse("views/GanasteView.fxml");

            }
        }
    }

    private void revelarRespuestas() {

        ArrayList<Respuesta> respuestas = preguntaPantalla.getRespuestas();

        if (respuestas.get(0).isCorrecta()) {
            btnResponder1.getStyleClass().add("respuestaCorrecta");
        } else {
            btnResponder1.getStyleClass().add("respuestaIncorrecta");
        }
        if (respuestas.get(1).isCorrecta()) {
            btnResponder2.getStyleClass().add("respuestaCorrecta");
        } else {
            btnResponder2.getStyleClass().add("respuestaIncorrecta");
        }
        if (respuestas.get(2).isCorrecta()) {
            btnResponder3.getStyleClass().add("respuestaCorrecta");
        } else {
            btnResponder3.getStyleClass().add("respuestaIncorrecta");
        }
        if (respuestas.get(3).isCorrecta()) {
            btnResponder4.getStyleClass().add("respuestaCorrecta");
        } else {
            btnResponder4.getStyleClass().add("respuestaIncorrecta");
        }

    }

    private void removerRespuestas() {

        ArrayList<Respuesta> respuestas = preguntaPantalla.getRespuestas();

        if (respuestas.get(0).isCorrecta()) {
            btnResponder1.getStyleClass().remove("respuestaCorrecta");
        } else {
            btnResponder1.getStyleClass().remove("respuestaIncorrecta");
        }
        if (respuestas.get(1).isCorrecta()) {
            btnResponder2.getStyleClass().remove("respuestaCorrecta");
        } else {
            btnResponder2.getStyleClass().remove("respuestaIncorrecta");
        }
        if (respuestas.get(2).isCorrecta()) {
            btnResponder3.getStyleClass().remove("respuestaCorrecta");
        } else {
            btnResponder3.getStyleClass().remove("respuestaIncorrecta");
        }
        if (respuestas.get(3).isCorrecta()) {
            btnResponder4.getStyleClass().remove("respuestaCorrecta");
        } else {
            btnResponder4.getStyleClass().remove("respuestaIncorrecta");
        }
        btnPistaSaltar.setDisable(false);

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
        String respuestaCorrecta = "";

        for (int i = 0; i < preguntaPantalla.getRespuestas().size(); i++) {
            if (preguntaPantalla.getRespuestas().get(i).isCorrecta()) {
                respuestaCorrecta = preguntaPantalla.getRespuestas().get(i).getRespuesta();
            }
        }

        for (int i = 0; i < botones.size(); i++) {
            if (botones.get(i).getText().equalsIgnoreCase(respuestaCorrecta)) {
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

        puntuacion -= 100;
        txtPuntuacion.setText("Puntuacion: " + puntuacion);
    }

    @FXML
    void usarPistaParar(ActionEvent event) {
        usarPistaParar();
    }

    private void usarPistaParar() {
        int tiempoRestante = cronometro.getInterval();
        pararCronometro();
        pausaPista.setOnFinished(event -> {
            iniciarCronometro();
            cronometro.setInterval(tiempoRestante);
            btnPistaSaltar.setDisable(false);
        });
        pausaPista.play();
        btnPistaParar.setVisible(false);
        btnPistaSaltar.setDisable(true);
        puntuacion -= 100;
        txtPuntuacion.setText("Puntuacion: " + puntuacion);
    }

    @FXML
    void usarPistaSaltar(ActionEvent event) {
        usarPistaSaltar();
    }

    private void usarPistaSaltar() {
        pararCronometro();
        cambiarPreguntaPantalla();
        btnPistaSaltar.setVisible(false);
        puntuacion -= 100;
        txtPuntuacion.setText("Puntuacion: " + puntuacion);
    }

    public void setAplicacion(Aplicacion aplicacion) {
        this.aplicacion = aplicacion;
    }

    @FXML
    void initialize() {

        vidas = 3;
        puntuacion = 0;
        perdio = false;

        modelFactoryController = ModelFactoryController.getInstance();

        jugadorLogueado = modelFactoryController.getJugadorLogueado();

        getColaData(TipoPregunta.FACIL);

        preguntaPantalla = colaPreguntas.poll();

        Collections.shuffle(preguntaPantalla.getRespuestas());

        txtClasePregunta.setText(preguntaPantalla.getClasePregunta().name());
        txtPregunta.setText(preguntaPantalla.getPregunta());

        btnResponder1.setText(preguntaPantalla.getRespuestas().get(0).getRespuesta());
        btnResponder2.setText(preguntaPantalla.getRespuestas().get(1).getRespuesta());
        btnResponder3.setText(preguntaPantalla.getRespuestas().get(2).getRespuesta());
        btnResponder4.setText(preguntaPantalla.getRespuestas().get(3).getRespuesta());

        reproducirSonido();
        iniciarCronometro();

        txtCronometro.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.equals("0")) {
                rendirse("views/PerdisteView.fxml");
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