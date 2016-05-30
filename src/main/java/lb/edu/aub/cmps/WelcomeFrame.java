package lb.edu.aub.cmps;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class WelcomeFrame {

	private JFrame frmWelcome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WelcomeFrame window = new WelcomeFrame();
					window.frmWelcome.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WelcomeFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmWelcome = new JFrame();
		frmWelcome.setFont(new Font("Adobe Caslon Pro", Font.PLAIN, 20));
		frmWelcome.setTitle("Welcome!");
		frmWelcome.getContentPane().setBackground(new Color(176, 224, 230));
		frmWelcome.getContentPane().setLayout(null);
		
		JLabel lblWelcomeToThe = new JLabel("TopoText 2.0");
		lblWelcomeToThe.setForeground(new Color(51, 51, 102));
		lblWelcomeToThe.setFont(new Font("Adobe Caslon Pro Bold", Font.BOLD, 40));
		lblWelcomeToThe.setBounds(468, 182, 251, 83);
		frmWelcome.getContentPane().add(lblWelcomeToThe);
		
		JButton btnStartUp = new JButton("Start Up");
		btnStartUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmWelcome.setVisible(false);
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Frame frame = new Frame();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnStartUp.setForeground(new Color(51, 51, 102));
		btnStartUp.setFont(new Font("Franklin Gothic Medium Cond", Font.PLAIN, 18));
		btnStartUp.setBounds(519, 297, 150, 35);
		frmWelcome.getContentPane().add(btnStartUp);
		frmWelcome.setBounds(100, 100, 1200, 475);
		frmWelcome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
