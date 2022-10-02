package co.edu.uniquindio.juego.controller;

import java.util.Hashtable;

import co.edu.uniquindio.juego.exceptions.JuegoException;
import co.edu.uniquindio.juego.model.ClasePregunta;
import co.edu.uniquindio.juego.model.Juego;
import co.edu.uniquindio.juego.model.Jugador;
import co.edu.uniquindio.juego.model.Pregunta;
import co.edu.uniquindio.juego.model.TipoPregunta;
import co.edu.uniquindio.juego.persistencia.Persistencia;

public class ModelFactoryController {



	Juego juego;
	Jugador jugadorLogueado;
	


	//------------------------------  Singleton ------------------------------------------------
	// Clase estatica oculta. Tan solo se instanciara el singleton una vez
	private static class SingletonHolder {
		// El constructor de Singleton puede ser llamado desde aqu� al ser protected
		private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
	}

	// M�todo para obtener la instancia de nuestra clase
	public static ModelFactoryController getInstance() {
		return SingletonHolder.eINSTANCE;
	}

	public ModelFactoryController() {

		//1. inicializar datos y luego guardarlo en archivos
//		iniciarSalvarDatosPrueba();

		//2. Cargar los datos de los archivos
		//cargarDatosDesdeArchivos();

		//3. Guardar y Cargar el recurso serializable binario

         //cargarResourceBinario();


		//4. Guardar y Cargar el recurso serializable XML
    // 	guardarResourceXML();
		
	    cargarResourceXML();


		//Siempre se debe verificar si la raiz del recurso es null
		if(juego == null)
		{
			System.out.println("Juego no guardado, creando juego nuevo");
			inicializarDatos();
//			guardarResourceSerializable();
	//		guardarResourceXML();


		}

		//Registrar la accion de incio de sesi�n
		//Persistencia.guardaRegistroLog("Inicio de sesi�n del usuario:pedro", 1, "inicioSesion");


	}



	/**private void iniciarSalvarDatosPrueba() {

		inicializarDatos();

		try {

			Persistencia.guardarEmpleados(getBanco().getListaEmpleados());
			Persistencia.guardarClientes(getBanco().getListaClientes());

			//Persistencia.cargarDatosArchivos(getBanco());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	**/

/**	private void cargarDatosDesdeArchivos() {

		marketplace = new Marketplace();

		try {

			Persistencia.cargarDatosArchivos(getMarketplace());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	**/


	/**
	 * M�todo que permite guardar un recurso binario
	 *
	 *




	 /**
	 * M�todo que permite cargar un recurso XML
	 */

	public void cargarResourceXML() {

		juego = Persistencia.cargarRecursoBancoXML();
	}

	/**
	 * M�todo que permite guardar un recurso XML
	 */
	public void guardarResourceXML() {

	    Persistencia.guardarRecursoBancoXML(juego);
	}


	/**
	 * M�todo que inicializa los datos del Marketplace
	 */

