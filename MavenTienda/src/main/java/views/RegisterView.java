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

public class RegisterView {

	private JFrame frame;
	private JTextField txtFUser;
	private JPasswordField passwordField;
	private JPasswordField passwordConfirm;

	/**
	 * Launch the application. Lanza la app
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterView window = new RegisterView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application. Crea la app
	 */
	public RegisterView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame. Contiene todos los elementos del app.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		// Etiqueta con el usuario.
		JLabel lblNewUser = new JLabel("Username:");
		lblNewUser.setBounds(39, 57, 66, 13);
		frame.getContentPane().add(lblNewUser);

		// Etiqueta que solicita una contraseña
		JLabel lblContraseña = new JLabel("Introduce tu contrase\u00F1a:");
		lblContraseña.setBounds(22, 98, 113, 13);
		frame.getContentPane().add(lblContraseña);

		// Etiqueta para confirmar la contraseña y asegurar que es correcta.
		JLabel lblConfirmar = new JLabel("Confirma tu contrase\u00F1a:");
		lblConfirmar.setBounds(22, 140, 113, 13);
		frame.getContentPane().add(lblConfirmar);

		// Aquí se escribe el usuario
		txtFUser = new JTextField();
		txtFUser.setBounds(187, 54, 96, 19);
		frame.getContentPane().add(txtFUser);
		txtFUser.setColumns(10);

		/**
		 * Aquí se crea el usuario si, y solo si, todos los parametros son correctos, es
		 * decir, si se ha escrito algo donde hay que escribir el usuario, si se ha
		 * puesto algo donde va la contraseña y si el espacio de la contraseña y el de
		 * confirmar contraseña coinciden.
		 */
		final JButton btnCrear = new JButton("Crear cuenta");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtFUser != null && passwordField != null && passwordConfirm != null
						&& passwordField == passwordConfirm) {
					new TiendaView();
					//add usuario al arraylist que hay en el almacen.
				}
				else {
					JOptionPane.showMessageDialog(btnCrear, "Comprueba que los elementos son correctos.");
				}
			}
		});
		btnCrear.setBounds(64, 201, 96, 21);
		frame.getContentPane().add(btnCrear);
		
		JLabel lblLogin = new JLabel("\u00BFYa tienes cuenta?");
		lblLogin.setBounds(237, 178, 96, 13);
		frame.getContentPane().add(lblLogin);
		//Boton que lleva de vuelta al Login.
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LoginViewTienda();
			}
		});
		btnLogin.setBounds(237, 201, 96, 21);
		frame.getContentPane().add(btnLogin);

		passwordField = new JPasswordField();
		passwordField.setBounds(187, 95, 96, 19);
		frame.getContentPane().add(passwordField);

		passwordConfirm = new JPasswordField();
		passwordConfirm.setBounds(187, 137, 96, 19);
		frame.getContentPane().add(passwordConfirm);
	}
}
