package almacen;

public class Objetos {
	private String nombre;
	private double precio;
	private double cantidad;

	public Objetos(String nombre, double precio, double cantidad) {
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
		return "Objetos [nombre=" + nombre + ", precio=" + precio + "]";
	}

}
