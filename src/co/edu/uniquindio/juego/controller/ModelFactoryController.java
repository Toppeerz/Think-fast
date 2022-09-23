package co.edu.uniquindio.juego.controller;

import co.edu.uniquindio.juego.model.Juego;
import co.edu.uniquindio.juego.model.Jugador;
import co.edu.uniquindio.juego.persistencia.Persistencia;

public class ModelFactoryController {



	Juego juego;
	


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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	**/

/**	private void cargarDatosDesdeArchivos() {

		marketplace = new Marketplace();

		try {

			Persistencia.cargarDatosArchivos(getMarketplace());

		} catch (IOException e) {
			// TODO Auto-generated catch block
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

		Jugador jugador1 = new Jugador("Juan","100",1000,0);

        juego.getListaJugadores().put(0, jugador1);

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

	public void setMarketplace(Juego juego) {
		this.juego = juego;
	}


	
}