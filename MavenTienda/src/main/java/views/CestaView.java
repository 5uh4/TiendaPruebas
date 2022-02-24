package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class CestaView {

	private JFrame frame;
	private JFrame padre;
	private JLabel lblCantidadChicles;
	private JLabel lblCantidadPan;
	private JLabel lblCantidadPipas;
	private JButton btnCesta;

	/**
	 * Create the application.
	 */
	public CestaView(JFrame padre) {
		initialize();
		this.padre = padre;
		frame.revalidate();
		frame.repaint();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(106, 90, 205));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblCestaTitulo = new JLabel("Cesta");
		lblCestaTitulo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCestaTitulo.setBounds(154, 10, 131, 15);
		frame.getContentPane().add(lblCestaTitulo);

		JLabel lblProductos = new JLabel("Productos:");
		lblProductos.setBounds(25, 61, 72, 15);
		frame.getContentPane().add(lblProductos);

		final JButton btnComprar = new JButton("<html>Hacer<br>compra.</html>");
		btnComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirmadoCompra = JOptionPane.showConfirmDialog(btnComprar, "Confirme su compra.",
						"Confirmación de compra", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (JOptionPane.OK_OPTION == confirmadoCompra) {
					almacen.ArrayListsAlmacen.listaChicles.clear();
					almacen.ArrayListsAlmacen.listaPan.clear();
					almacen.ArrayListsAlmacen.listaPipas.clear();
					new LoginViewTienda();
					frame.dispose();
					JOptionPane.showMessageDialog(btnComprar, "Compra realizada.");
				} else {
					JOptionPane.showMessageDialog(btnComprar, "Volviendo a la cesta.");
				}
			}
		});
		btnComprar.setBounds(50, 191, 85, 35);
		frame.getContentPane().add(btnComprar);

		final JButton btnSeguir = new JButton("<html>Seguir<br>comprando</html>");
		btnSeguir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirmadoSeguir = JOptionPane.showConfirmDialog(btnSeguir, "Volver a tienda.",
						"Confirmación de compra", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (JOptionPane.OK_OPTION == confirmadoSeguir) {
					frame.setVisible(false);
					padre.repaint();
					padre.repaint(181, 147, 134, 21);
					padre.setVisible(true);
					JOptionPane.showMessageDialog(btnSeguir, "Volviendo a la tienda.");
				} else {
					JOptionPane.showMessageDialog(btnSeguir, "Volviendo a la cesta.");
				}
			}
		});
		btnSeguir.setBounds(167, 191, 120, 35);
		frame.getContentPane().add(btnSeguir);

		// Borrará el contenido de todos los arraylists de productos.
		final JButton btnBorrar = new JButton("<html>Borrar<br>cesta</html>");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirmadoBorrar = JOptionPane.showConfirmDialog(btnBorrar, "¿Borrar cesta?", "Borrar Cesta",
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (JOptionPane.OK_OPTION == confirmadoBorrar) {
					almacen.ArrayListsAlmacen.listaChicles.clear();
					almacen.ArrayListsAlmacen.listaPan.clear();
					almacen.ArrayListsAlmacen.listaPipas.clear();
					lblCantidadPan.setText("" + almacen.ArrayListsAlmacen.listaPan.size());
					lblCantidadPipas.setText("" + almacen.ArrayListsAlmacen.listaPipas.size());
					lblCantidadChicles.setText("" + almacen.ArrayListsAlmacen.listaChicles.size());
					
				} else {
					JOptionPane.showMessageDialog(btnBorrar, "Volviendo a cesta");
				}
			}
		});
		btnBorrar.setBounds(309, 191, 85, 35);
		frame.getContentPane().add(btnBorrar);

		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setBounds(128, 62, 70, 13);
		frame.getContentPane().add(lblCantidad);

		// Etiqueta para el borrado específico de un elemento de un arraylist.
		JLabel lblBorrado = new JLabel("<html>Borrar un<br>producto:</html>");
		lblBorrado.setBounds(208, 57, 72, 26);
		frame.getContentPane().add(lblBorrado);

		JLabel lblPanes = new JLabel("Panes");
		lblPanes.setBounds(25, 86, 72, 26);
		frame.getContentPane().add(lblPanes);

		// Se actualiza para mostrar la cantidad de panes en cesta.
		lblCantidadPan = new JLabel();
		lblCantidadPan.setText("" + almacen.ArrayListsAlmacen.listaPan.size());
		lblCantidadPan.setBounds(128, 93, 45, 13);
		frame.getContentPane().add(lblCantidadPan);

		JLabel lblChicles = new JLabel("Chicles");
		lblChicles.setBounds(25, 122, 72, 15);
		frame.getContentPane().add(lblChicles);

		// Se actualiza para mostrar la cantidad de chicles en la cesta.
		lblCantidadChicles = new JLabel();
		lblCantidadChicles.setText("" + almacen.ArrayListsAlmacen.listaChicles.size());
		lblCantidadChicles.setBounds(128, 123, 45, 13);
		frame.getContentPane().add(lblCantidadChicles);

		JLabel lblPipas = new JLabel("Pipas");
		lblPipas.setBounds(25, 152, 45, 13);
		frame.getContentPane().add(lblPipas);

		// Se actualiza para mostrar la cantidad de pipas en la cesta.
		lblCantidadPipas = new JLabel();
		lblCantidadPipas.setText("" + almacen.ArrayListsAlmacen.listaPipas.size());
		lblCantidadPipas.setBounds(128, 152, 45, 13);
		frame.getContentPane().add(lblCantidadPipas);

		final JButton btnBorrarPan = new JButton("Borrar");
		btnBorrarPan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (almacen.ArrayListsAlmacen.listaPan.size() != 0) {
					almacen.ArrayListsAlmacen.listaPan.remove(almacen.ArrayListsAlmacen.listaPan.size() - 1);
					lblCantidadPan.setText("" + almacen.ArrayListsAlmacen.listaPan.size());
					
				} else {
					JOptionPane.showMessageDialog(btnBorrarPan, "No has añadido este producto.");
				}
			}
		});
		btnBorrarPan.setBounds(208, 89, 79, 21);
		frame.getContentPane().add(btnBorrarPan);

		final JButton btnBorrarChicles = new JButton("Borrar");
		btnBorrarChicles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (almacen.ArrayListsAlmacen.listaChicles.size() != 0) {
					almacen.ArrayListsAlmacen.listaChicles.remove(almacen.ArrayListsAlmacen.listaChicles.size() - 1);
					lblCantidadChicles.setText("" + almacen.ArrayListsAlmacen.listaChicles.size());
				
				} else {
					JOptionPane.showMessageDialog(btnBorrarChicles, "No has añadido este producto.");
				}
			}
		});
		btnBorrarChicles.setBounds(208, 119, 79, 21);
		frame.getContentPane().add(btnBorrarChicles);

		final JButton btnBorrarPipas = new JButton("Borrar");
		btnBorrarPipas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (almacen.ArrayListsAlmacen.listaPipas.size() != 0) {
					almacen.ArrayListsAlmacen.listaPipas.remove(almacen.ArrayListsAlmacen.listaPipas.size() - 1);
					lblCantidadPipas.setText("" + almacen.ArrayListsAlmacen.listaPipas.size());
				
				} else {
					JOptionPane.showMessageDialog(btnBorrarPipas, "No has añadido este producto.");
				}
			}
		});
		btnBorrarPipas.setBounds(208, 148, 79, 21);
		frame.getContentPane().add(btnBorrarPipas);
	}
}
