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
	 * Launch the application.
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
	 * Create the application.
	 */
	public TiendaView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 460, 309);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblTienda = new JLabel("Supermercado Hiasul");
		lblTienda.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTienda.setBounds(10, 10, 142, 13);
		frame.getContentPane().add(lblTienda);

		JButton btnPipas = new JButton("A\u00F1adir a la cesta");
		btnPipas.setBounds(181, 57, 114, 21);
		frame.getContentPane().add(btnPipas);

		JLabel lblPipas = new JLabel("- Pipas");
		lblPipas.setBounds(54, 61, 45, 13);
		frame.getContentPane().add(lblPipas);

		JLabel lblFlechaPipas = new JLabel("-->");
		lblFlechaPipas.setBounds(109, 61, 20, 13);
		frame.getContentPane().add(lblFlechaPipas);

		JLabel lblPrecioPipas = new JLabel("3,50\u20AC");
		lblPrecioPipas.setBounds(142, 61, 29, 13);
		frame.getContentPane().add(lblPrecioPipas);

		JLabel lblH1 = new JLabel("Producto");
		lblH1.setBounds(41, 38, 45, 13);
		frame.getContentPane().add(lblH1);

		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(130, 38, 45, 13);
		frame.getContentPane().add(lblPrecio);

		JLabel lblPan = new JLabel("- Pan");
		lblPan.setBounds(54, 102, 45, 13);
		frame.getContentPane().add(lblPan);

		JLabel lblFlechaPan = new JLabel("-->");
		lblFlechaPan.setBounds(109, 102, 20, 13);
		frame.getContentPane().add(lblFlechaPan);

		JLabel lblPrecioPan = new JLabel("0,50\u20AC");
		lblPrecioPan.setBounds(142, 102, 29, 13);
		frame.getContentPane().add(lblPrecioPan);

		JButton btnPipas_1 = new JButton("A\u00F1adir a la cesta");
		btnPipas_1.setBounds(181, 98, 114, 21);
		frame.getContentPane().add(btnPipas_1);

		JLabel lblChicle = new JLabel("- Chicles");
		lblChicle.setBounds(54, 151, 45, 13);
		frame.getContentPane().add(lblChicle);

		JLabel lblFlechaChicle = new JLabel("-->");
		lblFlechaChicle.setBounds(109, 151, 20, 13);
		frame.getContentPane().add(lblFlechaChicle);

		JLabel lblPrecioChicle = new JLabel("0,05\u20AC");
		lblPrecioChicle.setBounds(142, 151, 29, 13);
		frame.getContentPane().add(lblPrecioChicle);

		JButton btnChicle = new JButton("A\u00F1adir a la cesta");
		btnChicle.setBounds(181, 147, 114, 21);
		frame.getContentPane().add(btnChicle);

		JButton btnCesta = new JButton("Cesta");
		btnCesta.setBounds(44, 212, 85, 21);
		frame.getContentPane().add(btnCesta);

		final JButton btnOff = new JButton("Cerrar sesi\u00F3n");
		btnOff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirmado = JOptionPane.showConfirmDialog(btnOff, "¿Desea cerrar sesión", "Cierre de sesión",
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (JOptionPane.OK_OPTION == confirmado) {
					System.out.println("Saliendo.");
					new LoginViewTienda();
				}	else {
					System.out.println("Volviendo");
				}
			}
		});
		btnOff.setBounds(325, 57, 95, 44);
		frame.getContentPane().add(btnOff);

		JButton btnNuke = new JButton("<html>Destruir<br>cuenta</html>");
		btnNuke.setBounds(325, 124, 95, 42);
		frame.getContentPane().add(btnNuke);
	}
}
