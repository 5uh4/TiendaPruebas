package views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import almacen.Chicles;
import almacen.Pan;
import almacen.Pipas;

public class TiendaView {

	private JFrame frame;
	public JButton btnCesta;
	private JButton btnOff;
	private JButton btnPipas;
	private JButton btnPan;
	private JButton btnChicle;
	private JLabel lblTienda;
	private JLabel lblPipas;
	private JLabel lblFlechaPipas;
	private JLabel lblPrecioPipas;
	private JLabel lblH1;
	private JLabel lblPrecio;
	private JLabel lblPan;
	private JLabel lblFlechaPan;
	private JLabel lblPrecioPan;
	private JLabel lblChicle;
	private JLabel lblFlechaChicle;
	private JLabel lblPrecioChicle;

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

		setUIComponents();
		setUIBehaviours();
	}

	private void setUIComponents() {

		// Nombre de la tienda, not important.
		lblTienda = new JLabel("Supermercado Hiasul");
		lblTienda.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTienda.setBounds(143, 15, 142, 13);
		frame.getContentPane().add(lblTienda);

		// Boton que permite añadir pipas a la cesta.
		btnPipas = new JButton("A\u00F1adir a la cesta");
		btnPipas.setBounds(265, 57, 134, 21);
		frame.getContentPane().add(btnPipas);

		// Etiqueta de pipas.
		lblPipas = new JLabel("- Pipas");
		lblPipas.setBounds(74, 61, 48, 13);
		frame.getContentPane().add(lblPipas);

		// Etiqueta de flecha para las pipas.
		lblFlechaPipas = new JLabel("----->");
		lblFlechaPipas.setBounds(132, 61, 41, 13);
		frame.getContentPane().add(lblFlechaPipas);

		// Etiqueta con el precio de las pipas.
		lblPrecioPipas = new JLabel("3,50\u20AC");
		lblPrecioPipas.setBounds(183, 61, 29, 13);
		frame.getContentPane().add(lblPrecioPipas);

		// Etiqueta con la palabra Producto, que va por encima de todo.
		lblH1 = new JLabel("Producto");
		lblH1.setBounds(77, 38, 45, 13);
		frame.getContentPane().add(lblH1);

		// Etiqueta con la palabra Precio, que va por encima de todo.
		lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(177, 38, 45, 13);
		frame.getContentPane().add(lblPrecio);

		// Etiqueta de pan.
		lblPan = new JLabel("- Pan");
		lblPan.setBounds(77, 102, 45, 13);
		frame.getContentPane().add(lblPan);

		// Etiqueta con la flecha del pan
		lblFlechaPan = new JLabel("----->");
		lblFlechaPan.setBounds(132, 102, 41, 13);
		frame.getContentPane().add(lblFlechaPan);

		// Etiqueta con el precio del pan.
		lblPrecioPan = new JLabel("0,50\u20AC");
		lblPrecioPan.setBounds(183, 102, 29, 13);
		frame.getContentPane().add(lblPrecioPan);

		// Boton para añadir pan a la cesta.
		btnPan = new JButton("A\u00F1adir a la cesta");
		btnPan.setBounds(265, 98, 134, 21);
		frame.getContentPane().add(btnPan);

		// Etiqueta con chicles
		lblChicle = new JLabel("- Chicles");
		lblChicle.setBounds(64, 151, 58, 13);
		frame.getContentPane().add(lblChicle);

		// Etiqueta con la flecha de los chicles.
		lblFlechaChicle = new JLabel("----->");
		lblFlechaChicle.setBounds(132, 151, 41, 13);
		frame.getContentPane().add(lblFlechaChicle);

		// Etiqueta con el precio de los chicles.
		lblPrecioChicle = new JLabel("0,05\u20AC");
		lblPrecioChicle.setBounds(183, 151, 29, 13);
		frame.getContentPane().add(lblPrecioChicle);

		// Botón para añadir chicles a la cesta.
		btnChicle = new JButton("A\u00F1adir a la cesta");
		btnChicle.setBounds(265, 147, 134, 21);
		frame.getContentPane().add(btnChicle);

		/**
		 * Boton para ver la cesta. Incluye la suma total de la cesta por medio de una
		 * funcion que la actualiza automáticamente.
		 */
		btnCesta = new JButton("Cesta (" + sumaCestita + ")");
		btnCesta.setBounds(67, 196, 107, 21);
		frame.getContentPane().add(btnCesta);

		/**
		 * Boton que lanza un panel de confirmación para cerrar sesión. Si se acepta,
		 * lleva de vuelta al Login y si no se vuelve a la tienda.
		 */
		btnOff = new JButton("Cerrar sesi\u00F3n");
		btnOff.setBounds(231, 196, 142, 43);
		frame.getContentPane().add(btnOff);

	}

	private void setUIBehaviours() {
		btnPipas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pipas pipas = null;
				almacen.ArrayListsAlmacen.listaPipas.add(pipas);
				sumaCestita++;
				actualizarCesta(btnCesta);
			}
		});
		btnPan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pan panes = null;
				almacen.ArrayListsAlmacen.listaPan.add(panes);
				sumaCestita++;
				actualizarCesta(btnCesta);
			}
		});
		btnChicle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Chicles chicle = null;
				almacen.ArrayListsAlmacen.listaChicles.add(chicle);
				sumaCestita++;
				actualizarCesta(btnCesta);
			}
		});
		btnCesta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CestaView(frame);
				frame.setVisible(false);
			}
		});
		btnOff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirmado = JOptionPane.showConfirmDialog(btnOff, "¿Desea cerrar sesión?", "Cierre de sesión",
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
	}

	public void actualizarCesta(JButton btnCesta) {
		btnCesta.setText("Cesta (" + sumaCestita + ")");
	}
}
