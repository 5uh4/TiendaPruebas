package tests.views;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.swing.JPasswordField;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import views.LoginView;
import views.RegisterView;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Test_RegisterView {

	private RegisterView createRegisterView() {
		return new RegisterView();
	}

	@Test
	@Order(1)
	@DisplayName("Se crea un frame con los datos vacios")
	public void testRegisterView() {
		RegisterView rv = createRegisterView();

		assertTrue(rv.getJFrame().isShowing(), "No se crea un frame correctamente");
		assertTrue(rv.getTextField().getText().isEmpty(), "Hay datos predeterminados");
		for (JPasswordField pf : rv.getPasswordFields()) {
			assertTrue(new String(pf.getPassword()).isEmpty(), "Hay datos predeterminados");
		}

		rv.dispose();
	}

	@Test
	@Order(2)
	@DisplayName("Registramos un usuario")
	public void testRegistro() {
		RegisterView rv = createRegisterView();

		rv.registro();

		assertTrue(rv.getJFrame().isShowing(), "Se registra cuando no se debe");
		rv.getTextField().setText("a");
		rv.getPasswordFields()[0].setText("a");
		rv.getPasswordFields()[1].setText("b");
		assertTrue(rv.getTextField().getText().equals("a"), "No se setea correctamente");
		assertTrue(new String(rv.getPasswordFields()[0].getPassword()).equals("a"), "No se setea correctamente");
		assertTrue(new String(rv.getPasswordFields()[1].getPassword()).equals("b"), "No se setea correctamente");

		rv.registro();

		assertTrue(rv.getJFrame().isShowing(), "Se registra cuando no se debe");
		for (JPasswordField pf : rv.getPasswordFields()) {
			pf.setText("a");
		}
		for (JPasswordField pf : rv.getPasswordFields()) {
			assertTrue(new String(pf.getPassword()).equals("a"), "No se setea correctamente");
		}

		rv.registro();

		assertTrue(almacen.ArrayListsAlmacen.cuentas.size() > 0, "No se introducen los usuarios correctamente");
	}

	@Test
	@Order(3)
	@DisplayName("Se vuelve al login correctamente")
	public void testLogin() {
		// Funcion no encapsulada, se ha copiado el codigo necesario
		RegisterView rv = createRegisterView();
		new LoginView();
		rv.dispose();

		assertFalse("No se elemina el frame correctamente", rv.getJFrame().isShowing());
	}

}
