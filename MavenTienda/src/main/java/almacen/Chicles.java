package almacen;

public class Chicles extends Objetos{

	public Chicles(String nombre, double precio, double cantidad) {
		super("Pipas", 1.89, 1);
	}

	public void aumentarChicles() {
		almacen.ArrayListsAlmacen.add(listaChicles);
	}
	
	public void reducirChicles() {
		for (int i = almacen.ArrayListsAlmacen.chicles.size(); i > 0; i--) {
			almacen.ArrayListsAlmacen.chicles.remove(i);
		}
	}

}
