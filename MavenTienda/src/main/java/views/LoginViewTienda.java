package views;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginViewTienda {

	private JFrame frame;
	private JTextField txtFUsuario;
	private JPasswordField passwordField;
	//private Personas usuario;

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
		lblUsuario.setBounds(77, 68, 45, 13);
		frame.getContentPane().add(lblUsuario);

		JLabel lblContraseña = new JLabel("Contrase\u00F1a:");
		lblContraseña.setBounds(67, 108, 63, 13);
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
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TiendaView();
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
			}
		});
		btnRegistro.setBounds(207, 179, 109, 21);
		frame.getContentPane().add(btnRegistro);

		JLabel lblRegistro = new JLabel("\u00BFNo tienes cuenta?");
		lblRegistro.setBounds(218, 161, 109, 13);
		frame.getContentPane().add(lblRegistro);

		/**
		 * Esto es especialmente útil porque automáticamente oculta lo que se escribe.
		 */
		passwordField = new JPasswordField();
		passwordField.setBounds(180, 108, 147, 19);
		frame.getContentPane().add(passwordField);
	}
}
