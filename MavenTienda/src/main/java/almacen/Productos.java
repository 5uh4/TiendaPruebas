package almacen;

public class Productos {
	private String nombre;
	private static double precio;
	private static double cantidad;

	/**
	 * Aquí debería crearse el elemento padre de todos los demás productos, que
	 * contiene sus elementos "genericos".
	 * @param nombre Nombre del elemento.
	 * @param precio Precio del producto.
	 * @param cantidad Cantidad que se acumula del mismo.
	 */
	public Productos(String nombre, double precio, double cantidad) {
		super();
		this.nombre = nombre;
		Productos.precio = precio;
		Productos.cantidad = cantidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public static double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		Productos.precio = precio;
	}

	public static double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		Productos.cantidad = cantidad;
	}

	

}
