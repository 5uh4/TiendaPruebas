package tests.almacen;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import almacen.Productos;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Test_Productos {

	private Productos createProducto() {
		return new Productos("Producto", 10, 0);
	}

	/**
	 * Function that tests that the creation of a product works correctly
	 */
	@Test
	@Order(1)
	@DisplayName("Creación de un producto")
	public void testProducto() {
		Productos p = createProducto();

		// Checks the values are the ones defined
		assertTrue("Nombre no coincide", p.getNombre().equals("Producto"));
		assertTrue("Precio no coincide", Productos.getPrecio() == 10);
		assertTrue("Cantidad no coincide", Productos.getCantidad() == 0);
	}

	/**
	 * Function that tests that the modification of the product values works
	 * correctly
	 */
	@Test
	@Order(2)
	@DisplayName("Modificación de los datos de un producto")
	public void testModifyProducto() {
		Productos p = createProducto();

		// Checks the values are the originals
		assertTrue("Nombre no coincide", p.getNombre().equals("Producto"));
		assertTrue("Precio no coincide", Productos.getPrecio() == 10);
		assertTrue("Cantidad no coincide", Productos.getCantidad() == 0);

		// Change the values
		p.setNombre("Reloj");
		p.setPrecio(99);
		p.setCantidad(10);

		// Checks the values have been modified
		assertFalse(p.getNombre().equals("Producto"), "Nombre no se ha cambiado");
		assertFalse(Productos.getPrecio() == 10, "Precio no se ha cambiado");
		assertFalse(Productos.getCantidad() == 0, "Cantidad no se ha cambiado");

		assertTrue("Nombre no coincide", p.getNombre().equals("Reloj"));
		assertTrue("Precio no coincide", Productos.getPrecio() == 99);
		assertTrue("Cantidad no coincide", Productos.getCantidad() == 10);
	}
}
