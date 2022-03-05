package tests.views;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import almacen.Chicles;
import almacen.Pan;
import almacen.Pipas;
import views.CestaView;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Test_CestaView {

	private CestaView createCesta() {
		return new CestaView();
	}

	private void setUpCesta() {
		almacen.ArrayListsAlmacen.listaChicles.add(new Chicles(null, 0, 0));
		almacen.ArrayListsAlmacen.listaPan.add(new Pan(null, 0, 0));
		almacen.ArrayListsAlmacen.listaPipas.add(new Pipas(null, 0, 0));
	}

	@Test
	@Order(1)
	@DisplayName("La vista se crea")
	public void testCreateCestaView() {
		CestaView cv = createCesta();

		assertTrue(cv.getJFrame() != null);
		
		cv.dispose();
	}

	@Test
	@Order(2)
	@DisplayName("La cesta tiene objetos")
	public void testCesta() {
		setUpCesta();

		assertTrue(almacen.ArrayListsAlmacen.listaChicles.size() == 1, "No se introducen");
		assertTrue(almacen.ArrayListsAlmacen.listaPan.size() == 1, "No se introducen");
		assertTrue(almacen.ArrayListsAlmacen.listaPipas.size() == 1, "No se introducen");
	}

	@Test
	@Order(3)
	@DisplayName("Confirmar en compra")
	public void testComprar_Yes() {
		CestaView cv = createCesta();

		cv.comprar();
		assertTrue(almacen.ArrayListsAlmacen.listaChicles.size() == 0, "No se limpia");
		assertTrue(almacen.ArrayListsAlmacen.listaPan.size() == 0, "No se limpia");
		assertTrue(almacen.ArrayListsAlmacen.listaPipas.size() == 0, "No se limpia");

		assertFalse("No se elimina el frame", cv.getJFrame().isShowing());
	}

	@Test
	@Order(4)
	@DisplayName("Cancelar en compra")
	public void testComprar_No() {
		CestaView cv = createCesta();
		setUpCesta();

		cv.comprar();
		assertTrue(almacen.ArrayListsAlmacen.listaChicles.size() == 1, "Se limpia");
		assertTrue(almacen.ArrayListsAlmacen.listaPan.size() == 1, "Se limpia");
		assertTrue(almacen.ArrayListsAlmacen.listaPipas.size() == 1, "Se limpia");

		assertTrue(cv.getJFrame().isShowing(), "El frame se elimina");
		
		cv.dispose();
	}

	@Test
	@Order(5)
	@DisplayName("Confirmar en volver de la cesta")
	public void testSeguir_Yes() {
		CestaView cv = createCesta();

		cv.seguir();
		assertFalse("El frame no se elmina", cv.getJFrame().isShowing());
	}

	@Test
	@Order(6)
	@DisplayName("Cancelar en volver de la cesta")
	public void testSeguir_No() {
		CestaView cv = createCesta();

		cv.seguir();
		assertTrue(cv.getJFrame().isShowing(), "El frame no se elmina");
		
		cv.dispose();
	}

	@Test
	@Order(7)
	@DisplayName("Confirmar vaciar cesta")
	public void testBorradoGeneral_Yes() {
		CestaView cv = createCesta();

		assertTrue(almacen.ArrayListsAlmacen.listaChicles.size() >= 1, "Esta vacio");
		assertTrue(almacen.ArrayListsAlmacen.listaPan.size() >= 1, "Esta vacio");
		assertTrue(almacen.ArrayListsAlmacen.listaPipas.size() >= 1, "Esta vacio");

		cv.borradoGeneral();
		
		assertTrue(almacen.ArrayListsAlmacen.listaChicles.size() == 0, "No se limpia");
		assertTrue(almacen.ArrayListsAlmacen.listaPan.size() == 0, "No se limpia");
		assertTrue(almacen.ArrayListsAlmacen.listaPipas.size() == 0, "No se limpia");
		
		cv.dispose();
	}
	
	@Test
	@Order(8)
	@DisplayName("Cancelar vaciar cesta")
	public void testBorradoGeneral_No() {
		CestaView cv = createCesta();
		setUpCesta();

		cv.borradoGeneral();
		
		assertTrue(almacen.ArrayListsAlmacen.listaChicles.size() >= 1, "Se limpia");
		assertTrue(almacen.ArrayListsAlmacen.listaPan.size() >= 1, "Se limpia");
		assertTrue(almacen.ArrayListsAlmacen.listaPipas.size() >= 1, "Se limpia");
		
		cv.dispose();
	}
	
	@Test
	@Order(9)
	@DisplayName("Borrado chicles")
	public void testBorradoChicles() {
		CestaView cv = createCesta();
		
		cv.borradoChicle();
		assertTrue(almacen.ArrayListsAlmacen.listaChicles.size() == 0, "No se limpia");
		cv.borradoChicle();
		
		cv.dispose();
	}
	
	@Test
	@Order(10)
	@DisplayName("Borrado pan")
	public void testBorradoPan() {
		CestaView cv = createCesta();
		
		cv.borradoPan();
		assertTrue(almacen.ArrayListsAlmacen.listaPan.size() == 0, "No se limpia");
		cv.borradoPan();
		
		cv.dispose();
	}
	
	@Test
	@Order(11)
	@DisplayName("Borrado pipas")
	public void testBorradoPipa() {
		CestaView cv = createCesta();
		
		cv.borradoPipa();
		assertTrue(almacen.ArrayListsAlmacen.listaPipas.size() == 0, "No se limpia");
		cv.borradoPipa();
		
		cv.dispose();
	}
}
