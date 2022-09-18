package co.edu.uniquindio.juego.model;

import java.io.Serializable;
import java.util.Hashtable;

public class Juego implements Serializable {

	private static final long serialVersionUID = 1L;
	//Atributos
	private String nombre;
	private Hashtable<Integer,Pregunta> listaPreguntas = new Hashtable<Integer,Pregunta>();
	private Hashtable<Integer,Jugador> listaJugadores = new Hashtable<Integer,Jugador>();
	//registrarPregunta( listaPreguntas);

//
	
public Juego(String nombre, Hashtable<Integer, Pregunta> listaPreguntas, Hashtable<Integer, Jugador> listaJugadores) {
	this.nombre = nombre;
	this.listaPreguntas = listaPreguntas;
	this.listaJugadores = listaJugadores;
}

public Juego() {
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public Hashtable<Integer, Pregunta> getListaPreguntas() {
	return listaPreguntas;
}

public void setListaPreguntas(Hashtable<Integer, Pregunta> listaPreguntas) {
	this.listaPreguntas = listaPreguntas;
}

public Hashtable<Integer, Jugador> getListaJugadores() {
	return listaJugadores;
}

public void setListaJugadores(Hashtable<Integer, Jugador> listaJugadores) {
	this.listaJugadores = listaJugadores;
}

private void registrarPregunta(Hashtable<Integer,Pregunta> listaPreguntas){
	Pregunta pregunta1= new Pregunta("¿Para qué sirve la paleta?","Para mezclar pinturas",TipoPregunta.FACIL,ClasePregunta.ARTE);
	Pregunta pregunta2= new Pregunta("¿Qué tendencia musical es la que más incursiona en Jamaica?","Reggae",TipoPregunta.FACIL,ClasePregunta.ARTE);
	Pregunta pregunta3= new Pregunta("¿Qué usamos para diluir los colores de las acuarelas?","Agua",TipoPregunta.FACIL,ClasePregunta.ARTE);
	Pregunta pregunta4= new Pregunta("¿Cuántos dedos tiene por lo general una caricatura?","Cuatro",TipoPregunta.FACIL,ClasePregunta.ARTE);
	Pregunta pregunta5= new Pregunta("¿Qué nota musical hay entre re y fa?","Mi",TipoPregunta.FACIL,ClasePregunta.ARTE);
	Pregunta pregunta6= new Pregunta("Más vale pájaro en mano...","que cien volando",TipoPregunta.FACIL,ClasePregunta.ARTE);
	Pregunta pregunta7= new Pregunta("¿A qué se dedicaban los siete enanitos?","Eran mineros",TipoPregunta.FACIL,ClasePregunta.ARTE);
	Pregunta pregunta8= new Pregunta("Perro que ladra...","No muerde",TipoPregunta.FACIL,ClasePregunta.ARTE);
	Pregunta pregunta9= new Pregunta("¿A qué familia de instrumentos pertenece la guitarra, el violín y el bajo?","Cuerdas",TipoPregunta.FACIL,ClasePregunta.ARTE);
	Pregunta pregunta10= new Pregunta("¿En qué novela el protagonista es un asesino en serie con un sentido del olfato increíblemente desarrollado?","El Perfume",TipoPregunta.FACIL,ClasePregunta.ARTE);

	Pregunta pregunta11= new Pregunta("Gabriel García Márquez se caracteriza por narrar en un mundo:","Real Maravilloso",TipoPregunta.MEDIA,ClasePregunta.ARTE);
	Pregunta pregunta12= new Pregunta("¿Quién era la diosa de la sabiduría en la mitología griega?","Atena",TipoPregunta.MEDIA,ClasePregunta.ARTE);
	Pregunta pregunta13= new Pregunta("¿Cuál es el nombre de Picasso?","pablo",TipoPregunta.MEDIA,ClasePregunta.ARTE);
	Pregunta pregunta14= new Pregunta("¿Tira la piedra...?","Y esconde la mano",TipoPregunta.MEDIA,ClasePregunta.ARTE);
	Pregunta pregunta15= new Pregunta("¿A qué ciudad vasca dedicó un cuadro Pablo Picasso?","Guernica",TipoPregunta.MEDIA,ClasePregunta.ARTE);
	Pregunta pregunta16= new Pregunta("¿Quién escribió la novela 'Contagio'?","Robin Cook",TipoPregunta.MEDIA,ClasePregunta.ARTE);
	Pregunta pregunta17= new Pregunta("¿Qué pieza de arte fue robada y guardada debajo de una cama hasta que se devolvió al Museo Louvre?","Mona Lisa",TipoPregunta.MEDIA,ClasePregunta.ARTE);
	Pregunta pregunta18= new Pregunta("¿Qué instrumento tocaba Zeta Bosio en Soda Stereo?","Bajo",TipoPregunta.MEDIA,ClasePregunta.ARTE);
	Pregunta pregunta19= new Pregunta("¿Qué parte del cuerpo se cortó Vicent Van Gogh?","Oreja",TipoPregunta.MEDIA,ClasePregunta.ARTE);
	Pregunta pregunta20= new Pregunta("De qué país es la caricatura 'Condorito'?","Chile",TipoPregunta.MEDIA,ClasePregunta.ARTE);

	Pregunta pregunta21= new Pregunta("¿Cuál es la famosa cueva en la que se narra el Quijote?","Montesinos",TipoPregunta.DIFICIL,ClasePregunta.ARTE);
	Pregunta pregunta22= new Pregunta("¿Cuántos anillos fueron creados por Sauron para los Señores Enanos en el Señor de los Anillos?","7",TipoPregunta.DIFICIL,ClasePregunta.ARTE);
	Pregunta pregunta23= new Pregunta("¿Cuál de las siguientes palabras es esdrújula?","Metálico",TipoPregunta.DIFICIL,ClasePregunta.ARTE);
	Pregunta pregunta24= new Pregunta("¿Cuál es la obra cumbre en la literatura española escrita por Fernando de Rojas?","La Celestina",TipoPregunta.DIFICIL,ClasePregunta.ARTE);
	Pregunta pregunta25= new Pregunta("¿Cuál de las siguientes obras no pertenece a Edgar Allan Poe?","El monte de las ánimas",TipoPregunta.DIFICIL,ClasePregunta.ARTE);
	Pregunta pregunta26= new Pregunta("¿Qué obra NO pertenece a Shakespeare?","La Divina Comedia",TipoPregunta.DIFICIL,ClasePregunta.ARTE);
	Pregunta pregunta27= new Pregunta("¿Qué color consigues mezclando todos los colores del CMYK?","Negro",TipoPregunta.DIFICIL,ClasePregunta.ARTE);
	Pregunta pregunta28= new Pregunta("¿Quién pintó el cuadro La Persistencia de la Memoria?","Dalí",TipoPregunta.DIFICIL,ClasePregunta.ARTE);
	Pregunta pregunta29= new Pregunta("¿Cuántos 'gritos' pintó Munch?","Cuatro",TipoPregunta.DIFICIL,ClasePregunta.ARTE);
	Pregunta pregunta30= new Pregunta("¿De qué murió Jean Valjean en la novela 'Los Miserables'?","De viejo",TipoPregunta.DIFICIL,ClasePregunta.ARTE);

	Pregunta pregunta31= new Pregunta("¿En cuál de los siguientes deportes se puede tocar el balón con las manos?","Baloncesto",TipoPregunta.FACIL,ClasePregunta.DEPORTE);
	Pregunta pregunta32= new Pregunta("¿A qué deporte pertenece la WWE?","Lucha libre",TipoPregunta.FACIL,ClasePregunta.DEPORTE);
	Pregunta pregunta33= new Pregunta("¿Qué deporte estamos viendo si el árbitro señala 'falta de rotación'?","Voleibol",TipoPregunta.FACIL,ClasePregunta.DEPORTE);
	Pregunta pregunta34= new Pregunta("¿Cómo se llama el lugar destinado a las carreras de caballos?","Hipódromo",TipoPregunta.FACIL,ClasePregunta.DEPORTE);
	Pregunta pregunta35= new Pregunta("¿Quién tiene más balones de oro?","Lionel Messi",TipoPregunta.FACIL,ClasePregunta.DEPORTE);
	Pregunta pregunta36= new Pregunta(" Estilo de atletismo en el que los corredores llevan un testigo:","Relevo",TipoPregunta.FACIL,ClasePregunta.DEPORTE);
	Pregunta pregunta37= new Pregunta("¿Cuántas Copas del Mundo de Fútbol ha ganado la selección de Italia?","Cuatro",TipoPregunta.FACIL,ClasePregunta.DEPORTE);
	Pregunta pregunta38= new Pregunta("¿Cuántos tiempos tiene un partido de baloncesto?","4",TipoPregunta.FACIL,ClasePregunta.DEPORTE);
	Pregunta pregunta39= new Pregunta("¿En qué equipo juega Cristiano Ronaldo?","Real Madrid",TipoPregunta.FACIL,ClasePregunta.DEPORTE);
	Pregunta pregunta40= new Pregunta("¿Cuál de estos partidos de la Liga Española se considera un clásico?","Barça vs Madrid",TipoPregunta.FACIL,ClasePregunta.DEPORTE);

	Pregunta pregunta41= new Pregunta("¿Qué duración tiene un partido de fútbol que llega a la tanda de penaltis?","120",TipoPregunta.MEDIA,ClasePregunta.DEPORTE);
	Pregunta pregunta42= new Pregunta("¿En cuántos mundiales participó la selección de Inglaterra?","14",TipoPregunta.MEDIA,ClasePregunta.DEPORTE);
	Pregunta pregunta43= new Pregunta("¿Con qué deporte relacionarías a Aitor Osa?","Ciclismo",TipoPregunta.MEDIA,ClasePregunta.DEPORTE);
	Pregunta pregunta44= new Pregunta("¿Quién ganó el mundial de 2010 en Sudáfrica?","España",TipoPregunta.MEDIA,ClasePregunta.DEPORTE);
	Pregunta pregunta45= new Pregunta("¿Cuál es el salto más alto en caballo?","1'20 m",TipoPregunta.MEDIA,ClasePregunta.DEPORTE);
	Pregunta pregunta46= new Pregunta("¿Cuántos jugadores componen usualmente un equipo de rugby?","15",TipoPregunta.MEDIA,ClasePregunta.DEPORTE);
	Pregunta pregunta47= new Pregunta("¿Cómo se llama la anotación de un tanto en el fútbol americano?","Touchdown",TipoPregunta.MEDIA,ClasePregunta.DEPORTE);
	Pregunta pregunta48= new Pregunta("¿Quién fue el máximo goleador de la UEFA Champions League en 2013?","Cristiano Ronaldo",TipoPregunta.MEDIA,ClasePregunta.DEPORTE);
	Pregunta pregunta49= new Pregunta("En voleibol, ¿hasta cuántos toques se le puede dar a la pelota antes de pasarla al campo rival?","Tres",TipoPregunta.MEDIA,ClasePregunta.DEPORTE);
	Pregunta pregunta50= new Pregunta("Evgenia Kanaeva es la 'reina' de...","Gimnasia rítmica",TipoPregunta.MEDIA,ClasePregunta.DEPORTE);

	Pregunta pregunta51= new Pregunta("¿Cómo se llamaba la pelota del Mundial de Fútbol 1978?","Adidas Tango",TipoPregunta.DIFICIL,ClasePregunta.DEPORTE);
	Pregunta pregunta52= new Pregunta("¿Cuál es el nombre de pila del tenista Federer?","Roger",TipoPregunta.DIFICIL,ClasePregunta.DEPORTE);
	Pregunta pregunta53= new Pregunta("¿Quién es el goleador(es) del mundial 2010?","Diego Forlán y Thomas Müller",TipoPregunta.DIFICIL,ClasePregunta.DEPORTE);
	Pregunta pregunta54= new Pregunta("¿Cómo se llama Iniesta?","Andrés",TipoPregunta.DIFICIL,ClasePregunta.DEPORTE);
	Pregunta pregunta55= new Pregunta("¿En qué país ganó Alemania su primer mundial de fútbol?","Suiza",TipoPregunta.DIFICIL,ClasePregunta.DEPORTE);
	Pregunta pregunta56= new Pregunta("¿Quién fue el primer jugador que recibió la distinción de 'Mejor Jugador del Siglo'?","Pelé",TipoPregunta.DIFICIL,ClasePregunta.DEPORTE);
	Pregunta pregunta57= new Pregunta("¿A qué se denomina hacer un rosco en Tenis?","6-0",TipoPregunta.DIFICIL,ClasePregunta.DEPORTE);
	Pregunta pregunta58= new Pregunta("¿Quién fue el primer equipo en llevar dorsales en la liga Española?","Real Madrid",TipoPregunta.DIFICIL,ClasePregunta.DEPORTE);
	Pregunta pregunta59= new Pregunta("¿En qué deporte olímpico conlleva la expulsión salpicar deliberadamente la cara de un oponente o hundirlo en el agua cuando no tiene la pelota?","Waterpolo",TipoPregunta.DIFICIL,ClasePregunta.DEPORTE);
	Pregunta pregunta60= new Pregunta("¿Cuál de estas posiciones no representa a un jugador de Baseball?","Fullback",TipoPregunta.DIFICIL,ClasePregunta.DEPORTE);

	Pregunta pregunta61= new Pregunta("","",TipoPregunta.FACIL,ClasePregunta.ENTRETENIMIENTO);
	Pregunta pregunta62= new Pregunta("","",TipoPregunta.FACIL,ClasePregunta.ENTRETENIMIENTO);
	Pregunta pregunta63= new Pregunta("","",TipoPregunta.FACIL,ClasePregunta.ENTRETENIMIENTO);
	Pregunta pregunta64= new Pregunta("","",TipoPregunta.FACIL,ClasePregunta.ENTRETENIMIENTO);
	Pregunta pregunta65= new Pregunta("","",TipoPregunta.FACIL,ClasePregunta.ENTRETENIMIENTO);
	Pregunta pregunta66= new Pregunta("","",TipoPregunta.FACIL,ClasePregunta.ENTRETENIMIENTO);
	Pregunta pregunta67= new Pregunta("","",TipoPregunta.FACIL,ClasePregunta.ENTRETENIMIENTO);
	Pregunta pregunta68= new Pregunta("","",TipoPregunta.FACIL,ClasePregunta.ENTRETENIMIENTO);
	Pregunta pregunta69= new Pregunta("","",TipoPregunta.FACIL,ClasePregunta.ENTRETENIMIENTO);
	Pregunta pregunta70= new Pregunta("","",TipoPregunta.FACIL,ClasePregunta.ENTRETENIMIENTO);

	Pregunta pregunta71= new Pregunta("","",TipoPregunta.MEDIA,ClasePregunta.ENTRETENIMIENTO);
	Pregunta pregunta72= new Pregunta("","",TipoPregunta.MEDIA,ClasePregunta.ENTRETENIMIENTO);
	Pregunta pregunta73= new Pregunta("","",TipoPregunta.MEDIA,ClasePregunta.ENTRETENIMIENTO);
	Pregunta pregunta74= new Pregunta("","",TipoPregunta.MEDIA,ClasePregunta.ENTRETENIMIENTO);
	Pregunta pregunta75= new Pregunta("","",TipoPregunta.MEDIA,ClasePregunta.ENTRETENIMIENTO);
	Pregunta pregunta76= new Pregunta("","",TipoPregunta.MEDIA,ClasePregunta.ENTRETENIMIENTO);
	Pregunta pregunta77= new Pregunta("","",TipoPregunta.MEDIA,ClasePregunta.ENTRETENIMIENTO);
	Pregunta pregunta78= new Pregunta("","",TipoPregunta.MEDIA,ClasePregunta.ENTRETENIMIENTO);
	Pregunta pregunta79= new Pregunta("","",TipoPregunta.MEDIA,ClasePregunta.ENTRETENIMIENTO);
	Pregunta pregunta80= new Pregunta("","",TipoPregunta.MEDIA,ClasePregunta.ENTRETENIMIENTO);

	Pregunta pregunta81= new Pregunta("","",TipoPregunta.DIFICIL,ClasePregunta.ENTRETENIMIENTO);
	Pregunta pregunta82= new Pregunta("","",TipoPregunta.DIFICIL,ClasePregunta.ENTRETENIMIENTO);
	Pregunta pregunta83= new Pregunta("","",TipoPregunta.DIFICIL,ClasePregunta.ENTRETENIMIENTO);
	Pregunta pregunta84= new Pregunta("","",TipoPregunta.DIFICIL,ClasePregunta.ENTRETENIMIENTO);
	Pregunta pregunta85= new Pregunta("","",TipoPregunta.DIFICIL,ClasePregunta.ENTRETENIMIENTO);
	Pregunta pregunta86= new Pregunta("","",TipoPregunta.DIFICIL,ClasePregunta.ENTRETENIMIENTO);
	Pregunta pregunta87= new Pregunta("","",TipoPregunta.DIFICIL,ClasePregunta.ENTRETENIMIENTO);
	Pregunta pregunta88= new Pregunta("","",TipoPregunta.DIFICIL,ClasePregunta.ENTRETENIMIENTO);
	Pregunta pregunta89= new Pregunta("","",TipoPregunta.DIFICIL,ClasePregunta.ENTRETENIMIENTO);
	Pregunta pregunta90= new Pregunta("","",TipoPregunta.DIFICIL,ClasePregunta.ENTRETENIMIENTO);

	Pregunta pregunta91= new Pregunta("","",TipoPregunta.FACIL,ClasePregunta.GEOGRAFIA);
	Pregunta pregunta92= new Pregunta("","",TipoPregunta.FACIL,ClasePregunta.GEOGRAFIA);
	Pregunta pregunta93= new Pregunta("","",TipoPregunta.FACIL,ClasePregunta.GEOGRAFIA);
	Pregunta pregunta94= new Pregunta("","",TipoPregunta.FACIL,ClasePregunta.GEOGRAFIA);
	Pregunta pregunta95= new Pregunta("","",TipoPregunta.FACIL,ClasePregunta.GEOGRAFIA);
	Pregunta pregunta96= new Pregunta("","",TipoPregunta.FACIL,ClasePregunta.GEOGRAFIA);
	Pregunta pregunta97= new Pregunta("","",TipoPregunta.FACIL,ClasePregunta.GEOGRAFIA);
	Pregunta pregunta98= new Pregunta("","",TipoPregunta.FACIL,ClasePregunta.GEOGRAFIA);
	Pregunta pregunta99= new Pregunta("","",TipoPregunta.FACIL,ClasePregunta.GEOGRAFIA);
	Pregunta pregunta100= new Pregunta("","",TipoPregunta.FACIL,ClasePregunta.GEOGRAFIA);

	Pregunta pregunta101= new Pregunta("","",TipoPregunta.MEDIA,ClasePregunta.GEOGRAFIA);
	Pregunta pregunta102= new Pregunta("","",TipoPregunta.MEDIA,ClasePregunta.GEOGRAFIA);
	Pregunta pregunta103= new Pregunta("","",TipoPregunta.MEDIA,ClasePregunta.GEOGRAFIA);
	Pregunta pregunta104= new Pregunta("","",TipoPregunta.MEDIA,ClasePregunta.GEOGRAFIA);
	Pregunta pregunta105= new Pregunta("","",TipoPregunta.MEDIA,ClasePregunta.GEOGRAFIA);
	Pregunta pregunta106= new Pregunta("","",TipoPregunta.MEDIA,ClasePregunta.GEOGRAFIA);
	Pregunta pregunta107= new Pregunta("","",TipoPregunta.MEDIA,ClasePregunta.GEOGRAFIA);
	Pregunta pregunta108= new Pregunta("","",TipoPregunta.MEDIA,ClasePregunta.GEOGRAFIA);
	Pregunta pregunta109= new Pregunta("","",TipoPregunta.MEDIA,ClasePregunta.GEOGRAFIA);
	Pregunta pregunta110= new Pregunta("","",TipoPregunta.MEDIA,ClasePregunta.GEOGRAFIA);
	
	Pregunta pregunta111= new Pregunta("","",TipoPregunta.DIFICIL,ClasePregunta.GEOGRAFIA);
	Pregunta pregunta112= new Pregunta("","",TipoPregunta.DIFICIL,ClasePregunta.GEOGRAFIA);
	Pregunta pregunta113= new Pregunta("","",TipoPregunta.DIFICIL,ClasePregunta.GEOGRAFIA);
	Pregunta pregunta114= new Pregunta("","",TipoPregunta.DIFICIL,ClasePregunta.GEOGRAFIA);
	Pregunta pregunta115= new Pregunta("","",TipoPregunta.DIFICIL,ClasePregunta.GEOGRAFIA);
	Pregunta pregunta116= new Pregunta("","",TipoPregunta.DIFICIL,ClasePregunta.GEOGRAFIA);
	Pregunta pregunta117= new Pregunta("","",TipoPregunta.DIFICIL,ClasePregunta.GEOGRAFIA);
	Pregunta pregunta118= new Pregunta("","",TipoPregunta.DIFICIL,ClasePregunta.GEOGRAFIA);
	Pregunta pregunta119= new Pregunta("","",TipoPregunta.DIFICIL,ClasePregunta.GEOGRAFIA);
	Pregunta pregunta120= new Pregunta("","",TipoPregunta.DIFICIL,ClasePregunta.GEOGRAFIA);
	
	Pregunta pregunta121= new Pregunta("","",TipoPregunta.FACIL,ClasePregunta.HISTORIA);
	Pregunta pregunta122= new Pregunta("","",TipoPregunta.FACIL,ClasePregunta.HISTORIA);
	Pregunta pregunta123= new Pregunta("","",TipoPregunta.FACIL,ClasePregunta.HISTORIA);
	Pregunta pregunta124= new Pregunta("","",TipoPregunta.FACIL,ClasePregunta.HISTORIA);
	Pregunta pregunta125= new Pregunta("","",TipoPregunta.FACIL,ClasePregunta.HISTORIA);
	Pregunta pregunta126= new Pregunta("","",TipoPregunta.FACIL,ClasePregunta.HISTORIA);
	Pregunta pregunta127= new Pregunta("","",TipoPregunta.FACIL,ClasePregunta.HISTORIA);
	Pregunta pregunta128= new Pregunta("","",TipoPregunta.FACIL,ClasePregunta.HISTORIA);
	Pregunta pregunta129= new Pregunta("","",TipoPregunta.FACIL,ClasePregunta.HISTORIA);
	Pregunta pregunta130= new Pregunta("","",TipoPregunta.FACIL,ClasePregunta.HISTORIA);

	Pregunta pregunta131= new Pregunta("","",TipoPregunta.MEDIA,ClasePregunta.HISTORIA);
	Pregunta pregunta132= new Pregunta("","",TipoPregunta.MEDIA,ClasePregunta.HISTORIA);
	Pregunta pregunta133= new Pregunta("","",TipoPregunta.MEDIA,ClasePregunta.HISTORIA);
	Pregunta pregunta134= new Pregunta("","",TipoPregunta.MEDIA,ClasePregunta.HISTORIA);
	Pregunta pregunta135= new Pregunta("","",TipoPregunta.MEDIA,ClasePregunta.HISTORIA);
	Pregunta pregunta136= new Pregunta("","",TipoPregunta.MEDIA,ClasePregunta.HISTORIA);
	Pregunta pregunta137= new Pregunta("","",TipoPregunta.MEDIA,ClasePregunta.HISTORIA);
	Pregunta pregunta138= new Pregunta("","",TipoPregunta.MEDIA,ClasePregunta.HISTORIA);
	Pregunta pregunta139= new Pregunta("","",TipoPregunta.MEDIA,ClasePregunta.HISTORIA);
	Pregunta pregunta140= new Pregunta("","",TipoPregunta.MEDIA,ClasePregunta.HISTORIA);

	Pregunta pregunta141= new Pregunta("","",TipoPregunta.DIFICIL,ClasePregunta.HISTORIA);
	Pregunta pregunta142= new Pregunta("","",TipoPregunta.DIFICIL,ClasePregunta.HISTORIA);
	Pregunta pregunta143= new Pregunta("","",TipoPregunta.DIFICIL,ClasePregunta.HISTORIA);
	Pregunta pregunta144= new Pregunta("","",TipoPregunta.DIFICIL,ClasePregunta.HISTORIA);
	Pregunta pregunta145= new Pregunta("","",TipoPregunta.DIFICIL,ClasePregunta.HISTORIA);
	Pregunta pregunta146= new Pregunta("","",TipoPregunta.DIFICIL,ClasePregunta.HISTORIA);
	Pregunta pregunta147= new Pregunta("","",TipoPregunta.DIFICIL,ClasePregunta.HISTORIA);
	Pregunta pregunta148= new Pregunta("","",TipoPregunta.DIFICIL,ClasePregunta.HISTORIA);
	Pregunta pregunta149= new Pregunta("","",TipoPregunta.DIFICIL,ClasePregunta.HISTORIA);
	Pregunta pregunta150= new Pregunta("","",TipoPregunta.DIFICIL,ClasePregunta.HISTORIA);

	Pregunta pregunta151= new Pregunta("","",TipoPregunta.FACIL,ClasePregunta.MATEMATICA);
	Pregunta pregunta152= new Pregunta("","",TipoPregunta.FACIL,ClasePregunta.MATEMATICA);
	Pregunta pregunta153= new Pregunta("","",TipoPregunta.FACIL,ClasePregunta.MATEMATICA);
	Pregunta pregunta154= new Pregunta("","",TipoPregunta.FACIL,ClasePregunta.MATEMATICA);
	Pregunta pregunta155= new Pregunta("","",TipoPregunta.FACIL,ClasePregunta.MATEMATICA);
	Pregunta pregunta156= new Pregunta("","",TipoPregunta.FACIL,ClasePregunta.MATEMATICA);
	Pregunta pregunta157= new Pregunta("","",TipoPregunta.FACIL,ClasePregunta.MATEMATICA);
	Pregunta pregunta158= new Pregunta("","",TipoPregunta.FACIL,ClasePregunta.MATEMATICA);
	Pregunta pregunta159= new Pregunta("","",TipoPregunta.FACIL,ClasePregunta.MATEMATICA);
	Pregunta pregunta160= new Pregunta("","",TipoPregunta.FACIL,ClasePregunta.MATEMATICA);

	Pregunta pregunta161= new Pregunta("","",TipoPregunta.MEDIA,ClasePregunta.MATEMATICA);
	Pregunta pregunta162= new Pregunta("","",TipoPregunta.MEDIA,ClasePregunta.MATEMATICA);
	Pregunta pregunta163= new Pregunta("","",TipoPregunta.MEDIA,ClasePregunta.MATEMATICA);
	Pregunta pregunta164= new Pregunta("","",TipoPregunta.MEDIA,ClasePregunta.MATEMATICA);
	Pregunta pregunta165= new Pregunta("","",TipoPregunta.MEDIA,ClasePregunta.MATEMATICA);
	Pregunta pregunta166= new Pregunta("","",TipoPregunta.MEDIA,ClasePregunta.MATEMATICA);
	Pregunta pregunta167= new Pregunta("","",TipoPregunta.MEDIA,ClasePregunta.MATEMATICA);
	Pregunta pregunta168= new Pregunta("","",TipoPregunta.MEDIA,ClasePregunta.MATEMATICA);
	Pregunta pregunta169= new Pregunta("","",TipoPregunta.MEDIA,ClasePregunta.MATEMATICA);
	Pregunta pregunta170= new Pregunta("","",TipoPregunta.MEDIA,ClasePregunta.MATEMATICA);

	Pregunta pregunta171= new Pregunta("","",TipoPregunta.DIFICIL,ClasePregunta.MATEMATICA);
	Pregunta pregunta172= new Pregunta("","",TipoPregunta.DIFICIL,ClasePregunta.MATEMATICA);
	Pregunta pregunta173= new Pregunta("","",TipoPregunta.DIFICIL,ClasePregunta.MATEMATICA);
	Pregunta pregunta174= new Pregunta("","",TipoPregunta.DIFICIL,ClasePregunta.MATEMATICA);
	Pregunta pregunta175= new Pregunta("","",TipoPregunta.DIFICIL,ClasePregunta.MATEMATICA);
	Pregunta pregunta176= new Pregunta("","",TipoPregunta.DIFICIL,ClasePregunta.MATEMATICA);
	Pregunta pregunta177= new Pregunta("","",TipoPregunta.DIFICIL,ClasePregunta.MATEMATICA);
	Pregunta pregunta178= new Pregunta("","",TipoPregunta.DIFICIL,ClasePregunta.MATEMATICA);
	Pregunta pregunta179= new Pregunta("","",TipoPregunta.DIFICIL,ClasePregunta.MATEMATICA);
	Pregunta pregunta180= new Pregunta("","",TipoPregunta.DIFICIL,ClasePregunta.MATEMATICA);


	//se llena el Hashtable
		listaPreguntas.put(1, pregunta1);
		listaPreguntas.put(2, pregunta2);
		listaPreguntas.put(3, pregunta3);
		listaPreguntas.put(4, pregunta4);
		listaPreguntas.put(5, pregunta5);
		listaPreguntas.put(6, pregunta6);
		listaPreguntas.put(7, pregunta7);
		listaPreguntas.put(8, pregunta8);
		listaPreguntas.put(9, pregunta9);
		listaPreguntas.put(10, pregunta10);
		listaPreguntas.put(11, pregunta11);
		listaPreguntas.put(12, pregunta12);
		listaPreguntas.put(13, pregunta13);
		listaPreguntas.put(14, pregunta14);
		listaPreguntas.put(15, pregunta15);
		listaPreguntas.put(16, pregunta16);
		listaPreguntas.put(17, pregunta17);
		listaPreguntas.put(18, pregunta18);
		listaPreguntas.put(19, pregunta19);
		listaPreguntas.put(20, pregunta20);
		listaPreguntas.put(21, pregunta21);
		listaPreguntas.put(22, pregunta22);
		listaPreguntas.put(23, pregunta23);
		listaPreguntas.put(24, pregunta24);
		listaPreguntas.put(25, pregunta25);
		listaPreguntas.put(26, pregunta26);
		listaPreguntas.put(27, pregunta27);
		listaPreguntas.put(28, pregunta28);
		listaPreguntas.put(29, pregunta29);
		listaPreguntas.put(30, pregunta30);
		listaPreguntas.put(31, pregunta31);
		listaPreguntas.put(32, pregunta32);
		listaPreguntas.put(33, pregunta33);
		listaPreguntas.put(34, pregunta34);
		listaPreguntas.put(35, pregunta35);
		listaPreguntas.put(36, pregunta36);
		listaPreguntas.put(37, pregunta37);
		listaPreguntas.put(38, pregunta38);
		listaPreguntas.put(39, pregunta39);
		listaPreguntas.put(40, pregunta40);
		listaPreguntas.put(41, pregunta41);
		listaPreguntas.put(42, pregunta42);
		listaPreguntas.put(43, pregunta43);
		listaPreguntas.put(44, pregunta44);
		listaPreguntas.put(45, pregunta45);
		listaPreguntas.put(46, pregunta46);
		listaPreguntas.put(47, pregunta47);
		listaPreguntas.put(48, pregunta48);
		listaPreguntas.put(49, pregunta49);
		listaPreguntas.put(50, pregunta50);

	



}
	
	
	
}	//fin clase juego

