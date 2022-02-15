package views;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import almacen.ArrayListsAlmacen;
public class RegisterView {

	private JFrame frame;
	private JTextField txtFUser;
	private JPasswordField passwordField;
	private JPasswordField passwordConfirm;

	/**
	 * Launch the application.
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
	 * Create the application.
	 */
	public RegisterView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewUser = new JLabel("Username:");
		lblNewUser.setBounds(39, 57, 66, 13);
		frame.getContentPane().add(lblNewUser);
		
		JLabel lblContraseña = new JLabel("Introduce tu contrase\u00F1a:");
		lblContraseña.setBounds(22, 98, 113, 13);
		frame.getContentPane().add(lblContraseña);
		
		JLabel lblConfirmar = new JLabel("Confirma tu contrase\u00F1a:");
		lblConfirmar.setBounds(22, 140, 113, 13);
		frame.getContentPane().add(lblConfirmar);
		
		txtFUser = new JTextField();
		txtFUser.setBounds(187, 54, 96, 19);
		frame.getContentPane().add(txtFUser);
		txtFUser.setColumns(10);
		
		JButton btnCrear = new JButton("Crear cuenta");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtFUser != null && passwordField != null && passwordConfirm != null && passwordField == passwordConfirm) {
					
				}
			}
		});
		btnCrear.setBounds(64, 201, 96, 21);
		frame.getContentPane().add(btnCrear);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(237, 201, 96, 21);
		frame.getContentPane().add(btnLogin);
		
		JLabel lblLogin = new JLabel("\u00BFYa tienes cuenta?");
		lblLogin.setBounds(237, 178, 96, 13);
		frame.getContentPane().add(lblLogin);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(187, 95, 96, 19);
		frame.getContentPane().add(passwordField);
		
		passwordConfirm = new JPasswordField();
		passwordConfirm.setBounds(187, 137, 96, 19);
		frame.getContentPane().add(passwordConfirm);
	}
}
