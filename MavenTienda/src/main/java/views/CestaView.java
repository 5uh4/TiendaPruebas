package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class CestaView {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CestaView window = new CestaView();
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
	public CestaView() {
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
		
		JLabel lblCestaTitulo = new JLabel("Cesta de \"username\"");
		lblCestaTitulo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCestaTitulo.setBounds(10, 10, 131, 15);
		frame.getContentPane().add(lblCestaTitulo);
		
		JLabel lblProductos = new JLabel("Productos:");
		lblProductos.setBounds(25, 61, 72, 15);
		frame.getContentPane().add(lblProductos);
		
		JButton btnComprar = new JButton("Comprar");
		btnComprar.setBounds(50, 191, 85, 21);
		frame.getContentPane().add(btnComprar);
		
		JButton btnSeguir = new JButton("Seguir comprando");
		btnSeguir.setBounds(167, 191, 117, 21);
		frame.getContentPane().add(btnSeguir);
		
		JButton btnBorrar = new JButton("Borrar cesta");
		btnBorrar.setBounds(309, 191, 89, 21);
		frame.getContentPane().add(btnBorrar);
	}

}
