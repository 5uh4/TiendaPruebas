package views;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import almacen.Chicles;
import almacen.Pan;
import almacen.Pipas;
import javax.swing.JTextField;

public class TiendaView {

	private JFrame frame;
	private JTextField txtfCesta;
	public JButton btnCesta;
	public int sumaCestita = (almacen.ArrayListsAlmacen.listaChicles.size() + almacen.ArrayListsAlmacen.listaPan.size()
			+ almacen.ArrayListsAlmacen.listaPipas.size());

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
		actualizarCesta(btnCesta);
		frame.revalidate();
		frame.repaint();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame. Contiene los elementos de la app.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(60, 179, 113));
		frame.setBounds(100, 100, 460, 309);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		// Nombre de la tienda, not important.
		JLabel lblTienda = new JLabel("Supermercado Hiasul");
		lblTienda.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTienda.setBounds(10, 10, 142, 13);
		frame.getContentPane().add(lblTienda);

		// Boton que permite a�adir pipas a la cesta.
		JButton btnPipas = new JButton("A\u00F1adir a la cesta");
		btnPipas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pipas pipas = null;
				almacen.ArrayListsAlmacen.listaPipas.add(pipas);
				sumaCestita++;
				actualizarCesta(btnCesta);
			}
		});
		btnPipas.setBounds(181, 57, 134, 21);
		frame.getContentPane().add(btnPipas);

		// Etiqueta de pipas.
		JLabel lblPipas = new JLabel("- Pipas");
		lblPipas.setBounds(51, 61, 48, 13);
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

		// Boton para a�adir pan a la cesta.
		JButton btnPan = new JButton("A\u00F1adir a la cesta");
		btnPan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pan panes = null;
				almacen.ArrayListsAlmacen.listaPan.add(panes);
				sumaCestita++;
				actualizarCesta(btnCesta);
			}
		});
		btnPan.setBounds(181, 98, 134, 21);
		frame.getContentPane().add(btnPan);

		// Etiqueta con chicles
		JLabel lblChicle = new JLabel("- Chicles");
		lblChicle.setBounds(41, 151, 58, 13);
		frame.getContentPane().add(lblChicle);

		// Etiqueta con la flecha de los chicles.
		JLabel lblFlechaChicle = new JLabel("-->");
		lblFlechaChicle.setBounds(109, 151, 20, 13);
		frame.getContentPane().add(lblFlechaChicle);

		// Etiqueta con el precio de los chicles.
		JLabel lblPrecioChicle = new JLabel("0,05\u20AC");
		lblPrecioChicle.setBounds(142, 151, 29, 13);
		frame.getContentPane().add(lblPrecioChicle);

		// Bot�n para a�adir chicles a la cesta.
		JButton btnChicle = new JButton("A\u00F1adir a la cesta");
		btnChicle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Chicles chicle = new Chicles(null, 0, 0);
				almacen.ArrayListsAlmacen.listaChicles.add(chicle);
				sumaCestita++;
				actualizarCesta(btnCesta);
			}
		});
		btnChicle.setBounds(181, 147, 134, 21);
		frame.getContentPane().add(btnChicle);

		/**
		 * Boton para ver la cesta. Incluye la suma total de la cesta por medio de una funcion que la actualiza autom�ticamente.
		 */
		btnCesta = new JButton("Cesta (" + sumaCestita + ")");
		btnCesta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CestaView(frame);
				frame.setVisible(false);
			}
		});
		btnCesta.setBounds(151, 213, 107, 21);
		frame.getContentPane().add(btnCesta);

		/**
		 * Boton que lanza un panel de confirmaci�n para cerrar sesi�n. Si se acepta,
		 * lleva de vuelta al Login y si no se vuelve a la tienda.
		 */
		final JButton btnOff = new JButton("<html>Cerrar<br>sesi\u00F3n</html>");
		btnOff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirmado = JOptionPane.showConfirmDialog(btnOff, "�Desea cerrar sesi�n?", "Cierre de sesi�n",
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
		 * Bot�n que se encarga de borrar la cuenta que se est� utilizando actualmente.
		 * (No idea)
		 */
		final JButton btnNuke = new JButton("<html>Destruir<br>cuenta</html>");
		btnNuke.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean encontrado = false;
				for (int i = 0; i < almacen.ArrayListsAlmacen.cuentas.size(); i++) {
					if (LoginViewTienda.userActual.comparar(almacen.ArrayListsAlmacen.cuentas.get(i))) {
						encontrado = true;
						JOptionPane.showMessageDialog(btnNuke, "Cuenta borrada.");
						new LoginViewTienda();
						frame.dispose();
					}
				}
			}
		});
		btnNuke.setBounds(325, 124, 95, 42);
		frame.getContentPane().add(btnNuke);

	}

	public void actualizarCesta(JButton btnCesta) {
		
		btnCesta.setText("Cesta (" + sumaCestita + ")");
	}
}
