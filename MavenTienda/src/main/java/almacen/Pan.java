package almacen;

public class Pan extends Objetos{

	public Pan(String nombre, double precio, double cantidad) {
		super("Baguette", 0.50, 1);
		
	}
	
	public void aumentarPanes() {
		almacen.ArrayListsAlmacen.pan.add(Pan);
	}
	
	public void reducirPanes() {
		for (int i = pipas.size(); i > 0; i--) {
			pan.remove(i);
		}
		
	}

}
