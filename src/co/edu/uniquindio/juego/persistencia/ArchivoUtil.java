package co.edu.uniquindio.juego.persistencia;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import co.edu.uniquindio.juego.model.ClasePregunta;
import co.edu.uniquindio.juego.model.Juego;
import co.edu.uniquindio.juego.model.Jugador;
import co.edu.uniquindio.juego.model.Pregunta;
import co.edu.uniquindio.juego.model.Respuesta;
import co.edu.uniquindio.juego.model.TipoPregunta;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerException;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import java.io.File;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Esta clase teine metodo estaticos que permite usarlos sin crear instancias de
 * la clase
 * Lo que se hizo fue crear esta libreria para el manejo de los archivos
 * 
 * @author Admin
 *
 */
public class ArchivoUtil {

	static String fechaSistema = "";

	/**
	 * Este metodo recibe una cadena con el contenido que se quiere guardar en el
	 * archivo
	 * 
	 * @param ruta es la ruta o path donde esta ubicado el archivo
	 * @throws IOException
	 */
	public static void guardarArchivo(String ruta, String contenido, Boolean flagAnexarContenido) throws IOException {

		FileWriter fw = new FileWriter(ruta, flagAnexarContenido);
		BufferedWriter bfw = new BufferedWriter(fw);
		bfw.write(contenido);
		bfw.close();
		fw.close();
	}

	/**
	 * ESte metodo retorna el contendio del archivo ubicado en una ruta,con la lista
	 * de cadenas.
	 * 
	 * @param ruta
	 * @return
	 * @throws IOException
	 */
	public static ArrayList<String> leerArchivo(String ruta) throws IOException {

		ArrayList<String> contenido = new ArrayList<String>();
		FileReader fr = new FileReader(ruta);
		BufferedReader bfr = new BufferedReader(fr);
		String linea = "";
		while ((linea = bfr.readLine()) != null) {
			contenido.add(linea);
		}
		bfr.close();
		fr.close();
		return contenido;
	}

