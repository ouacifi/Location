import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LocataireForm {

	private JFrame frame;
	private JTextField nomTextField;
	private JTextField PrénomTextField;
	private JTextField cinTextField;
	private JTextField voitureTextField;
	private JTextField nbrDeJourTextField;
	private JTextField dateLocationTextField;
	private JTextField dateDeretourTextField;
	private JTextField prixTextField;
	private JTextField totalTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LocataireForm window = new LocataireForm();
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
	public LocataireForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		frame.setBounds(100, 100, 950, 600);

		
		JLabel lblNewLabel = new JLabel("Nom");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(31, 24, 101, 28);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblPrnom = new JLabel("Prénom");
		lblPrnom.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPrnom.setBounds(160, 24, 109, 28);
		frame.getContentPane().add(lblPrnom);
		
		JLabel lblCin = new JLabel("CIN");
		lblCin.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCin.setBounds(292, 24, 123, 28);
		frame.getContentPane().add(lblCin);
		
		JLabel lblVoiture = new JLabel("Voiture");
		lblVoiture.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblVoiture.setBounds(441, 24, 123, 28);
		frame.getContentPane().add(lblVoiture);
		
		JLabel lblNombreDeJour = new JLabel("Nombre de jour");
		lblNombreDeJour.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNombreDeJour.setBounds(607, 24, 117, 28);
		frame.getContentPane().add(lblNombreDeJour);
		
		JLabel lblDateLocation = new JLabel("Date Location");
		lblDateLocation.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDateLocation.setBounds(31, 145, 101, 28);
		frame.getContentPane().add(lblDateLocation);
		
		JLabel lblDateRetour = new JLabel("Date retour ");
		lblDateRetour.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDateRetour.setBounds(160, 145, 109, 28);
		frame.getContentPane().add(lblDateRetour);
		
		JLabel lblNewLabel_6_1 = new JLabel("Prix");
		lblNewLabel_6_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_6_1.setBounds(292, 145, 123, 28);
		frame.getContentPane().add(lblNewLabel_6_1);
		
		JLabel lblNewLabel_6_2 = new JLabel("Total");
		lblNewLabel_6_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_6_2.setBounds(442, 145, 106, 28);
		frame.getContentPane().add(lblNewLabel_6_2);
		
		nomTextField = new JTextField();
		nomTextField.setBounds(25, 80, 107, 28);
		frame.getContentPane().add(nomTextField);
		nomTextField.setColumns(10);
		
		JButton btnAjouterLocataire = new JButton("Ajouter Locataire");
		btnAjouterLocataire.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnAjouterLocataire.setBounds(31, 351, 164, 42);
		frame.getContentPane().add(btnAjouterLocataire);
		
		JButton btnVoirLocataire = new JButton("Voir Locataire");
		btnVoirLocataire.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnVoirLocataire.setBounds(31, 415, 128, 42);
		frame.getContentPane().add(btnVoirLocataire);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnRetour.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnRetour.setBounds(596, 351, 128, 42);
		frame.getContentPane().add(btnRetour);
		
		JButton btnMenuPrincipal = new JButton("Menu Principal");
		btnMenuPrincipal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnMenuPrincipal.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnMenuPrincipal.setBounds(596, 415, 128, 42);
		frame.getContentPane().add(btnMenuPrincipal);
		
		JButton btnViderLesChamps = new JButton("Vider Les champs");
		btnViderLesChamps.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnViderLesChamps.setBounds(596, 211, 164, 42);
		frame.getContentPane().add(btnViderLesChamps);
		
		PrénomTextField = new JTextField();
		PrénomTextField.setColumns(10);
		PrénomTextField.setBounds(160, 80, 107, 28);
		frame.getContentPane().add(PrénomTextField);
		
		cinTextField = new JTextField();
		cinTextField.setColumns(10);
		cinTextField.setBounds(292, 80, 107, 28);
		frame.getContentPane().add(cinTextField);
		
		voitureTextField = new JTextField();
		voitureTextField.setColumns(10);
		voitureTextField.setBounds(441, 80, 107, 28);
		frame.getContentPane().add(voitureTextField);
		
		nbrDeJourTextField = new JTextField();
		nbrDeJourTextField.setColumns(10);
		nbrDeJourTextField.setBounds(607, 80, 107, 28);
		frame.getContentPane().add(nbrDeJourTextField);
		
		dateLocationTextField = new JTextField();
		dateLocationTextField.setColumns(10);
		dateLocationTextField.setBounds(25, 207, 107, 28);
		frame.getContentPane().add(dateLocationTextField);
		
		dateDeretourTextField = new JTextField();
		dateDeretourTextField.setColumns(10);
		dateDeretourTextField.setBounds(160, 207, 107, 28);
		frame.getContentPane().add(dateDeretourTextField);
		
		prixTextField = new JTextField();
		prixTextField.setColumns(10);
		prixTextField.setBounds(292, 207, 107, 28);
		frame.getContentPane().add(prixTextField);
		
		totalTextField = new JTextField();
		totalTextField.setColumns(10);
		totalTextField.setBounds(441, 196, 86, 57);
		frame.getContentPane().add(totalTextField);
	}
}
