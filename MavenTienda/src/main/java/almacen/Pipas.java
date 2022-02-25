package almacen;

public class Pipas extends Productos {

	public Pipas(String nombre, double precio, double cantidad) {
		super("Pipas", 3.50, 12);
	}

	@Override
	public String toString() {
		return "Pipas [getNombre()=" + getNombre() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

}
