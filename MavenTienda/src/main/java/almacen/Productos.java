package almacen;

public class Productos {
	private String nombre;
	private double precio;
	private double cantidad;

	/**
	 * Aqu� deber�a crearse el elemento padre de todos los dem�s productos, que
	 * contiene sus elementos "genericos".
	 * @param nombre Nombre del elemento.
	 * @param precio Precio del producto.
	 * @param cantidad Cantidad que se acumula del mismo.
	 */
	public Productos(String nombre, double precio, double cantidad) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.setCantidad(cantidad);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "Objetos [nombre=" + nombre + ", precio=" + precio + ", cantidad= " + cantidad + "]";
	}

}