	private void inicializarDatos() {

		juego = new Juego();
        
		Pregunta pregunta1= new Pregunta("¿Para qué sirve la paleta?","para mezclar pinturas","comer helado","cavar un hoyo","cocinar",TipoPregunta.FACIL,ClasePregunta.ARTE);
		Pregunta pregunta2= new Pregunta("¿Qué tendencia musical es la que más incursiona en Jamaica?","reggae","cumbia","trap","dubstep",TipoPregunta.FACIL,ClasePregunta.ARTE);
		Pregunta pregunta3= new Pregunta("¿Qué usamos para diluir los colores de las acuarelas?","A}agua","aceite","aire","tierra",TipoPregunta.FACIL,ClasePregunta.ARTE);
		Pregunta pregunta4= new Pregunta("¿Cuántos dedos tiene por lo general una caricatura en las manos?","cuatro","seis","cinco","dos",TipoPregunta.FACIL,ClasePregunta.ARTE);
		Pregunta pregunta5= new Pregunta("¿Qué nota musical hay entre re y fa?","mi","sol","la","do",TipoPregunta.FACIL,ClasePregunta.ARTE);
		Pregunta pregunta6= new Pregunta("Más vale pájaro en mano...","que cien volando","que mal que por bien no venga!"," que lamentar."," bajo el sol.",TipoPregunta.FACIL,ClasePregunta.ARTE);
		Pregunta pregunta7= new Pregunta("¿A qué se dedicaban los siete enanitos?","eran mineros","borrachos","strepers","sicarios",TipoPregunta.FACIL,ClasePregunta.ARTE);
		Pregunta pregunta8= new Pregunta("Perro que ladra...","No muerde","que cien volando."," cruza venados en el mar.","esconde la mano",TipoPregunta.FACIL,ClasePregunta.ARTE);
		Pregunta pregunta9= new Pregunta("¿A qué familia de instrumentos pertenece la guitarra, el violín y el bajo?","cuerdas","viento","percusion","electrico",TipoPregunta.FACIL,ClasePregunta.ARTE);
		Pregunta pregunta10= new Pregunta("¿En qué novela el protagonista es un asesino en serie con un sentido del olfato increíblemente desarrollado?","el Perfume","csi","dora la exploradora","doki",TipoPregunta.FACIL,ClasePregunta.ARTE);
	
		Pregunta pregunta11= new Pregunta("Gabriel García Márquez se caracteriza por narrar en un mundo:","real maravilloso","macabro","historietas","manga",TipoPregunta.MEDIA,ClasePregunta.ARTE);
		Pregunta pregunta12= new Pregunta("¿Quién era la diosa de la sabiduría en la mitología griega?","atena","rea","hera","gea",TipoPregunta.MEDIA,ClasePregunta.ARTE);
		Pregunta pregunta13= new Pregunta("¿Cuál es el nombre de Picasso?","pablo","andres","didier","mary",TipoPregunta.MEDIA,ClasePregunta.ARTE);
		Pregunta pregunta14= new Pregunta("¿Tira la piedra...?","y esconde la mano","y corre","y esconde la piedra","y le abre la cabeza",TipoPregunta.MEDIA,ClasePregunta.ARTE);
		Pregunta pregunta15= new Pregunta("¿A qué ciudad vasca dedicó un cuadro Pablo Picasso?","Guernica","Bogota","Paris","Armenia",TipoPregunta.MEDIA,ClasePregunta.ARTE);
		Pregunta pregunta16= new Pregunta("¿Quién escribió la novela 'Contagio'?","Robin Cook","Gabriel Garcia","Darly","Cristian Gonzalez",TipoPregunta.MEDIA,ClasePregunta.ARTE);
		Pregunta pregunta17= new Pregunta("¿Qué pieza de arte fue robada y guardada debajo de una cama hasta que se devolvió al Museo Louvre?","Mona Lisa","El Beso","Guernica","La Gioconda",TipoPregunta.MEDIA,ClasePregunta.ARTE);
		Pregunta pregunta18= new Pregunta("¿Qué instrumento tocaba Zeta Bosio en Soda Stereo?","bajo","Guitarra","flauta","bateria",TipoPregunta.MEDIA,ClasePregunta.ARTE);
		Pregunta pregunta19= new Pregunta("¿Qué parte del cuerpo se cortó Vicent Van Gogh?","oreja","el nepe","nariz","lengua",TipoPregunta.MEDIA,ClasePregunta.ARTE);
		Pregunta pregunta20= new Pregunta("De qué país es la caricatura 'Condorito'?","chile","venezuela","mexico","argentina",TipoPregunta.MEDIA,ClasePregunta.ARTE);
	
		Pregunta pregunta21= new Pregunta("¿Cuál es la famosa cueva en la que se narra el Quijote?","Montesinos","calasqui","salima","petra",TipoPregunta.DIFICIL,ClasePregunta.ARTE);
		Pregunta pregunta22= new Pregunta("¿Cuántos anillos fueron creados por Sauron para los Señores Enanos en el Señor de los Anillos?","7","1","5","3",TipoPregunta.DIFICIL,ClasePregunta.ARTE);
		Pregunta pregunta23= new Pregunta("¿Cuál de las siguientes palabras es esdrújula?","metálico","impídanselo","alguacil","corren",TipoPregunta.DIFICIL,ClasePregunta.ARTE);
		Pregunta pregunta24= new Pregunta("¿Cuál es la obra cumbre en la literatura española escrita por Fernando de Rojas?","la Celestina","la zelestina","burgos","madrid",TipoPregunta.DIFICIL,ClasePregunta.ARTE);
		Pregunta pregunta25= new Pregunta("¿Cuál de las siguientes obras no pertenece a Edgar Allan Poe?","El monte de las ánimas","It","El resplandor","Doctor Sleep",TipoPregunta.DIFICIL,ClasePregunta.ARTE);
		Pregunta pregunta26= new Pregunta("¿Qué obra NO pertenece a Shakespeare?","La Divina Comedia","","","",TipoPregunta.DIFICIL,ClasePregunta.ARTE);
		Pregunta pregunta27= new Pregunta("¿Qué color consigues mezclando todos los colores del CMYK?","Negro","cafe","azul","violeta",TipoPregunta.DIFICIL,ClasePregunta.ARTE);
		Pregunta pregunta28= new Pregunta("¿Quién pintó el cuadro La Persistencia de la Memoria?","Dalí","Picasso","Van gogh","",TipoPregunta.DIFICIL,ClasePregunta.ARTE);
		Pregunta pregunta29= new Pregunta("¿Cuántos 'gritos' pintó Munch?","cuatro","uno","cinco","tres",TipoPregunta.DIFICIL,ClasePregunta.ARTE);
		Pregunta pregunta30= new Pregunta("¿De qué murió Jean Valjean en la novela 'Los Miserables'?","de viejo","disparo","suicidio","pena moral",TipoPregunta.DIFICIL,ClasePregunta.ARTE);
	
		Pregunta pregunta31= new Pregunta("¿deporte donde solo se toca el balón con las manos y se nete en una canasta?","Baloncesto","Fútbol","hockey","golf",TipoPregunta.FACIL,ClasePregunta.DEPORTE);
		Pregunta pregunta32= new Pregunta("¿A qué deporte pertenece la WWE?","Lucha libre","cortar madera","belleza","tecnologia",TipoPregunta.FACIL,ClasePregunta.DEPORTE);
		Pregunta pregunta33= new Pregunta("¿Qué deporte estamos viendo si el árbitro señala 'falta de rotación'?","voleibol","fútbol","hockey","baloncesto",TipoPregunta.FACIL,ClasePregunta.DEPORTE);
		Pregunta pregunta34= new Pregunta("¿Cómo se llama el lugar destinado a las carreras de caballos?","Hipódromo","Cuadrilatero","Exagono","Circuito cerrado",TipoPregunta.FACIL,ClasePregunta.DEPORTE);
		Pregunta pregunta35= new Pregunta("¿Quién tiene más balones de oro?","Lionel Messi","Cristiano Ronaldo","Roonie","Chicharito",TipoPregunta.FACIL,ClasePregunta.DEPORTE);
		Pregunta pregunta36= new Pregunta("Estilo de atletismo en el que los corredores llevan un testigo:","relevo","maratón","waterpolo","ciclismo",TipoPregunta.FACIL,ClasePregunta.DEPORTE);
		Pregunta pregunta37= new Pregunta("¿Cuántas Copas del Mundo de Fútbol ha ganado la selección de Italia?","Cuatro","Cinco","Tres","Dos",TipoPregunta.FACIL,ClasePregunta.DEPORTE);
		Pregunta pregunta38= new Pregunta("¿Cuántos tiempos tiene un partido de baloncesto?","4","3","1","10",TipoPregunta.FACIL,ClasePregunta.DEPORTE);
		Pregunta pregunta39= new Pregunta("¿En qué equipo juega Cristiano Ronaldo?","Real Madrid","Argentina","Millonarios","Nacional",TipoPregunta.FACIL,ClasePregunta.DEPORTE);
		Pregunta pregunta40= new Pregunta("¿Cuál de estos partidos de la Liga Española se considera un clásico?","Barsa vs Madrid","Millonarios Vs Nacional","Milan Vs Inter","Manchester United Vs Manchester City",TipoPregunta.FACIL,ClasePregunta.DEPORTE);
	
		Pregunta pregunta41= new Pregunta("¿Qué duración tiene un partido de fútbol que llega a la tanda de penaltis?","120","110","90","130",TipoPregunta.MEDIA,ClasePregunta.DEPORTE);
		Pregunta pregunta42= new Pregunta("¿En cuántos mundiales participó la selección de Inglaterra?","14","8","16","20",TipoPregunta.MEDIA,ClasePregunta.DEPORTE);
		Pregunta pregunta43= new Pregunta("¿Con qué deporte relacionarías a Aitor Osa?","Ciclismo","futbol","Baloncesto","Hockey",TipoPregunta.MEDIA,ClasePregunta.DEPORTE);
		Pregunta pregunta44= new Pregunta("¿Quién ganó el mundial de 2010 en Sudáfrica?","España","Colombia","Argentina","Brazil",TipoPregunta.MEDIA,ClasePregunta.DEPORTE);
		Pregunta pregunta45= new Pregunta("¿Cuál es el salto más alto en caballo?","1'20 m","2'00 m","0'50 m","2'20 m",TipoPregunta.MEDIA,ClasePregunta.DEPORTE);
		Pregunta pregunta46= new Pregunta("¿Cuántos jugadores componen usualmente un equipo de rugby?","15","11","8","3",TipoPregunta.MEDIA,ClasePregunta.DEPORTE);
		Pregunta pregunta47= new Pregunta("¿Cómo se llama la anotación de un tanto en el fútbol americano?","Touchdown","gol","anotacion","",TipoPregunta.MEDIA,ClasePregunta.DEPORTE);
		Pregunta pregunta48= new Pregunta("¿Quién fue el máximo goleador de la UEFA Champions League en 2013?","Cristiano Ronaldo","Leonel Messi","Neymar Jr","kaka",TipoPregunta.MEDIA,ClasePregunta.DEPORTE);
		Pregunta pregunta49= new Pregunta("En voleibol, ¿hasta cuántos toques se le puede dar a la pelota antes de pasarla al campo rival?","Tres","Uno","Dos","Cinco",TipoPregunta.MEDIA,ClasePregunta.DEPORTE);
		Pregunta pregunta50= new Pregunta("Evgenia Kanaeva es la 'reina' de...","Gimnasia rítmica","Natacion","Voleibol","Tejo",TipoPregunta.MEDIA,ClasePregunta.DEPORTE);
	
		Pregunta pregunta51= new Pregunta("¿Cómo se llamaba la pelota del Mundial de Fútbol 1978?","Adidas Tango","Brazuca Final","Telstar 18","Al Rihla",TipoPregunta.DIFICIL,ClasePregunta.DEPORTE);
		Pregunta pregunta52= new Pregunta("¿Cuál es el nombre de pila del tenista Federer?","Roger","Fernandez","Mario","Angel",TipoPregunta.DIFICIL,ClasePregunta.DEPORTE);
		Pregunta pregunta53= new Pregunta("¿cuales son los goleadores del mundial 2010?","Diego y Thomas","Messi y Cristiano","Falcao y James","Neymar y Mbappé",TipoPregunta.DIFICIL,ClasePregunta.DEPORTE);
		Pregunta pregunta54= new Pregunta("¿Cómo se llama Iniesta?","Andrés","Didier","Cristian","Juan",TipoPregunta.DIFICIL,ClasePregunta.DEPORTE);
		Pregunta pregunta55= new Pregunta("¿En qué país ganó Alemania su primer mundial de fútbol?","Suiza","Paises bajos","Brazil","Alemania",TipoPregunta.DIFICIL,ClasePregunta.DEPORTE);
		Pregunta pregunta56= new Pregunta("¿Quién fue el primer jugador que recibió la distinción de 'Mejor Jugador del Siglo'?","Pelé","René Higuita","Kaka","Ronaldinho",TipoPregunta.DIFICIL,ClasePregunta.DEPORTE);
		Pregunta pregunta57= new Pregunta("¿A qué se denomina hacer un rosco en Tenis?","6-0","Un pan","Salir de la cancha","Fuera de lugar",TipoPregunta.DIFICIL,ClasePregunta.DEPORTE);
		Pregunta pregunta58= new Pregunta("¿Quién fue el primer equipo en llevar dorsales en la liga Española?","Real Madrid","Barcelona","Atletico de madrid","Real sociedad",TipoPregunta.DIFICIL,ClasePregunta.DEPORTE);
		Pregunta pregunta59= new Pregunta("¿En qué deporte olímpico conlleva la expulsión salpicar deliberadamente la cara de un oponente o hundirlo en el agua cuando no tiene la pelota?","Waterpolo","Natación","Kitesurf","Windsurf",TipoPregunta.DIFICIL,ClasePregunta.DEPORTE);
		Pregunta pregunta60= new Pregunta("¿Cuál de estas posiciones no representa a un jugador de Baseball?","Fullback","Base","Escolta","Alero",TipoPregunta.DIFICIL,ClasePregunta.DEPORTE);
	
		Pregunta pregunta61= new Pregunta("¿Qué fruta es la casa de Bob Esponja?","Una piña","Manzana","Banana","Coco",TipoPregunta.FACIL,ClasePregunta.ENTRETENIMIENTO);
		Pregunta pregunta62= new Pregunta("¿Quién es el marido de la actriz Angelina Jolie?","Brad Pitt","Cristiano Ronaldo","Cris evans","Cris MJ",TipoPregunta.FACIL,ClasePregunta.ENTRETENIMIENTO);
		Pregunta pregunta63= new Pregunta("¿En la serie Los Simpson de qué color son las perlas de Lisa?","Blancas","Rojas","Azules","Verdes",TipoPregunta.FACIL,ClasePregunta.ENTRETENIMIENTO);
		Pregunta pregunta64= new Pregunta("¿Cómo se llama el gremlin bueno de la película Gremlins?","Gizmo","Gremli","Bicho bueno","Peludin",TipoPregunta.FACIL,ClasePregunta.ENTRETENIMIENTO);
		Pregunta pregunta65= new Pregunta("¿Cuál fue la primera película de Disney?","Blancanieves","Sirenita","Pocajontas","Hercules",TipoPregunta.FACIL,ClasePregunta.ENTRETENIMIENTO);
		Pregunta pregunta66= new Pregunta("¿Qué famoso personaje animado sacaba inventos del futuro de su bolsillo mágico?","Doraemon","Naruto","Naguisa","Lufi",TipoPregunta.FACIL,ClasePregunta.ENTRETENIMIENTO);
		Pregunta pregunta67= new Pregunta("¿Quién se convirtió en el mejor amigo de Woody en la película Toy Story?","Buzz Lightyear","Cerdo","Dinosaurio verde","Carro a control remoto",TipoPregunta.FACIL,ClasePregunta.ENTRETENIMIENTO);
		Pregunta pregunta68= new Pregunta("¿Cuál de estos villanos NO es enemigo de Batman?","Magento","Pinguiono","Guazon","acertijo",TipoPregunta.FACIL,ClasePregunta.ENTRETENIMIENTO);
		Pregunta pregunta69= new Pregunta("¿En qué programa sale Sheldon Cooper?","The Big Bang Theory","betty la fea","pasion de gabilanes","the office",TipoPregunta.FACIL,ClasePregunta.ENTRETENIMIENTO);
		Pregunta pregunta70= new Pregunta("¿Quién es el primer super saiyajin que se convierte en dios?","Goku","Vegeta","Bardock","Gohan",TipoPregunta.FACIL,ClasePregunta.ENTRETENIMIENTO);
	
		Pregunta pregunta71= new Pregunta("¿A qué se le llama 'manga'?","cómic japonés","libreta","hentai","Caricaturas",TipoPregunta.MEDIA,ClasePregunta.ENTRETENIMIENTO);
		Pregunta pregunta72= new Pregunta("¿Cómo se llama el hermano menor de Mario Bros?","Luigi","Yoshi","Toad","Browser",TipoPregunta.MEDIA,ClasePregunta.ENTRETENIMIENTO);
		Pregunta pregunta73= new Pregunta("¿En qué año murió Marilyn Monroe?","1962","1972","1982","1952",TipoPregunta.MEDIA,ClasePregunta.ENTRETENIMIENTO);
		Pregunta pregunta74= new Pregunta("¿De qué nacionalidad es la cantante Belinda?","Mexicana","Cubana","Colombiana","Chilena",TipoPregunta.MEDIA,ClasePregunta.ENTRETENIMIENTO);
		Pregunta pregunta75= new Pregunta("¿De qué juego son las siglas WOW?","World of Warcraft","World of Wonder","World of Wisdom","World of Wracaft",TipoPregunta.MEDIA,ClasePregunta.ENTRETENIMIENTO);
		Pregunta pregunta76= new Pregunta("¿Con qué canción saltó a la fama del grupo Hombres G?","Sufre mamón","Venezia","Devuelveme a mi chica","Marta tiene un marcapasos",TipoPregunta.MEDIA,ClasePregunta.ENTRETENIMIENTO);
		Pregunta pregunta77= new Pregunta("¿Qué icono tiene la aplicación Instagram?","Una cámara de fotos","Un lente fotografico","Una ventana ","un recuadro minimalista",TipoPregunta.MEDIA,ClasePregunta.ENTRETENIMIENTO);
		Pregunta pregunta78= new Pregunta("¿Cómo se llama el amigo inseparable de Dora la Exploradora?","Botas ","El mapa","hentai","Caricaturas",TipoPregunta.MEDIA,ClasePregunta.ENTRETENIMIENTO);
		Pregunta pregunta79= new Pregunta("¿En qué año nació Michael Jackson?","1958","1978","1968","1948",TipoPregunta.MEDIA,ClasePregunta.ENTRETENIMIENTO);
		Pregunta pregunta80= new Pregunta("¿Cuál es el nombre del actor que interpreta a Harry Potter?","Daniel Radcliffe","Robbie Coltrane","Richard Harris","Richard Harrison",TipoPregunta.MEDIA,ClasePregunta.ENTRETENIMIENTO);
	
		Pregunta pregunta81= new Pregunta("¿Cuáles son los nombres de Los Tres Chiflados?","Moe, Larry y Curly","Moe, Larry y Carly","Mae, Larry y Carly","Moe, Peezer y Curly",TipoPregunta.DIFICIL,ClasePregunta.ENTRETENIMIENTO);
		Pregunta pregunta82= new Pregunta("¿Cómo se llamaba el primer gato de Los Simpsons?","Bola de nieve","Nieve ","Snowballal","Bolita de nieve",TipoPregunta.DIFICIL,ClasePregunta.ENTRETENIMIENTO);
		Pregunta pregunta83= new Pregunta("¿Qué cantante estuvo saliendo con Selena Gómez?","Justin Bieber","Drake ","Zadd","Charli Puth",TipoPregunta.DIFICIL,ClasePregunta.ENTRETENIMIENTO);
		Pregunta pregunta84= new Pregunta("¿De quién es la canción 'Master of Puppets'?","Metallica","Megadeth","Slayer","Anthrax",TipoPregunta.DIFICIL,ClasePregunta.ENTRETENIMIENTO);
		Pregunta pregunta85= new Pregunta("¿Cómo se llama el personaje malvado de Aladdin?","Jafar","Razoul ","Rajah ","Lago",TipoPregunta.DIFICIL,ClasePregunta.ENTRETENIMIENTO);
		Pregunta pregunta86= new Pregunta("¿De qué color era Clifford, el perro gigante?","Rojo","Marron ","Gris ","Amarillo",TipoPregunta.DIFICIL,ClasePregunta.ENTRETENIMIENTO);
		Pregunta pregunta87= new Pregunta("¿Qué es Assasin's Creed?","Un videojuego","Una Serie de Netflixt ","Una Serie de HBO","Una pelicula",TipoPregunta.DIFICIL,ClasePregunta.ENTRETENIMIENTO);
		Pregunta pregunta88= new Pregunta("¿En qué año se fundó The Walt Disney Company?","1923","1927","1924","1933",TipoPregunta.DIFICIL,ClasePregunta.ENTRETENIMIENTO);
		Pregunta pregunta89= new Pregunta("¿Qué actor protagonizó la película Grease?","John Travolta","Barry Pearl","Jeff Conaway","Jamie Donnelly",TipoPregunta.DIFICIL,ClasePregunta.ENTRETENIMIENTO);
		Pregunta pregunta90= new Pregunta("¿Quién es Mario Casas?","Un actor","Presentador de Tv","Fisico Mexicano","Atleta",TipoPregunta.DIFICIL,ClasePregunta.ENTRETENIMIENTO);
	
		Pregunta pregunta91= new Pregunta("¿Cuál es la capital de Uruguay?","Montevideo","Asuncion ","Santiago ","Lima",TipoPregunta.FACIL,ClasePregunta.GEOGRAFIA);
		Pregunta pregunta92= new Pregunta("¿Dónde se encuentra el río Nilo?","En África","En Irak","En America ","Sur de europa",TipoPregunta.FACIL,ClasePregunta.GEOGRAFIA);
		Pregunta pregunta93= new Pregunta("¿Cuál es el idioma tradicional en Bulgaria?","Búlgaro","Ingles ","Eslavo ","Aleman",TipoPregunta.FACIL,ClasePregunta.GEOGRAFIA);
		Pregunta pregunta94= new Pregunta("¿Con cuál de los siguientes países NO limita Colombia?","Guayana","Panama","Brasil","Peru",TipoPregunta.FACIL,ClasePregunta.GEOGRAFIA);
		Pregunta pregunta95= new Pregunta("¿Dónde está la torre Eiffel?","En París","En Roma","En Madrid ","En Barcelona",TipoPregunta.FACIL,ClasePregunta.GEOGRAFIA);
		Pregunta pregunta96= new Pregunta("¿A qué continente pertenece Islandia?","Europa","Asia","Africa","Oceania",TipoPregunta.FACIL,ClasePregunta.GEOGRAFIA);
		Pregunta pregunta97= new Pregunta("¿Dónde se encuentra Irak?","Asia","Norte de Africa","Sur de Europa"," Al SudoEste de Rusia",TipoPregunta.FACIL,ClasePregunta.GEOGRAFIA);
		Pregunta pregunta98= new Pregunta("¿Qué país tiene más territorio en la Amazonía?","Brasil","Peru y Colombia ","Bolivia","Colombia",TipoPregunta.FACIL,ClasePregunta.GEOGRAFIA);
		Pregunta pregunta99= new Pregunta("¿En qué continente apareció el Ébola?","En África","Oceania","Asia","Europa",TipoPregunta.FACIL,ClasePregunta.GEOGRAFIA);
		Pregunta pregunta100= new Pregunta("¿A qué continente pertenece Ecuador?","América","Norte America","Asia","Oceania",TipoPregunta.FACIL,ClasePregunta.GEOGRAFIA);

		Pregunta pregunta101= new Pregunta("¿Cuál es la moneda oficial de Costa Rica?","Colón costarricense","Peso costarricense","Dolar","Quetzal",TipoPregunta.MEDIA,ClasePregunta.GEOGRAFIA);
		Pregunta pregunta102= new Pregunta("¿Cuál de los siguientes países no es una isla?","Todos son islas","Nueva Guinea","Madagascar","Titipan",TipoPregunta.MEDIA,ClasePregunta.GEOGRAFIA);
		Pregunta pregunta103= new Pregunta("¿Cuál es el sexto país más grande el mundo?","Australia","Brasil","Argentina","India",TipoPregunta.MEDIA,ClasePregunta.GEOGRAFIA);
		Pregunta pregunta104= new Pregunta("¿Cuál de los siguientes países no es de Europa?","Nigeria" ,"Monaco","Luxemburgo","Liechtenstein",TipoPregunta.MEDIA,ClasePregunta.GEOGRAFIA);
		Pregunta pregunta105= new Pregunta("¿Cuáles son los colores de la bandera de Panamá?","Azul, blanco y oro","Azul marino, blanco y Amarillo ","Azul, Rojo y Blanco","Blanco, rojo y oro",TipoPregunta.MEDIA,ClasePregunta.GEOGRAFIA);
		Pregunta pregunta106= new Pregunta("¿Cuál fue la primera capital de Costa Rica?","Cartago","San Jose ","Herida","Puntarena",TipoPregunta.MEDIA,ClasePregunta.GEOGRAFIA);
		Pregunta pregunta107= new Pregunta("¿En qué provincia de Argentina se encuentra el obelisco?","Buenos Aires","Santiago de Chile","Mar de Plata ","Ciudad de Cordoba",TipoPregunta.MEDIA,ClasePregunta.GEOGRAFIA);
		Pregunta pregunta108= new Pregunta("¿Dónde queda Panamá?","América Central","Al suroeste de Mexico","Sur America","Al nororiente de Colombia ",TipoPregunta.MEDIA,ClasePregunta.GEOGRAFIA);
		Pregunta pregunta109= new Pregunta("¿Cuál es el país de origen de la galletita pretzel?","Alemania","Rusia","Bielorrusia","Francia",TipoPregunta.MEDIA,ClasePregunta.GEOGRAFIA);
		Pregunta pregunta110= new Pregunta("¿Cuál es la ciudad más poblada de Oceanía?","Sidney","AucKland","Suva","Port Vila",TipoPregunta.MEDIA,ClasePregunta.GEOGRAFIA);
	
		Pregunta pregunta111= new Pregunta("¿Cuál es el área urbana más poblada de la India?","Bombay","Nueva Delhi","Calcuta","Pekin",TipoPregunta.DIFICIL,ClasePregunta.GEOGRAFIA);
		Pregunta pregunta112= new Pregunta("¿En qué provincia se encuentra Elche?","Alicante","Valencia","Zaragoza","Bilbao",TipoPregunta.DIFICIL,ClasePregunta.GEOGRAFIA);
		Pregunta pregunta113= new Pregunta("¿Dónde se encuentra la isla de Koh Samui?","Tailandia","Irlanda","Indionesia","Filipinas",TipoPregunta.DIFICIL,ClasePregunta.GEOGRAFIA);
		Pregunta pregunta114= new Pregunta("¿Dónde se encuentra la villa portuaria más antigua de Francia?","Marseille","Moustiers-Sainte-Marie","Piana","Alpes de Alta Provenza",TipoPregunta.DIFICIL,ClasePregunta.GEOGRAFIA);
		Pregunta pregunta115= new Pregunta("¿De dónde es el queso D.O. Idiazábal?","Gipuzkoa","Astorga","Belmonte","Almagro",TipoPregunta.DIFICIL,ClasePregunta.GEOGRAFIA);
		Pregunta pregunta116= new Pregunta("¿En qué ciudad se encuentra el museo San Telmo?","Donostia","Villabona","Hondarribia","Zarautz",TipoPregunta.DIFICIL,ClasePregunta.GEOGRAFIA);
		Pregunta pregunta117= new Pregunta("¿Desde qué ciudad de España puedes ver el monte llamado Mujer Muerta Jebel Musa?","Ceuta","Tarifa","Marfil","Algeciras",TipoPregunta.DIFICIL,ClasePregunta.GEOGRAFIA);
		Pregunta pregunta118= new Pregunta("¿Cuál de los siguientes colores es el menos frecuente en las banderas de los países árabes?","Amarillo, marron, blanco","Blanco, verde y negro","blanco, rojo y negro","blanco, marron y rojo",TipoPregunta.DIFICIL,ClasePregunta.GEOGRAFIA);
		Pregunta pregunta119= new Pregunta("¿Cuál de estas ciudades no es de Argentina?","Cali","Cordoba","Santa Fe","Mar de plata",TipoPregunta.DIFICIL,ClasePregunta.GEOGRAFIA);
		Pregunta pregunta120= new Pregunta("¿A qué país pertenece Gibraltar?","Reino Unido","Letonia","Rumania","Armenia",TipoPregunta.DIFICIL,ClasePregunta.GEOGRAFIA);
		
		
		Pregunta pregunta121= new Pregunta("¿Qué civilización antigua tenía faraones como gobernantes?","Egipto","La Antigua Grecia","Los Fenicios","El Imperio Aqueménida",TipoPregunta.FACIL,ClasePregunta.HISTORIA);
		Pregunta pregunta122= new Pregunta("¿Cuál es la ideología opositora del Comunismo?","Capitalismo","Socialismo","Hinduismo","Fascismo",TipoPregunta.FACIL,ClasePregunta.HISTORIA);
		Pregunta pregunta123= new Pregunta("¿Quién fue el primer presidente de los Estados Unidos?","George Washington","Thomas Jefferson","John Adams","James Madison",TipoPregunta.FACIL,ClasePregunta.HISTORIA);
		Pregunta pregunta124= new Pregunta("¿Qué le fue devuelto a China el 1º de Julio de 1997?","Hong Kong","Muralla China","Pekin","Ciudad Prohibida",TipoPregunta.FACIL,ClasePregunta.HISTORIA);
		Pregunta pregunta125= new Pregunta("¿Qué país comenzó la Segunda Guerra Mundial?","Alemania","Estados Unidos","Rusia","Corea del sur",TipoPregunta.FACIL,ClasePregunta.HISTORIA);
		Pregunta pregunta126= new Pregunta("¿Cuál fue el nombre que los romanos le dieron a la Gran Bretaña?","Britannia","Norte de Irlandia","Imperio Britanico","Grain Britannia",TipoPregunta.FACIL,ClasePregunta.HISTORIA);
		Pregunta pregunta127= new Pregunta("¿Qué gran líder militar gobernó Francia luego de que sucediera la Revolución Francesa?","Napoleón","Maximilien Robespierre","Jacques Danton","Jean-Paul Marat",TipoPregunta.FACIL,ClasePregunta.HISTORIA);
		Pregunta pregunta128= new Pregunta("¿En qué año Francia se convirtió en República?","1792" ,"1762","1797","1793",TipoPregunta.FACIL,ClasePregunta.HISTORIA);
		Pregunta pregunta129= new Pregunta("¿Qué país le regaló la Estatua de la Libertad a Nueva York?","Francia","Brasil","Holanda","Inglaterra",TipoPregunta.FACIL,ClasePregunta.HISTORIA);
		Pregunta pregunta130= new Pregunta("¿Cuándo se viajo por primera vez al espacio?","1969","1968","1971","1972",TipoPregunta.FACIL,ClasePregunta.HISTORIA);
	
		Pregunta pregunta131= new Pregunta("¿Cuál es la comida típica madrileña?","El cocido","Callos","Roscas","Bocadillo de calamares",TipoPregunta.MEDIA,ClasePregunta.HISTORIA);
		Pregunta pregunta132= new Pregunta("¿Cómo pasó a llamarse el Imperio Austríaco tras la revolución de 1848?","Imperio Austrohúngaro","Imperio húngaro","Imperio Nordico","Imperio Austriaco",TipoPregunta.MEDIA,ClasePregunta.HISTORIA);
		Pregunta pregunta133= new Pregunta("¿Qué ciudad quedó partida en dos tras la Segunda Guerra Mundial?","Berlín","Volgogrado","Foggia","Turin",TipoPregunta.MEDIA,ClasePregunta.HISTORIA);
		Pregunta pregunta134= new Pregunta("¿Cuál fue el faraón que reinó durante 66 años en Egipto?","Ramsés II","Ramsés III","Cleopatra VII","Akenaton",TipoPregunta.MEDIA,ClasePregunta.HISTORIA);
		Pregunta pregunta135= new Pregunta("¿Quién fue el autor de la frase 'Puedo comprar a todos los hombres del mundo'?","Howard Hughes","Noah Dietrich","Robert Maheu","Franklin D. Roosevelt",TipoPregunta.MEDIA,ClasePregunta.HISTORIA);
		Pregunta pregunta136= new Pregunta("¿Cuántos meses duró la batalla de Stalingrado en la Segunda Guerra Mundial?","Seis meses","Siete meses","9 meses","3 meses",TipoPregunta.MEDIA,ClasePregunta.HISTORIA);
		Pregunta pregunta137= new Pregunta("Según el Libro Guiness de los récords, ¿cuánto tiempo duró la guerra más corta de la historia?","45 minutos","3 meses","24 horas","2 semanas",TipoPregunta.MEDIA,ClasePregunta.HISTORIA);
		Pregunta pregunta138= new Pregunta("¿Quién fue Luís XIV?","Rey de Francia","Dictador Frances","Rey de Roma","Virrey Español",TipoPregunta.MEDIA,ClasePregunta.HISTORIA);
		Pregunta pregunta139= new Pregunta("¿Quién dijo la famosa frase 'La suerte está echada'?","Julio César","Lucio Cornelio Cinna","Marco Minucio Termo","Aurelio Cota",TipoPregunta.MEDIA,ClasePregunta.HISTORIA);
		Pregunta pregunta140= new Pregunta("¿Quién fue uno de los promotores de la primera línea regular de ferrocarril de la Península Ibérica?","Miquel Biada Bunyol","George Stephenson","Anastasio Bustamante","William Jackson Palmer",TipoPregunta.MEDIA,ClasePregunta.HISTORIA);
	
		Pregunta pregunta141= new Pregunta("¿Qué país reconoció Italia a través de los Pactos de Letrán de 1929?","La Ciudad del Vaticano","Francia","Portugal","España",TipoPregunta.DIFICIL,ClasePregunta.HISTORIA);
		Pregunta pregunta142= new Pregunta("¿Quién dijo la frase 'miente, miente que algo quedará'?","Joseph Goebbels","Adolf Hitler","Gregor Strasser"," Max Wilhelm Kimmich",TipoPregunta.DIFICIL,ClasePregunta.HISTORIA);
		Pregunta pregunta143= new Pregunta("¿Cómo se decía en latín la famosa expresión 'La suerte está echada'?","Alea iacta est","In medio virtus","Clavum clavo expellere","Cogito, ergo sum",TipoPregunta.DIFICIL,ClasePregunta.HISTORIA);
		Pregunta pregunta144= new Pregunta("¿Por cuánto vendió Rusia a Alaska a los Estados Unidos?","Alrededor de 7,2 millones de dólares","7200 millones de dólares","720 millones de dólares","72 millones de dolares",TipoPregunta.DIFICIL,ClasePregunta.HISTORIA);
		Pregunta pregunta145= new Pregunta("¿Cuándo fue el periodo de la guerra de África?","De 1859 a 1860","De 1859 a 1861","De 1858 a 1860","De 1859 a 1862",TipoPregunta.DIFICIL,ClasePregunta.HISTORIA);
		Pregunta pregunta146= new Pregunta("¿Cómo se llamaba el caballo de Alejandro Magno?","Bucéfalo","Rocinante","Pegaso","Babieca",TipoPregunta.DIFICIL,ClasePregunta.HISTORIA);
		Pregunta pregunta147= new Pregunta("¿De qué color eran los permisos de conducir en España en el año 2003?","Rosa","Rojo","Fucsia","Marron",TipoPregunta.DIFICIL,ClasePregunta.HISTORIA);
		Pregunta pregunta148= new Pregunta("¿A quién mató el anarquista Angiolillo?","Cánovas del Castillo","Práxedes Mateo Sagasta","Serafín Estébanez Calderón","Arsenio Martínez Campos",TipoPregunta.DIFICIL,ClasePregunta.HISTORIA);
		Pregunta pregunta149= new Pregunta("La fiebre del oro fue un período de migraciones hacia áreas rurales para explorar oro. ¿Dónde se produjo las más famosa?","California","Alaska","Klondike","Norte de nevada",TipoPregunta.DIFICIL,ClasePregunta.HISTORIA);
		Pregunta pregunta150= new Pregunta("¿Qué conquistador y explorador, cuyos restos momificados se exhibieron en Perú, fue asesinado por sus propios hombres?","Francisco Pizarro","Lope de Aguirre","Hernando Pizarro","Diego de Almagro",TipoPregunta.DIFICIL,ClasePregunta.HISTORIA);
	
		Pregunta pregunta151= new Pregunta("¿Alberto, Benjamín y Carlota hicieron un total de 20 sándwiches,Benjamín hizo 3 veces más que Alberto, y Carlota hizo el doble que Benjamín.¿Cuántos sándwiches hizo Alberto?","2","3","5","4",TipoPregunta.FACIL,ClasePregunta.MATEMATICA);
		Pregunta pregunta152= new Pregunta("Si 10 + x es 5 más que 10, ¿cuál es el valor de 2x?","10","5","15","7.5",TipoPregunta.FACIL,ClasePregunta.MATEMATICA);
		Pregunta pregunta153= new Pregunta("Cuál es la representación gráfica del número nueve mil treinta y seis","9036","9360","90306","9336",TipoPregunta.FACIL,ClasePregunta.MATEMATICA);
		Pregunta pregunta154= new Pregunta("A cuántas unidades equivale 10 decenas de millar","100000 unidades","99999 unidades","10000 unidades","1000000 unidades",TipoPregunta.FACIL,ClasePregunta.MATEMATICA);
		Pregunta pregunta155= new Pregunta("Aproxima el número 58 a la decena","60","50","68","65",TipoPregunta.FACIL,ClasePregunta.MATEMATICA);
		Pregunta pregunta156= new Pregunta("Escribe el número ordinal trigésimo quinto en cifras","35","57","39","30",TipoPregunta.FACIL,ClasePregunta.MATEMATICA);
		Pregunta pregunta157= new Pregunta("¿Qué número resulta si divides 56 entre 7","7","6","8","7,28",TipoPregunta.FACIL,ClasePregunta.MATEMATICA);
		Pregunta pregunta158= new Pregunta("Si en una carrera vas tres puestos por detrás del vigésimo segundo, ¿en qué puesto vas?","Decimonoveno","Noveno","Decimotercero","Onceavo",TipoPregunta.FACIL,ClasePregunta.MATEMATICA);
		Pregunta pregunta159= new Pregunta("Cómo se llama el polígono de siete lados","Septágono","Octagono","Pentagono","Nonagono",TipoPregunta.FACIL,ClasePregunta.MATEMATICA);
		Pregunta pregunta160= new Pregunta(" Cuál es el resultado de multiplicar 7x9","63","67","64","73",TipoPregunta.FACIL,ClasePregunta.MATEMATICA);
		
		Pregunta pregunta161= new Pregunta("En una panadería con 80 kg de harina son capaces de hacer 120 kg de pan. ¿Cuántos kg de harina serán necesarios para hacer 99 kg de pan?","66 kg de harina","67 kg de harina","64 kg de harina","73 kg de harina",TipoPregunta.MEDIA,ClasePregunta.MATEMATICA);
		Pregunta pregunta162= new Pregunta("Dos ruedas están unidas por una correa de transmisión. La primera tiene un radio de 25 cm y la segunda de 75 cm. Cuando la primera ha dado 300 vueltas. ¿Cuántas vueltas dará la segunda?","100 vueltas","121 vueltas","127 vueltas","99 vueltas",TipoPregunta.MEDIA,ClasePregunta.MATEMATICA);
		Pregunta pregunta163= new Pregunta("¿Cuánto es la cuarta parte de la tercera parte?","Un doceavo","Tres cuartos","Un noveno ","Un septimo",TipoPregunta.MEDIA,ClasePregunta.MATEMATICA);
		Pregunta pregunta164= new Pregunta("Seis personas pueden vivir en un hotel durante 12 días por 792 euros. ¿Cuánto costará el hotel de 15 personas durante 8 días?","1320 euros","1239 euros","1327 euros","1289 euros",TipoPregunta.MEDIA,ClasePregunta.MATEMATICA);
		Pregunta pregunta165= new Pregunta("¿Qué es un triángulo isósceles?","Un tipo de triángulo que tiene dos lados de igual longitud","Un tipo de triángulo que tiene un angulo de 90 grados","Un tipo de triángulo que tiene dos lados de igual longitud y necesariamnete un angulo recto","Un tipo de triángulo que tiene todos sus lados iguales",TipoPregunta.MEDIA,ClasePregunta.MATEMATICA);
		Pregunta pregunta166= new Pregunta("¿Cómo se llama a un poliedro de 20 caras?","icosaedro","tetradecaedro","hectaedro","pentadecaedro",TipoPregunta.MEDIA,ClasePregunta.MATEMATICA);
		Pregunta pregunta167= new Pregunta("Si 8 litros de aceite valen 60 euros. ¿Cuántos litros compraré con 15 euros?","2 litros de aceite","2,5 litros de aceite","2,7 litros de aceite","2,8 litros de aceite",TipoPregunta.MEDIA,ClasePregunta.MATEMATICA);
		Pregunta pregunta168= new Pregunta("¿Cuánto habrá que rebajar un producto para que valga lo mismo que valía antes de que incrementase un 25% su precio?","un 20%","un 23%","un 25%","un 22",TipoPregunta.MEDIA,ClasePregunta.MATEMATICA);
		Pregunta pregunta169= new Pregunta("En un torneo de tenis, el jugador que pierde se vuelve a casa. Cuántos jugadores iniciaron este torneo si desde la ronda preliminar hasta la final se han jugado 128 partidos","129","67","64","128",TipoPregunta.MEDIA,ClasePregunta.MATEMATICA);
		Pregunta pregunta170= new Pregunta("Tengo 20 metros de cinta roja para hacer lazos en unos paquetes de regalo idénticos. Para cada lazo necesito 50 centímetros de cinta. ¿Cuántos lazos puedo hacer?","40 lazos","47 lazos","50 lazos","39 lazos",TipoPregunta.MEDIA,ClasePregunta.MATEMATICA);
	
		Pregunta pregunta171= new Pregunta("¿Cuál es la función inversa de y=sen.x?","y=arc. sen x","y = arccsc(x)","x = tan(y)","x = csc(y)",TipoPregunta.DIFICIL,ClasePregunta.MATEMATICA);
		Pregunta pregunta172= new Pregunta("¿Cómo se llaman los triángulos con dos los lados iguales y uno desigual?","Isósceles","icosaedro","escaleno","Equilatero",TipoPregunta.DIFICIL,ClasePregunta.MATEMATICA);
		Pregunta pregunta173= new Pregunta("El monstruo del lago Ness mide 80 metros más la mitad de lo que mide, ¿cuánto mide el monstruo del lago Ness?","160 metros","173 metos","178 metros","167 metros ",TipoPregunta.DIFICIL,ClasePregunta.MATEMATICA);
		Pregunta pregunta174= new Pregunta("Adivina cuántos años tengo sabiendo que la tercera parte de ellos menos 1 es igual a la sexta parte","6","13","7","9",TipoPregunta.DIFICIL,ClasePregunta.MATEMATICA);
		Pregunta pregunta175= new Pregunta("¿A cuánto equivale pi?","3.1415","3.1416","3.1514","3.1418",TipoPregunta.DIFICIL,ClasePregunta.MATEMATICA);
		Pregunta pregunta176= new Pregunta("¿Qué formula es esta? S = π x R²","Superficie de un circulo","Radio de un circulo","Area de un circulo","perimetro de un cubo",TipoPregunta.DIFICIL,ClasePregunta.MATEMATICA);
		Pregunta pregunta177= new Pregunta("Por un bolso hemos pagado 50 euros, más el 21% de IVA. ¿Cuánto hemos tenido que pagar en total?","60,50","59.80","64,79","61,35",TipoPregunta.DIFICIL,ClasePregunta.MATEMATICA);
		Pregunta pregunta178= new Pregunta("¿Qué expresa esta formula? e = mc²","equivalente entre masa y energía","Energia cinetica","64","Constante de Coulomb",TipoPregunta.DIFICIL,ClasePregunta.MATEMATICA);
		Pregunta pregunta179= new Pregunta("Una rueda de un coche da 4590 vueltas en 9 minutos. ¿Cuántas vueltas dará en 24 horas y 24 minutos?","746640","746646","746648","744640",TipoPregunta.DIFICIL,ClasePregunta.MATEMATICA);
		Pregunta pregunta180= new Pregunta("¿Cuáles de los siguientes triángulos, según sus medidas son rectángulos?","3 cm, 4 cm, 5 cm","4 cm, 4 cm, 4 cm","3 cm, 4 cm, 4 cm","3 cm, 4 cm, 0 cm",TipoPregunta.DIFICIL,ClasePregunta.MATEMATICA);
        //se llena el Hashtable

        Hashtable<Integer,Pregunta> listaPreguntas = new Hashtable<Integer,Pregunta>();


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
		listaPreguntas.put(51, pregunta51);
		listaPreguntas.put(52, pregunta52);
		listaPreguntas.put(53, pregunta53);
		listaPreguntas.put(54, pregunta54);
		listaPreguntas.put(55, pregunta55);
		listaPreguntas.put(56, pregunta56);
		listaPreguntas.put(57, pregunta57);
		listaPreguntas.put(58, pregunta58);
		listaPreguntas.put(59, pregunta59);
		listaPreguntas.put(60, pregunta60);
		listaPreguntas.put(61, pregunta61);
		listaPreguntas.put(62, pregunta62);
		listaPreguntas.put(63, pregunta63);
		listaPreguntas.put(64, pregunta64);
		listaPreguntas.put(65, pregunta65);
		listaPreguntas.put(66, pregunta66);
		listaPreguntas.put(67, pregunta67);
		listaPreguntas.put(68, pregunta68);
		listaPreguntas.put(69, pregunta69);
		listaPreguntas.put(70, pregunta70);
		listaPreguntas.put(71, pregunta71);
		listaPreguntas.put(72, pregunta72);
		listaPreguntas.put(73, pregunta73);
		listaPreguntas.put(74, pregunta74);
		listaPreguntas.put(75, pregunta75);
		listaPreguntas.put(76, pregunta76);
		listaPreguntas.put(77, pregunta77);
		listaPreguntas.put(78, pregunta78);
		listaPreguntas.put(79, pregunta79);
		listaPreguntas.put(80, pregunta80);
		listaPreguntas.put(81, pregunta81);
		listaPreguntas.put(82, pregunta82);
		listaPreguntas.put(83, pregunta83);
		listaPreguntas.put(84, pregunta84);
		listaPreguntas.put(85, pregunta85);
		listaPreguntas.put(86, pregunta86);
		listaPreguntas.put(87, pregunta87);
		listaPreguntas.put(88, pregunta88);
		listaPreguntas.put(89, pregunta89);
		listaPreguntas.put(90, pregunta90);
		listaPreguntas.put(91, pregunta91);
		listaPreguntas.put(92, pregunta92);
		listaPreguntas.put(93, pregunta93);
		listaPreguntas.put(94, pregunta94);
		listaPreguntas.put(95, pregunta95);
		listaPreguntas.put(96, pregunta96);
		listaPreguntas.put(97, pregunta97);
		listaPreguntas.put(98, pregunta98);
		listaPreguntas.put(99, pregunta99);
		listaPreguntas.put(100, pregunta100);
		listaPreguntas.put(101, pregunta101);
		listaPreguntas.put(102, pregunta102);
		listaPreguntas.put(103, pregunta103);
		listaPreguntas.put(104, pregunta104);
		listaPreguntas.put(105, pregunta105);
		listaPreguntas.put(106, pregunta106);
		listaPreguntas.put(107, pregunta107);
		listaPreguntas.put(108, pregunta108);
		listaPreguntas.put(109, pregunta109);
		listaPreguntas.put(110, pregunta110);
		listaPreguntas.put(111, pregunta111);
		listaPreguntas.put(112, pregunta112);
		listaPreguntas.put(113, pregunta113);
		listaPreguntas.put(114, pregunta114);
		listaPreguntas.put(115, pregunta115);
		listaPreguntas.put(116, pregunta116);
		listaPreguntas.put(117, pregunta117);
		listaPreguntas.put(118, pregunta118);
		listaPreguntas.put(119, pregunta119);
		listaPreguntas.put(120, pregunta120);
		listaPreguntas.put(121, pregunta121);
		listaPreguntas.put(122, pregunta122);
		listaPreguntas.put(123, pregunta123);
		listaPreguntas.put(124, pregunta124);
		listaPreguntas.put(125, pregunta125);
		listaPreguntas.put(126, pregunta126);
		listaPreguntas.put(127, pregunta127);
		listaPreguntas.put(128, pregunta128);
		listaPreguntas.put(129, pregunta129);
		listaPreguntas.put(130, pregunta130);
		listaPreguntas.put(131, pregunta131);
		listaPreguntas.put(132, pregunta132);
		listaPreguntas.put(133, pregunta133);
		listaPreguntas.put(134, pregunta134);
		listaPreguntas.put(135, pregunta135);
		listaPreguntas.put(136, pregunta136);
		listaPreguntas.put(137, pregunta137);
		listaPreguntas.put(138, pregunta138);
		listaPreguntas.put(139, pregunta139);
		listaPreguntas.put(140, pregunta140);
		listaPreguntas.put(141, pregunta141);
		listaPreguntas.put(142, pregunta142);
		listaPreguntas.put(143, pregunta143);
		listaPreguntas.put(144, pregunta144);
		listaPreguntas.put(145, pregunta145);
		listaPreguntas.put(146, pregunta146);
		listaPreguntas.put(147, pregunta147);
		listaPreguntas.put(148, pregunta148);
		listaPreguntas.put(149, pregunta149);
		listaPreguntas.put(150, pregunta150);
		listaPreguntas.put(151, pregunta151);
		listaPreguntas.put(152, pregunta152);
		listaPreguntas.put(153, pregunta153);
		listaPreguntas.put(154, pregunta154);
		listaPreguntas.put(155, pregunta155);
		listaPreguntas.put(156, pregunta156);
		listaPreguntas.put(157, pregunta157);
		listaPreguntas.put(158, pregunta158);
		listaPreguntas.put(159, pregunta159);
		listaPreguntas.put(160, pregunta160);
		listaPreguntas.put(161, pregunta161);
		listaPreguntas.put(162, pregunta162);
		listaPreguntas.put(163, pregunta163);
		listaPreguntas.put(164, pregunta164);
		listaPreguntas.put(165, pregunta165);
		listaPreguntas.put(166, pregunta166);
		listaPreguntas.put(167, pregunta167);
		listaPreguntas.put(168, pregunta168);
		listaPreguntas.put(169, pregunta169);
		listaPreguntas.put(170, pregunta170);
		listaPreguntas.put(171, pregunta171);
		listaPreguntas.put(172, pregunta172);
		listaPreguntas.put(173, pregunta173);
		listaPreguntas.put(174, pregunta174);
		listaPreguntas.put(175, pregunta175);
		listaPreguntas.put(176, pregunta176);
		listaPreguntas.put(177, pregunta177);
		listaPreguntas.put(178, pregunta178);
		listaPreguntas.put(179, pregunta179);
		listaPreguntas.put(180, pregunta180);	
		juego.setListaPreguntas(listaPreguntas);
		System.out.println("Juego inicializado");

	}

	/**
	 * M�todo retorna el marketplace
	 *
	 * @return marketplace
	 */

	public Juego getJuego() {
		return juego;
	}


	/**
	 * M�todo que permite actualizar el marketplace
	 * @param juego
	 */

	public void setJuego(Juego juego) {
		this.juego = juego;
	}

	public Jugador getJugadorLogueado() {
		return jugadorLogueado;
	}

	public void setJugadorLogueado(Jugador jugadorLogueado) {
		this.jugadorLogueado = jugadorLogueado;
	}


	
	public String registrarJugador(String nombre, String contrasenia) throws JuegoException{

       String mensaje=juego.crearJugador(nombre, contrasenia);

	   if(!mensaje.equalsIgnoreCase("")){
		guardarResourceXML();
	   }

		return mensaje;
	}

	public Hashtable<Integer,Jugador> obtenerJugadores() {
		return juego.getListaJugadores();
	}

	

	

	
}