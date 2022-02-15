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

	/**
	 * Función que debería aumentar la cantidad de panes en el ArrayList del
	 * almacén.
	 */
	public void aumentarPanes() {
		almacen.ArrayListsAlmacen.pan.add(Pan);
	}
	/**
	 * 
	 */
	public void reducirPanes() {
		for (int i = pipas.size(); i > 0; i--) {
			pan.remove(i);
		}

	}

}