	public static void guardarRegistroLog(String mensajeLog, int nivel, String accion, String rutaArchivo) {

		Logger LOGGER = Logger.getLogger(accion);
		FileHandler fileHandler = null;
		cargarFechaSistema();
		try {

			fileHandler = new FileHandler(rutaArchivo, true);
			fileHandler.setFormatter(new SimpleFormatter());
			LOGGER.addHandler(fileHandler);
			switch (nivel) {
				case 1:
					LOGGER.log(Level.INFO, accion + "," + mensajeLog + "," + fechaSistema);
					break;

				case 2:
					LOGGER.log(Level.WARNING, accion + "," + mensajeLog + "," + fechaSistema);
					break;

				case 3:
					LOGGER.log(Level.SEVERE, accion + "," + mensajeLog + "," + fechaSistema);
					break;

				default:
					break;
			}

		} catch (SecurityException e) {

			LOGGER.log(Level.SEVERE, e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			LOGGER.log(Level.SEVERE, e.getMessage());
			e.printStackTrace();
		} finally {

			fileHandler.close();
		}

	}

	private static void cargarFechaSistema() {

		String diaN = "";
		String mesN = "";

		Calendar cal1 = Calendar.getInstance();

		int dia = cal1.get(Calendar.DATE);
		int mes = cal1.get(Calendar.MONTH) + 1;
		int anio = cal1.get(Calendar.YEAR);
		int hora = cal1.get(Calendar.HOUR);
		int minuto = cal1.get(Calendar.MINUTE);

		if (dia < 10) {
			diaN += "0" + dia;
		} else {
			diaN += "" + dia;
		}
		if (mes < 10) {
			mesN += "0" + mes;
		} else {
			mesN += "" + mes;
		}

		// fecha_Actual+= a�o+"-"+mesN+"-"+ diaN;
		fechaSistema = anio + "-" + mesN + "-" + diaN + "-" + hora + "-" + minuto;
		// fechaSistema = a�o+"-"+mesN+"-"+diaN;
		// horaFechaSistema = hora+"-"+minuto;
	}

	// ------------------------------------SERIALIZACI�N y XML
	/**
	 * Escribe en el fichero que se le pasa el objeto que se le envia
	 *
	 * @param rutaArchivo
	 *                    path del fichero que se quiere escribir
	 * @throws IOException
	 */

	public static Object cargarRecursoSerializado(String rutaArchivo) throws Exception {
		Object aux = null;
		// Empresa empresa = null;
		ObjectInputStream ois = null;
		try {
			// Se crea un ObjectInputStream
			ois = new ObjectInputStream(new FileInputStream(rutaArchivo));

			aux = ois.readObject();

		} catch (Exception e2) {
			throw e2;
		} finally {
			if (ois != null)
				ois.close();
		}
		return aux;
	}

	public static void salvarRecursoSerializado(String rutaArchivo, Object object) throws Exception {
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(rutaArchivo));
			oos.writeObject(object);
		} catch (Exception e) {
			throw e;
		} finally {
			if (oos != null)
				oos.close();
		}
	}

	public static Object cargarRecursoSerializadoXML(String rutaArchivo) throws IOException {

		XMLDecoder decodificadorXML;
		Object objetoXML;

		decodificadorXML = new XMLDecoder(new FileInputStream(rutaArchivo));
		objetoXML = decodificadorXML.readObject();
		decodificadorXML.close();
		return objetoXML;

	}

	public static void salvarRecursoSerializadoXML(String rutaArchivo, Object objeto) throws IOException {

		XMLEncoder codificadorXML;

		codificadorXML = new XMLEncoder(new FileOutputStream(rutaArchivo));
		codificadorXML.writeObject(objeto);
		codificadorXML.close();

	}

	public static void salvarRecursoSerializadoXMLDOM(String rutaArchivo, Juego juego) throws IOException {

		try {
			// fichero que se guarda
			File xml = new File(rutaArchivo);
			// objectos de clase para crear un xml
			// fabrica de documento
			DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
			// constructor de documento
			DocumentBuilder constructor = fabrica.newDocumentBuilder();

			// implementación de documentos
			DOMImplementation implementacion = constructor.getDOMImplementation();

			// crear documento XML
			// el segundo parametro es el nodo padre raíz

			Document documento = implementacion.createDocument(null, "juego", null);

			// darle una version al documento
			documento.setXmlVersion("1.0");

			// ya luego de haberlos creados nos vamos a crear las etiquetas hijas
			Element listaPreguntas = documento.createElement("listaPreguntas");
			Enumeration<Pregunta> preguntas = juego.getListaPreguntas().elements();
			while (preguntas.hasMoreElements()) {
				Pregunta preguntaActual = preguntas.nextElement();

				Element pregunta = documento.createElement("pregunta");
				Element textoPregunta = documento.createElement("textoPregunta");
				Element tipoPregunta = documento.createElement("tipoPregunta");
				Element clasePregunta = documento.createElement("clasePregunta");
				Element respuestas = documento.createElement("respuestas");

				int numero_respuesta = preguntaActual.getRespuestas().size();

				for (int i = 0; i < numero_respuesta; i++) {

					Element respuesta = documento.createElement("respuesta");

					Element textoRespuesta = documento.createElement("textoRespuesta");

					Element correcta = documento.createElement("correcta");

					Text txtTextoRespuesta = documento
							.createTextNode(preguntaActual.getRespuestas().get(i).getRespuesta());

					Text txtCorrecta = documento
							.createTextNode(String.valueOf(preguntaActual.getRespuestas().get(i).isCorrecta()));

					textoRespuesta.appendChild(txtTextoRespuesta);

					correcta.appendChild(txtCorrecta);

					respuesta.appendChild(textoRespuesta);
					respuesta.appendChild(correcta);

					respuestas.appendChild(respuesta);
				}

				Text txtTextoPregunta = documento.createTextNode(preguntaActual.getPregunta());
				Text txtTipoPregunta = documento.createTextNode(String.valueOf(preguntaActual.getTipoPregunta()));
				Text txtClasePregunta = documento.createTextNode(String.valueOf(preguntaActual.getClasePregunta()));

				textoPregunta.appendChild(txtTextoPregunta);
				tipoPregunta.appendChild(txtTipoPregunta);
				clasePregunta.appendChild(txtClasePregunta);

				pregunta.appendChild(textoPregunta);
				pregunta.appendChild(tipoPregunta);
				pregunta.appendChild(clasePregunta);
				pregunta.appendChild(respuestas);

				listaPreguntas.appendChild(pregunta);

			}
			Element listaJugadores = documento.createElement("listaJugadores");
			Enumeration<Jugador> jugadores = juego.getListaJugadores().elements();
			while (jugadores.hasMoreElements()) {
				Jugador jugadorActual = jugadores.nextElement();

				Element jugador = documento.createElement("jugador");
				Element nombre = documento.createElement("nombre");
				Element contrasenia = documento.createElement("contrasenia");
				Element puntaje = documento.createElement("puntaje");

				Text txtNombre = documento.createTextNode(jugadorActual.getNombre());
				Text txtContrasenia = documento.createTextNode(jugadorActual.getContrasenia());
				Text txtPuntaje = documento.createTextNode(String.valueOf(jugadorActual.getPuntaje()));

				nombre.appendChild(txtNombre);
				contrasenia.appendChild(txtContrasenia);
				puntaje.appendChild(txtPuntaje);

				jugador.appendChild(nombre);
				jugador.appendChild(contrasenia);
				jugador.appendChild(puntaje);

				listaJugadores.appendChild(jugador);

			}

			documento.getDocumentElement().appendChild(listaPreguntas);
			documento.getDocumentElement().appendChild(listaJugadores);

			// crear fichero tipo xml
			Source source = new DOMSource(documento);
			Result resultado = new StreamResult(xml);

			// pasar el archivo de tipo DOM a xml trivial
			Transformer transformer = TransformerFactory.newInstance().newTransformer();

			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

			transformer.transform(source, resultado);

		} catch (ParserConfigurationException | TransformerException | DOMException ex) {
			System.out.println(ex.getMessage());
		}

	}

	public static Juego cargarRecursoSerializadoXMLDOM(String rutaArchivo) throws IOException {
		Juego juego = new Juego();
		try

		{

			File xmlFile = new File(rutaArchivo);

			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = factory.newDocumentBuilder();
			Document doc = dBuilder.parse(xmlFile);

			doc.getDocumentElement().normalize();

			Node listaPreguntas = doc.getElementsByTagName("listaPreguntas").item(0);
			Hashtable<Integer, Pregunta> hashtablePreguntas = new Hashtable<Integer, Pregunta>();
			int h = 1;

			NodeList preguntas = listaPreguntas.getChildNodes();

			for (int i = 0; i < preguntas.getLength(); i++) {
				Node preguntaAux = preguntas.item(i);

				if (preguntaAux.getNodeType() == Node.ELEMENT_NODE) {

					Element elem = (Element) preguntaAux;

					Node textoPregunta = elem.getElementsByTagName("textoPregunta").item(0);
					String txtTextoPregunta = textoPregunta.getTextContent();

					Node tipoPregunta = elem.getElementsByTagName("tipoPregunta").item(0);
					String txtTipoPregunta = tipoPregunta.getTextContent();

					Node clasePregunta = elem.getElementsByTagName("clasePregunta").item(0);
					String txtClasePregunta = clasePregunta.getTextContent();

					Node listaRespuestas = elem.getElementsByTagName("respuestas").item(0);
					ArrayList<Respuesta> respuestasArray = new ArrayList<Respuesta>();

					NodeList respuestas = listaRespuestas.getChildNodes();

					for (int l = 0; l < respuestas.getLength(); l++) {

						Node respuestaAux = respuestas.item(l);

						if (respuestaAux.getNodeType() == Node.ELEMENT_NODE) {
							Element elem2 = (Element) respuestaAux;
							Node textoRespuesta = elem2.getElementsByTagName("textoRespuesta").item(0);
							String txtTextoRespuesta = textoRespuesta.getTextContent();

							Node correcta = elem2.getElementsByTagName("correcta").item(0);
							String txtCorrecta = correcta.getTextContent();

							Respuesta respuestaObjeto = new Respuesta(txtTextoRespuesta, Boolean.valueOf(txtCorrecta));
							respuestasArray.add(respuestaObjeto);
						}
					}
					Pregunta preguntaObjeto = new Pregunta();
					preguntaObjeto.setPregunta(txtTextoPregunta);
					preguntaObjeto.setRespuestas(respuestasArray);
					preguntaObjeto.setClasePregunta(ClasePregunta.valueOf(txtClasePregunta));
					preguntaObjeto.setTipoPregunta(TipoPregunta.valueOf(txtTipoPregunta));
					hashtablePreguntas.put(h, preguntaObjeto);
					h++;
					
				}
			}

			Node listaJugadores = doc.getElementsByTagName("listaJugadores").item(0);
			Hashtable<Integer, Jugador> hashtableJugadores = new Hashtable<Integer, Jugador>();
			h=0;

			NodeList jugadores = listaJugadores.getChildNodes();

			for (int i = 0; i < jugadores.getLength(); i++) {

				Node jugadorAux = jugadores.item(i);

				if (jugadorAux.getNodeType() == Node.ELEMENT_NODE) {

					Element elem = (Element) jugadorAux;

					Node nombre = elem.getElementsByTagName("nombre").item(0);
					String txtNombre = nombre.getTextContent();

					Node contrasenia = elem.getElementsByTagName("contrasenia").item(0);
					String txtContrasenia = contrasenia.getTextContent();

					Node puntaje = elem.getElementsByTagName("puntaje").item(0);
					String txtPuntaje = puntaje.getTextContent();

	
					Jugador jugadorObjeto = new Jugador();
					jugadorObjeto.setNombre(txtNombre);
					jugadorObjeto.setContrasenia(txtContrasenia);
					jugadorObjeto.setPuntaje(Integer.valueOf(txtPuntaje));
					
					hashtableJugadores.put(h, jugadorObjeto);
					h++;
				}
			}

			juego.setListaPreguntas(hashtablePreguntas);
			juego.setListaJugadores(hashtableJugadores);

		} catch (

		Exception e) {
			e.printStackTrace();

		}
		return juego;
	}
}
