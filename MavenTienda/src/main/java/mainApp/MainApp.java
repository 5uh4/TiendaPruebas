package mainApp;

import almacen.Personas;
import views.LoginViewTienda;

public class MainApp {

	public static void main(String[] args) {
		// Aquí se lanza la aplicación, con el login en funcionamiento, y dos cuentas creadas.
		almacen.ArrayListsAlmacen.cuentas.add(new Personas("usuarioPrueba", "1234"));
		almacen.ArrayListsAlmacen.cuentas.add(new Personas ("a1", "12"));
		new LoginViewTienda();
	}

}
