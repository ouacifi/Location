import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Locataire {

	private JFrame frame;
	private JTextField rechercherLocatairetextField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Locataire window = new Locataire();
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
	public Locataire() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setLayout(null);
		
		JButton btnAfficherTous = new JButton("Afficher tous");
		btnAfficherTous.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnAfficherTous.setBounds(75, 454, 150, 70);
		frame.getContentPane().add(btnAfficherTous);
		
		JButton btnRechercherLocataire = new JButton("Rechercher Locataire");
		btnRechercherLocataire.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnRechercherLocataire.setBounds(299, 454, 180, 70);
		frame.getContentPane().add(btnRechercherLocataire);
		
		rechercherLocatairetextField = new JTextField();
		rechercherLocatairetextField.setColumns(10);
		rechercherLocatairetextField.setBounds(540, 468, 150, 40);
		frame.getContentPane().add(rechercherLocatairetextField);
		
		JButton btnAjouterLocataire = new JButton("Ajouter Locataire");
		btnAjouterLocataire.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnAjouterLocataire.setBounds(761, 32, 150, 70);
		frame.getContentPane().add(btnAjouterLocataire);
		
		JButton btnModifierLocataire = new JButton("Modifier Locataire");
		btnModifierLocataire.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnModifierLocataire.setBounds(761, 152, 150, 70);
		frame.getContentPane().add(btnModifierLocataire);
		
		JButton btnSupprimerLocataire = new JButton("Supprimer Locataire");
		btnSupprimerLocataire.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnSupprimerLocataire.setBounds(761, 265, 156, 70);
		frame.getContentPane().add(btnSupprimerLocataire);
		
		JButton quitterBtn = new JButton("Quitter");
		quitterBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		quitterBtn.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		quitterBtn.setBounds(788, 375, 89, 50);
		frame.getContentPane().add(quitterBtn);
		
		table = new JTable();
		table.setBounds(23, 25, 700, 400);
		frame.getContentPane().add(table);
		frame.setBounds(100, 100, 950, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
