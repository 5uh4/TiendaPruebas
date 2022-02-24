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
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
		frame.revalidate();
		frame.repaint();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame. Contiene todos los elementos del app.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(204, 102, 51));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		// Etiqueta con el usuario.
		JLabel lblNewUser = new JLabel("Username:");
		lblNewUser.setBounds(39, 57, 66, 13);
		frame.getContentPane().add(lblNewUser);

		// Etiqueta que solicita una contrase�a
		JLabel lblContrase�a = new JLabel("Introduce tu contrase\u00F1a:");
		lblContrase�a.setBounds(22, 98, 138, 13);
		frame.getContentPane().add(lblContrase�a);

		// Etiqueta para confirmar la contrase�a y asegurar que es correcta.
		JLabel lblConfirmar = new JLabel("Confirma tu contrase\u00F1a:");
		lblConfirmar.setBounds(22, 140, 138, 13);
		frame.getContentPane().add(lblConfirmar);

		// Aqu� se escribe el usuario
		txtFUser = new JTextField();
		txtFUser.setBounds(187, 54, 96, 19);
		frame.getContentPane().add(txtFUser);
		txtFUser.setColumns(10);

		/**
		 * Aqu� se crea el usuario si, y solo si, todos los parametros son correctos, es
		 * decir, si se ha escrito algo donde hay que escribir el usuario, si se ha
		 * puesto algo donde va la contrase�a y si el espacio de la contrase�a y el de
		 * confirmar contrase�a coinciden.
		 */
		final JButton btnCrear = new JButton("Crear cuenta");
		btnCrear.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					if ((txtFUser.getText() != null) && (passwordField.getText() != null)
							&& (passwordConfirm.getText() != null)
							&& passwordField.getText().equals(passwordConfirm.getText())) {
						new TiendaView();
						frame.dispose();
						String nombreUsuario = txtFUser.getText();
						String contrase�a = passwordField.getText();
						Personas usuarioActual = new Personas(nombreUsuario, contrase�a);
						almacen.ArrayListsAlmacen.cuentas.add(usuarioActual);
						for(int i = 0; i < almacen.ArrayListsAlmacen.cuentas.size(); i++) {
							System.out.println(almacen.ArrayListsAlmacen.cuentas.get(i).getUsername());
							System.out.println(almacen.ArrayListsAlmacen.cuentas.get(i).getPassword()); }
						// add usuario al arraylist que hay en el almacen.}
					} else {
						JOptionPane.showMessageDialog(btnCrear, "Comprueba que los elementos son correctos.");
					}
				}
			}
		});
		btnCrear.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if ((txtFUser.getText() != null) && (passwordField.getText() != null)
						&& (passwordConfirm.getText() != null)
						&& passwordField.getText().equals(passwordConfirm.getText())) {
					new TiendaView();
					frame.dispose();
					String nombreUsuario = txtFUser.getText();
					String contrase�a = passwordField.getText();
					Personas usuarioActual = new Personas(nombreUsuario, contrase�a);
					almacen.ArrayListsAlmacen.cuentas.add(usuarioActual);
					for(int i = 0; i < almacen.ArrayListsAlmacen.cuentas.size(); i++) {
						System.out.println(almacen.ArrayListsAlmacen.cuentas.get(i).getUsername());
						System.out.println(almacen.ArrayListsAlmacen.cuentas.get(i).getPassword()); }
					// add usuario al arraylist que hay en el almacen.}
				} else {
					JOptionPane.showMessageDialog(btnCrear, "Comprueba que los elementos son correctos.");
				}
			}
		});
		btnCrear.setBounds(55, 201, 114, 21);
		frame.getContentPane().add(btnCrear);

		JLabel lblLogin = new JLabel("<html>\u00BFYa tienes<br>cuenta?</html>");
		lblLogin.setBounds(237, 166, 96, 25);
		frame.getContentPane().add(lblLogin);
		// Boton que lleva de vuelta al Login.
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LoginViewTienda();
				frame.dispose();
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
