package tests.views;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import views.CestaView;
import views.TiendaView;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Test_TiendaView {
	private TiendaView createTiendaView() {
		return new TiendaView();
	}

	@Test
	@Order(1)
	@DisplayName("Comprobacion de que se crea una vista vacia")
	public void testTiendaView() {
		TiendaView tv = createTiendaView();

		assertTrue(tv.sumaCestita == 0, "La cesta no esta vacia");
	}

	@Test
	@Order(2)
	@DisplayName("Metemos objetos en la cesta")
	public void testAddProductos() {
		TiendaView tv = createTiendaView();

		assertTrue(almacen.ArrayListsAlmacen.listaChicles.size() == 0, "Hay chicles");
		tv.añadirChicle();
		assertTrue(almacen.ArrayListsAlmacen.listaChicles.size() >= 1, "No se meten correctamente los chicles");
		assertFalse("Se meten mas chicles de la cuenta", almacen.ArrayListsAlmacen.listaChicles.size() > 1);
		assertTrue(tv.sumaCestita == 1, "No se calcula correctamente la cantidad de objetos");

		assertTrue(almacen.ArrayListsAlmacen.listaPan.size() == 0, "Hay pan");
		tv.añadirPan();
		assertTrue(almacen.ArrayListsAlmacen.listaPan.size() >= 1, "No se meten correctamente los panes");
		assertFalse("Se meten mas panes de la cuenta", almacen.ArrayListsAlmacen.listaPan.size() > 1);
		assertTrue(tv.sumaCestita == 2, "No se calcula correctamente la cantidad de objetos");

		assertTrue(almacen.ArrayListsAlmacen.listaPipas.size() == 0, "Hay pipas");
		tv.añadirPipas();
		assertTrue(almacen.ArrayListsAlmacen.listaPipas.size() >= 1, "No se meten correctamente las pipas");
		assertFalse("Se meten mas pipas de la cuenta", almacen.ArrayListsAlmacen.listaPipas.size() > 1);
		assertTrue(tv.sumaCestita == 3, "No se calcula correctamente la cantidad de objetos");
	}

	@Test
	@Order(3)
	@DisplayName("Entramos en la cesta")
	public void testCesta() {
		// Funcion no encapsulada, se ha copiado el codigo necesario
		TiendaView tv = createTiendaView();

		new CestaView();
		tv.getFrame().setVisible(false);

		assertFalse("No se elimina el frame", tv.getFrame().isShowing());
	}

	@Test
	@Order(4)
	@DisplayName("Confirmamos cerrar sesion")
	public void testCerrarSesion_Yes() {
		TiendaView tv = createTiendaView();

		tv.cerrarSesion();

		assertFalse("No se elimina el frame", tv.getFrame().isShowing());
	}

	@Test
	@Order(5)
	@DisplayName("Cancelamos cerrar sesion")
	public void testCerrarSesion_No() {
		TiendaView tv = createTiendaView();

		tv.cerrarSesion();

		assertTrue(tv.getFrame().isShowing(), "Se elimina el frame");
	}

}
