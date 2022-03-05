package tests.almacen;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import almacen.Personas;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Test_Personas {

	private Personas createPersona() {
		return new Personas("a", "a");
	}

	@Test
	@Order(1)
	@DisplayName("Comprobacion datos persona")
	public void testCreatePersona() {
		Personas p = createPersona();

		assertTrue(p.getUsername().equals("a"), "No se crea correctamente");
		assertTrue(p.getPassword().equals("a"), "No se crea correctamente");
	}

	@Test
	@Order(2)
	@DisplayName("Comprobacion modificación datos")
	public void testModifyPersona() {
		Personas p = createPersona();

		p.setUsername("d");
		p.setPassword("d");

		assertFalse("No se cambia", p.getUsername().equals("a"));
		assertFalse("No se cambia", p.getPassword().equals("a"));

		assertTrue(p.getUsername().equals("d"), "No se cambia correctamente");
		assertTrue(p.getPassword().equals("d"), "No se cambia correctamente");
	}

	@Test
	@Order(3)
	@DisplayName("Comprobacion de igualdad de usuarios")
	public void testComparar() {
		Personas p = createPersona(), clon = createPersona(), fake = new Personas("fake", "a");

		assertTrue(p.comparar(clon), "No se comparan correctamente");
		assertFalse("No se comparan correctamente", !p.comparar(clon));
		
		assertTrue(!p.comparar(fake), "No se comparan correctamente");
		assertFalse("No se comparan correctamente", p.comparar(fake));
	}

}
