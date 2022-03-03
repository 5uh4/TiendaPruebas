package views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
	private JButton btnRegistro;
	private JButton btnEntrar;
	// private Personas usuario;

	/**
	 * Launch the application.
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
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 204, 153));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		setUIComponents();
		setUIBehaviour();
	}
	/**
	 * Sets all elements with their properties.
	 */
	private void setUIComponents() {
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
		btnEntrar = new JButton("Entrar");
		btnEntrar.setBounds(67, 179, 85, 21);
		frame.getContentPane().add(btnEntrar);

		/**
		 * Esto lleva a una nueva vista de Registro que permite meter un usuario nuevo
		 * (con su usuario y contraseña).
		 */
		btnRegistro = new JButton("\u00A1Registrate!");
		btnRegistro.setBounds(207, 179, 109, 21);
		frame.getContentPane().add(btnRegistro);

		JLabel lblRegistro = new JLabel("<html>\u00BFNo tienes<br>cuenta?</html>");
		lblRegistro.setBounds(218, 148, 109, 26);
		frame.getContentPane().add(lblRegistro);

		passwordField = new JPasswordField();
		passwordField.setBounds(180, 108, 147, 19);
		frame.getContentPane().add(passwordField);
	}
	
	public void setUIBehaviour() {
		btnEntrar.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					login();
				}
			}
		});
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login();
			}
		});
		btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RegisterView();
				frame.dispose();
			}
		});
		passwordField.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					login();
				}
			}
		});
	}

	@SuppressWarnings("deprecation")
	public void login() {
		String username = txtFUsuario.getText();
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
		} else if (txtFUsuario.getText().isBlank() || passwordField.getText().isBlank()) {
			JOptionPane.showMessageDialog(btnEntrar, "Rellena los campos.");
		} else {
			JOptionPane.showMessageDialog(btnEntrar, "No existe ese usuario o la contraseña no es correcta.");
		}
	}
}
