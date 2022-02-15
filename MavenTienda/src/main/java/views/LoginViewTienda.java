package views;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import almacen.Personas;

public class LoginViewTienda {

	private JFrame frame;
	private JTextField txtFUsuario;
	private JPasswordField passwordField;
	private Personas usuario;

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
		frame.revalidate();
		frame.repaint();
	}

	/**
	 * Initialize the contents of the frame.
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
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TiendaView();
			}
		});
		btnEntrar.setBounds(67, 179, 85, 21);
		frame.getContentPane().add(btnEntrar);
		
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
		
		passwordField = new JPasswordField();
		passwordField.setBounds(180, 108, 147, 19);
		frame.getContentPane().add(passwordField);
	}
}
