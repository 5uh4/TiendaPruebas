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
	private JLabel lblCantidadChicles;
	private JLabel lblCantidadPan;
	private JLabel lblCantidadPipas;
	private JButton btnBorrarPipas;
	private JButton btnComprar;
	private JButton btnSeguir;
	private JButton btnBorrar;
	private JButton btnBorrarPan;
	private JButton btnBorrarChicles;
	private double cantidadPan = almacen.ArrayListsAlmacen.listaPan.size();
	private double cantidadChicles = almacen.ArrayListsAlmacen.listaChicles.size();
	private double cantidadPipas = almacen.ArrayListsAlmacen.listaPipas.size();

	/**
	 * Create the application.
	 */
	public CestaView() {
		initialize();
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

		setUIComponents();
		setUIBehaviour();
	}

	/**
	 * Sets the components with their respective properties.
	 */
	private void setUIComponents() {

		JLabel lblCestaTitulo = new JLabel("Cesta");
		lblCestaTitulo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCestaTitulo.setBounds(154, 10, 131, 15);
		frame.getContentPane().add(lblCestaTitulo);

		JLabel lblProductos = new JLabel("Productos:");
		lblProductos.setBounds(25, 61, 72, 15);
		frame.getContentPane().add(lblProductos);

		btnComprar = new JButton("<html>Hacer<br>compra</html>");
		btnComprar.setBounds(25, 191, 85, 35);
		frame.getContentPane().add(btnComprar);

		btnSeguir = new JButton("<html>Seguir<br>comprando</html>");
		btnSeguir.setBounds(154, 191, 120, 35);
		frame.getContentPane().add(btnSeguir);

		// Borrará el contenido de todos los arraylists de productos.
		btnBorrar = new JButton("<html>Borrar<br>cesta</html>");
		btnBorrar.setBounds(317, 119, 85, 35);
		frame.getContentPane().add(btnBorrar);

		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setBounds(128, 62, 70, 15);
		frame.getContentPane().add(lblCantidad);

		JLabel lblBorrado = new JLabel("<html>Borrar un<br>producto:</html>");
		lblBorrado.setBounds(208, 50, 72, 26);
		frame.getContentPane().add(lblBorrado);

		JLabel lblPanes = new JLabel("Panes");
		lblPanes.setBounds(25, 86, 72, 26);
		frame.getContentPane().add(lblPanes);

		// Updates with the amount of "Pan".
		lblCantidadPan = new JLabel();
		lblCantidadPan.setText("" + cantidadPan);
		lblCantidadPan.setBounds(128, 93, 70, 13);
		frame.getContentPane().add(lblCantidadPan);

		JLabel lblChicles = new JLabel("Chicles");
		lblChicles.setBounds(25, 122, 72, 15);
		frame.getContentPane().add(lblChicles);

		// Label that updates with the amount of "Chicles"
		lblCantidadChicles = new JLabel();
		lblCantidadChicles.setText("" + cantidadChicles);
		lblCantidadChicles.setBounds(128, 123, 70, 13);
		frame.getContentPane().add(lblCantidadChicles);

		JLabel lblPipas = new JLabel("Pipas");
		lblPipas.setBounds(25, 152, 45, 13);
		frame.getContentPane().add(lblPipas);

		// Label that updates with the amount of "Pipas".
		lblCantidadPipas = new JLabel();
		lblCantidadPipas.setText("" + cantidadPipas);
		lblCantidadPipas.setBounds(128, 152, 70, 13);
		frame.getContentPane().add(lblCantidadPipas);

		btnBorrarPan = new JButton("Borrar");
		btnBorrarPan.setBounds(208, 89, 79, 21);
		frame.getContentPane().add(btnBorrarPan);

		btnBorrarChicles = new JButton("Borrar");
		btnBorrarChicles.setBounds(208, 119, 79, 21);
		frame.getContentPane().add(btnBorrarChicles);

		btnBorrarPipas = new JButton("Borrar");
		btnBorrarPipas.setBounds(208, 148, 79, 21);
		frame.getContentPane().add(btnBorrarPipas);
	}

	/**
	 * Sets the behaviour each component must follow.
	 */
	public void setUIBehaviour() {
		btnComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comprar();
			}
		});
		btnSeguir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seguir();
			}
		});
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				borradoGeneral();
			}
		});
		btnBorrarPan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				borradoPan();
			}
		});
		btnBorrarChicles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				borradoChicle();

			}
		});
		btnBorrarPipas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				borradoPipa();
			}

		});
	}

	/**
	 * Deletes the last item of type "Pipas" in the array list if it is not empty.
	 * 
	 */

	public void borradoPipa() {
		if (!almacen.ArrayListsAlmacen.listaPipas.isEmpty()) {
			almacen.ArrayListsAlmacen.listaPipas.remove(almacen.ArrayListsAlmacen.listaPipas.size() - 1);
			lblCantidadPipas.setText("" + almacen.ArrayListsAlmacen.listaPipas.size());
		} else {
			JOptionPane.showMessageDialog(btnBorrarPipas, "No has añadido este producto.");
		}
	}

	/**
	 * Deletes the last item of type "Pan" in the array list if it is not empty.
	 */
	public void borradoPan() {
		if (!almacen.ArrayListsAlmacen.listaPan.isEmpty()) {
			almacen.ArrayListsAlmacen.listaPan.remove(almacen.ArrayListsAlmacen.listaPan.size() - 1);
			lblCantidadPan.setText("" + almacen.ArrayListsAlmacen.listaPan.size());
		} else {
			JOptionPane.showMessageDialog(btnBorrarPan, "No has añadido este producto.");
		}
	}
	/**
	 * Deletes the last item of type "Chicle" in the array list if it is not empty.
	 */
	public void borradoChicle() {
		if (!almacen.ArrayListsAlmacen.listaChicles.isEmpty()) {
			almacen.ArrayListsAlmacen.listaChicles.remove(almacen.ArrayListsAlmacen.listaChicles.size() - 1);
			lblCantidadChicles.setText("" + almacen.ArrayListsAlmacen.listaChicles.size());
		} else {
			JOptionPane.showMessageDialog(btnBorrarChicles, "No has añadido este producto.");
		}
	}

	/**
	 * Deletes every element in every arraylist, thus deleting the entire "Cesta".
	 */
	public void borradoGeneral() {
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

	/**
	 * If confirmed returns the user to the view of the shop. 
	 */
	public void seguir() {
		int confirmadoSeguir = JOptionPane.showConfirmDialog(btnSeguir, "Volver a tienda.", "Confirmación de compra",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (JOptionPane.OK_OPTION == confirmadoSeguir) {
			frame.dispose();
			new TiendaView();
			JOptionPane.showMessageDialog(btnSeguir, "Volviendo a la tienda.");
		} else {
			JOptionPane.showMessageDialog(btnSeguir, "Volviendo a la cesta.");
		}
	}

	/**
	 * If confirmed removes all items and returns the user to the login view.
	 */
	public void comprar() {
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

}
