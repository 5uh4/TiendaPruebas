package tests.views;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import almacen.Personas;
import views.LoginView;
import views.RegisterView;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Test_LoginView {

	private LoginView createLoginView() {
		return new LoginView();
	}

	@Test
	@Order(1)
	@DisplayName("Se crea un frame con los datos vacios")
	public void testCreateLoginView() {
		LoginView lv = createLoginView();

		assertTrue(lv.getJFrame().isShowing(), "No se crea el frame");
		assertTrue(lv.getTextField().getText().isEmpty(), "Hay datos predeterminados");
		assertTrue(new String(lv.getPasswordField().getPassword()).isEmpty(), "Hay datos predeterminados");

		lv.dispose();
	}

	@Test
	@Order(2)
	@DisplayName("Se inicia sesion")
	public void testLogin() {
		LoginView lv = createLoginView();

		lv.login();

		assertTrue(lv.getJFrame().isShowing(), "Se inicia sesion cuando no se debe");
		lv.getTextField().setText("a");
		lv.getPasswordField().setText("a");
		assertTrue(lv.getTextField().getText().equals("a"), "No se setea correctamente");
		assertTrue(new String(lv.getPasswordField().getPassword()).equals("a"), "No se setea correctamente");

		lv.login();

		assertTrue(lv.getJFrame().isShowing(), "Se inicia sesion cuando no se debe");
		almacen.ArrayListsAlmacen.cuentas.add(new Personas("a", "a"));
		assertTrue(almacen.ArrayListsAlmacen.cuentas.size() > 0, "No se introducen los usuarios de forma correcta");

		lv.login();
		assertFalse("El frame no se elimina", lv.getJFrame().isShowing());
	}

	@Test
	@Order(3)
	@DisplayName("Entramos en la vista de registro")
	public void testRegister() {
		// Funcion no encapsulada, se ha copiado el codigo necesario
		LoginView lv = createLoginView();

		new RegisterView();
		lv.dispose();

		assertFalse("El frame no se elimina", lv.getJFrame().isShowing());
	}

}
