package co.edu.uniquindio.juego.persistencia;

import co.edu.uniquindio.juego.model.Juego;

public class Persistencia  {

	public static final String RUTA_ARCHIVO_MODELO_JUEGO_XML = "src/resources/model.xml";
	public static final String RUTA_ARCHIVO_MODELO_JUEGO_XMLDOM= "src/resources/modelDOM.xml";



	

	public static Juego cargarRecursoBancoXML() {

		Juego juego = null;

		try {
			juego = (Juego)ArchivoUtil.cargarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_JUEGO_XML);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return juego;

	}



	public static void guardarRecursoBancoXML(Juego juego) {

		try {
			ArchivoUtil.salvarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_JUEGO_XML, juego);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void guardarRecursoBancoXMLDOM(Juego juego) {

		try {
			ArchivoUtil.salvarRecursoSerializadoXMLDOM(RUTA_ARCHIVO_MODELO_JUEGO_XMLDOM, juego);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Juego cargarRecursoBancoXMLDOM() {

          Juego juego = new Juego();

		try {
			juego =ArchivoUtil.cargarRecursoSerializadoXMLDOM(RUTA_ARCHIVO_MODELO_JUEGO_XMLDOM);
		} catch (Exception e) {
			e.printStackTrace();
		}
	return juego;

	}



		
		
	







}
