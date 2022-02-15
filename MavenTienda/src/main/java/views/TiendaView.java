package views;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class TiendaView {

	private JFrame frame;

	/**
	 * Launch the application. Lanza la app.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TiendaView window = new TiendaView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application. Crea la app.
	 */
	public TiendaView() {
		initialize();
		frame.revalidate();
		frame.repaint();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame. Contiene los elementos de la app.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 460, 309);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		// Nombre de la tienda, not important.
		JLabel lblTienda = new JLabel("Supermercado Hiasul");
		lblTienda.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTienda.setBounds(10, 10, 142, 13);
		frame.getContentPane().add(lblTienda);

		// Boton que permite añadir pipas a la cesta.
		JButton btnPipas = new JButton("A\u00F1adir a la cesta");
		btnPipas.setBounds(181, 57, 134, 21);
		frame.getContentPane().add(btnPipas);

		// Etiqueta de pipas.
		JLabel lblPipas = new JLabel("- Pipas");
		lblPipas.setBounds(54, 61, 45, 13);
		frame.getContentPane().add(lblPipas);

		// Etiqueta de flecha para las pipas.
		JLabel lblFlechaPipas = new JLabel("-->");
		lblFlechaPipas.setBounds(109, 61, 20, 13);
		frame.getContentPane().add(lblFlechaPipas);

		// Etiqueta con el precio de las pipas.
		JLabel lblPrecioPipas = new JLabel("3,50\u20AC");
		lblPrecioPipas.setBounds(142, 61, 29, 13);
		frame.getContentPane().add(lblPrecioPipas);

		// Etiqueta con la palabra Producto, que va por encima de todo.
		JLabel lblH1 = new JLabel("Producto");
		lblH1.setBounds(41, 38, 45, 13);
		frame.getContentPane().add(lblH1);

		// Etiqueta con la palabra Precio, que va por encima de todo.
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(130, 38, 45, 13);
		frame.getContentPane().add(lblPrecio);

		// Etiqueta de pan.
		JLabel lblPan = new JLabel("- Pan");
		lblPan.setBounds(54, 102, 45, 13);
		frame.getContentPane().add(lblPan);

		// Etiqueta con la flecha del pan
		JLabel lblFlechaPan = new JLabel("-->");
		lblFlechaPan.setBounds(109, 102, 20, 13);
		frame.getContentPane().add(lblFlechaPan);

		// Etiqueta con el precio del pan.
		JLabel lblPrecioPan = new JLabel("0,50\u20AC");
		lblPrecioPan.setBounds(142, 102, 29, 13);
		frame.getContentPane().add(lblPrecioPan);

		// Boton para añadir pan a la cesta.
		JButton btnPan = new JButton("A\u00F1adir a la cesta");
		btnPan.setBounds(181, 98, 134, 21);
		frame.getContentPane().add(btnPan);

		// Etiqueta con chicles
		JLabel lblChicle = new JLabel("- Chicles");
		lblChicle.setBounds(54, 151, 45, 13);
		frame.getContentPane().add(lblChicle);

		// Etiqueta con la flecha de los chicles.
		JLabel lblFlechaChicle = new JLabel("-->");
		lblFlechaChicle.setBounds(109, 151, 20, 13);
		frame.getContentPane().add(lblFlechaChicle);

		// Etiqueta con el precio de los chicles.
		JLabel lblPrecioChicle = new JLabel("0,05\u20AC");
		lblPrecioChicle.setBounds(142, 151, 29, 13);
		frame.getContentPane().add(lblPrecioChicle);

		// Botón para añadir chicles a la cesta.
		JButton btnChicle = new JButton("A\u00F1adir a la cesta");
		btnChicle.setBounds(181, 147, 134, 21);
		frame.getContentPane().add(btnChicle);

		/**
		 * Boton para ver la cesta. 
		 * ESTE BOTON TIENE QUE TENER EL NUMERO AL LADO DE
		 * COSAS EN LA CESTA. (!!!!!)
		 */
		JButton btnCesta = new JButton("Cesta");
		btnCesta.setBounds(44, 212, 85, 21);
		frame.getContentPane().add(btnCesta);

		/**
		 * Boton que lanza un panel de confirmación para cerrar sesión.
		 * Si se acepta, lleva de vuelta al Login y si no se vuelve a la tienda.
		 */
		final JButton btnOff = new JButton("<html>Cerrar<br>sesi\u00F3n</html>");
		btnOff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirmado = JOptionPane.showConfirmDialog(btnOff, "¿Desea cerrar sesión", "Cierre de sesión",
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (JOptionPane.OK_OPTION == confirmado) {
					System.out.println("Saliendo.");
					new LoginViewTienda();
					frame.dispose();
					JOptionPane.showMessageDialog(btnOff, "Saliendo.");
				} else {
					JOptionPane.showMessageDialog(btnOff, "Volviendo.");
				}
			}
		});
		btnOff.setBounds(325, 38, 95, 63);
		frame.getContentPane().add(btnOff);

		/**
		 * Botón que se encarga de borrar la cuenta que se está utilizando actualmente.
		 */
		final JButton btnNuke = new JButton("<html>Destruir<br>cuenta</html>");
		btnNuke.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean encontrado = false;
				for(int i = 0; i < almacen.ArrayListsAlmacen.cuentas.size(); i++) {
					if (LoginViewTienda.userActual.comparar(almacen.ArrayListsAlmacen.cuentas.get(i))){
						encontrado = true;
						JOptionPane.showMessageDialog(btnNuke, "Cuenta borrada.");
					}
				} 
			}
		});
		btnNuke.setBounds(325, 124, 95, 42);
		frame.getContentPane().add(btnNuke);
	}
}
