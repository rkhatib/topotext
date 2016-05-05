package lb.edu.aub.cmps;

import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.TextField;
import java.io.FileNotFoundException;

import lb.edu.aub.cmps.importing.ImportFromCSV;
import lb.edu.aub.cmps.importing.ImportFromCSVI;

public class ImportFrame {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ImportFrame window = new ImportFrame();
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
	public ImportFrame() {
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
		final TextField fileName = new TextField();
		fileName.setEnabled(false);
		fileName.setEditable(false);
		fileName.setBounds(119, 10, 195, 26);
		frame.getContentPane().add(fileName);
		
		final Button import_button = new Button("Import");
		import_button.setEnabled(false);
		import_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ImportFromCSVI import_from_csv = new ImportFromCSV();
				try {
					import_from_csv.importGeoLocations(fileName.getText());
				} catch (FileNotFoundException e) {
					
				}
			}
		});
		
		
		JLabel lblChooseACsv = new JLabel("Choose a CSV file");
		lblChooseACsv.setBounds(10, 11, 98, 25);
		frame.getContentPane().add(lblChooseACsv);
		
		Button button = new Button("Browse");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser chooser = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter(
						"CSV File", "csv");
				chooser.setFileFilter(filter);
				chooser.addChoosableFileFilter(filter);
				int returnVal = chooser.showOpenDialog(null);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					import_button.setEnabled(true);
					fileName.setText(chooser.getSelectedFile().getPath());
				}
			}
		});
		button.setBounds(339, 11, 70, 22);
		frame.getContentPane().add(button);
		
		
		import_button.setBounds(185, 55, 90, 45);
		frame.getContentPane().add(import_button);
		
		
	}
}
