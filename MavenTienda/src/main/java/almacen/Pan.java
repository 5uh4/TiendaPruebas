package almacen;

public class Pan extends Productos {

	/**
	 * Aquí se crea el objeto "Pan".
	 * 
	 * @param nombre   Nombre, estandarizado "Baguette".
	 * @param precio   Precio del pan, a 50 centimos.
	 * @param cantidad Cantidad del pan, un panecillo.
	 */
	public Pan(String nombre, double precio, double cantidad) {
		super("Baguette", 0.50, 1);

	}
}
