package views;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import almacen.Personas;

public class LoginViewTienda {

	
	private JFrame frame;
	private JTextField txtFUsuario;
	private JPasswordField passwordField;
	public static Personas userActual;
	// private Personas usuario;

	/**
	 * Launch the application. Aquí se abre la aplicación que se define más abajo.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginViewTienda window = new LoginViewTienda();
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
	public LoginViewTienda() {
		initialize();
		frame.revalidate();
		frame.repaint();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame. Contiene los elementos de la aplicación
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(67, 68, 55, 13);
		frame.getContentPane().add(lblUsuario);

		JLabel lblContraseña = new JLabel("Contrase\u00F1a:");
		lblContraseña.setBounds(67, 108, 85, 13);
		frame.getContentPane().add(lblContraseña);

		txtFUsuario = new JTextField();
		txtFUsuario.setBounds(180, 65, 147, 19);
		frame.getContentPane().add(txtFUsuario);
		txtFUsuario.setColumns(10);

		/**
		 * Por medio de este botón se entra en la tienda, tengo que configurarla para
		 * que compruebe que el usuario (con nombre y contraseña) coincida con alguno de
		 * los presentes en el almacen de arraylists.
		 */
		final JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = txtFUsuario.getText();
				@SuppressWarnings("deprecation")
				String password = passwordField.getText();
				userActual = new Personas(username, password);
				boolean encontrado = false;
				for (int i = 0; i < almacen.ArrayListsAlmacen.cuentas.size(); i++) {
					if (userActual.comparar(almacen.ArrayListsAlmacen.cuentas.get(i))) {
						encontrado = true;
					}
				}
				if (encontrado == true) {
					new TiendaView();
					frame.dispose();
				} else {
					JOptionPane.showMessageDialog(btnEntrar, "No existe ese usuario.");
				}
			}
		});
		btnEntrar.setBounds(67, 179, 85, 21);
		frame.getContentPane().add(btnEntrar);

		/**
		 * Esto lleva a una nueva vista de Registro que permite meter un usuario nuevo
		 * (con su usuario y contraseña).
		 */
		JButton btnRegistro = new JButton("\u00A1Registrate!");
		btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RegisterView();
				frame.dispose();
			}
		});
		btnRegistro.setBounds(207, 179, 109, 21);
		frame.getContentPane().add(btnRegistro);

		JLabel lblRegistro = new JLabel("<html>\u00BFNo tienes<br>cuenta?</html>");
		lblRegistro.setBounds(218, 148, 109, 26);
		frame.getContentPane().add(lblRegistro);

		/**
		 * Esto es especialmente útil porque automáticamente oculta lo que se escribe.
		 */
		passwordField = new JPasswordField();
		passwordField.setBounds(180, 108, 147, 19);
		frame.getContentPane().add(passwordField);

	}
}
