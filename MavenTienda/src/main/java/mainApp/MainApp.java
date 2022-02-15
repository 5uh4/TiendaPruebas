package mainApp;

import almacen.Personas;
import views.LoginViewTienda;

public class MainApp {

	public static void main(String[] args) {
		// Aquí debería lanzarse la vista principal que es el Login (not working, don't
		// know why).
		almacen.ArrayListsAlmacen.cuentas.add(new Personas("usuarioPrueba", "1234"));
		almacen.ArrayListsAlmacen.cuentas.add(new Personas ("a1", "12"));
		new LoginViewTienda();
	}

}
