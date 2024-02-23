import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.sql.Connection;

public class LocataireForm {

	private JFrame frame;
	private JTextField nomTextField;
	private JTextField PrénomTextField;
	private JTextField cinTextField;
	private JTextField voitureTextField;
	private JTextField nbrDeJourTextField;
	private JTextField prixTextField;
	private JTextField totalTextField;
	private Connection conn;

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

		JLabel lblNewLabel_6_1 = new JLabel("Prix");
		lblNewLabel_6_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_6_1.setBounds(51, 155, 123, 28);
		frame.getContentPane().add(lblNewLabel_6_1);

		JLabel lblNewLabel_6_2 = new JLabel("Total");
		lblNewLabel_6_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_6_2.setBounds(231, 155, 106, 28);
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
		btnViderLesChamps.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viderLesChamps();

			}
		});
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

		prixTextField = new JTextField();
		prixTextField.setColumns(10);
		prixTextField.setBounds(31, 211, 107, 28);
		frame.getContentPane().add(prixTextField);

		totalTextField = new JTextField();
		totalTextField.setColumns(10);
		totalTextField.setBounds(231, 205, 86, 57);
		frame.getContentPane().add(totalTextField);
	}
		
	
	// méthode pour vider les champs
	private void viderLesChamps() {

		nomTextField.setText("");
		PrénomTextField.setText("");
		cinTextField.setText("");
		voitureTextField.setText("");
		nbrDeJourTextField.setText("");
		prixTextField.setText("");
		totalTextField.setText("");

	}

	/**
	 * Initialize the database connection.
	 */
	private void initialiserDatabase() {
		try {

			String url = "jdbc:mysql://localhost:3306/location";
			String username = "root";
			String password = "";

			// Establish the database connection
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("Connecter");
		} catch (SQLException e) {
			System.out.println("Non connecter");
			e.printStackTrace();
		}
	}
	
	// méthode pour ajouter le locataire
	private void ajouterLocataire() {
		String nom = nomTextField.getText();
		String prenom = PrénomTextField.getText();
		String cin = cinTextField.getText();
		String voiture = voitureTextField.getText();
		int nombreJours = Integer.parseInt(nbrDeJourTextField.getText());
		double prix = Double.parseDouble(prixTextField.getText());
		double total = Double.parseDouble(totalTextField.getText());

		// Connexion à la base de données
		try (Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/location", "root", "")) {
			// Requête SQL pour insérer le locataire
			String query = "INSERT INTO client (nom, prenom, cin, voiture, nombre_jours,  prix, total) VALUES (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, nom);
			statement.setString(2, prenom);
			statement.setString(3, cin);
			statement.setString(4, voiture);
			statement.setInt(5, nombreJours);
			statement.setDouble(6, prix);
			statement.setDouble(7, total);

			// Exécution de la requête d'insertion
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("Le locataire a été ajouté avec succès !");
			//Réinitialiser les champs après l'ajout
				  viderLesChamps();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
