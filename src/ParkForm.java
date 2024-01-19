import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.JOptionPane;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JFormattedTextField;
public class ParkForm {

	private JFrame frame;
	private JTextField textFieldVoiture;
	private JTextField textFieldPrix;
	private JTextField textFieldNimmatriculation;
	private JTextField textFieldModèle;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private Connection conn;
	private JRadioButton rdbtnDiesel;
	private JRadioButton rdbtnEssence;

	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ParkForm window = new ParkForm();
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
	public ParkForm() {
		initialize();
		initialiserDatabase();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 816, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		textFieldVoiture = new JTextField();
		textFieldVoiture.setColumns(10);
		textFieldVoiture.setBounds(441, 73, 107, 28);
		frame.getContentPane().add(textFieldVoiture);

		JLabel lblVoiture = new JLabel("Voiture");
		lblVoiture.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblVoiture.setBounds(441, 17, 123, 28);
		frame.getContentPane().add(lblVoiture);

		JLabel lblNewLabel_6_1 = new JLabel("Prix");
		lblNewLabel_6_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_6_1.setBounds(292, 138, 123, 28);
		frame.getContentPane().add(lblNewLabel_6_1);

		textFieldPrix = new JTextField();
		textFieldPrix.setColumns(10);
		textFieldPrix.setBounds(292, 200, 107, 28);
		frame.getContentPane().add(textFieldPrix);

		JButton btnAjouterVoiture = new JButton("Ajouter Voiture");
		btnAjouterVoiture.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAjouterVoiture.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnAjouterVoiture.setBounds(31, 344, 164, 42);
		frame.getContentPane().add(btnAjouterVoiture);

		JButton btnVoirVoiture = new JButton("Voir Voiture");
		btnVoirVoiture.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				park.main(null);
			}
		});
		btnVoirVoiture.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnVoirVoiture.setBounds(31, 408, 164, 42);
		frame.getContentPane().add(btnVoirVoiture);

		JButton btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnRetour.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnRetour.setBounds(596, 344, 164, 42);
		frame.getContentPane().add(btnRetour);

		JButton btnViderLesChamps = new JButton("Vider Les champs");
		btnViderLesChamps.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldNimmatriculation.setText("");
				textFieldVoiture.setText("");
				textFieldModèle.setText("");
				buttonGroup.clearSelection();
				textFieldPrix.setText("");
			}
		});
		btnViderLesChamps.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnViderLesChamps.setBounds(596, 204, 164, 42);
		frame.getContentPane().add(btnViderLesChamps);

		textFieldNimmatriculation = new JTextField();
		textFieldNimmatriculation.setColumns(10);
		textFieldNimmatriculation.setBounds(72, 73, 107, 28);
		frame.getContentPane().add(textFieldNimmatriculation);

		JLabel lblNImmatriculation = new JLabel("N° immatriculation");
		lblNImmatriculation.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNImmatriculation.setBounds(72, 17, 123, 28);
		frame.getContentPane().add(lblNImmatriculation);

		JLabel lblModle = new JLabel("Modèle");
		lblModle.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblModle.setBounds(254, 17, 123, 28);
		frame.getContentPane().add(lblModle);

		textFieldModèle = new JTextField();
		textFieldModèle.setColumns(10);
		textFieldModèle.setBounds(254, 73, 107, 28);
		frame.getContentPane().add(textFieldModèle);

		JLabel lblCarburant = new JLabel("Carburant");
		lblCarburant.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCarburant.setBounds(56, 138, 123, 28);
		frame.getContentPane().add(lblCarburant);

        rdbtnDiesel = new JRadioButton("Diesel");
		rdbtnDiesel.setFont(new Font("Tahoma", Font.BOLD, 13));
		buttonGroup.add(rdbtnDiesel);
		rdbtnDiesel.setBounds(50, 200, 109, 23);
		frame.getContentPane().add(rdbtnDiesel);

		rdbtnEssence = new JRadioButton("Essence");
		rdbtnEssence.setFont(new Font("Tahoma", Font.BOLD, 13));
		buttonGroup.add(rdbtnEssence);
		rdbtnEssence.setBounds(50, 243, 109, 23);
		frame.getContentPane().add(rdbtnEssence);
	}

	/**
	 * Initialize the database connection.
	 */
	private void initialiserDatabase() {
		try {
			// Replace 'your_database_name', 'your_username', and 'your_password' with your
			// actual database information
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

	
	
	/**
     * Methode pour vider les champs
     */
	private void viderChamps() {
		textFieldNimmatriculation.setText("");
		textFieldVoiture.setText("");
		textFieldModèle.setText("");
		buttonGroup.clearSelection();
		textFieldPrix.setText("");
	}

	/**
	     * Method to add a car to the database.
	     */
	    private void addCarToDatabase() {
	        try {
	            // Prepare a SQL statement for the database insertion
	            String sql = "INSERT INTO your_table_name (Nimmatriculation, voiture, modèle, carburant, prix) VALUES (?, ?, ?, ?, ?)";
	            try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
	                // Set the values for the prepared statement based on your UI components
	                preparedStatement.setString(1, textFieldNimmatriculation.getText());
	                preparedStatement.setString(2, textFieldVoiture.getText());
	                preparedStatement.setString(3, textFieldModèle.getText());
	                
	                // Determine the selected carburant :
	                
	               String carburant = "";
	               if (rdbtnDiesel.isSelected()) {
	                   carburant = "Diesel";
	               } else if (rdbtnEssence.isSelected()) {
	                   carburant = "Essence";
	               } else {
	                   JOptionPane.showMessageDialog(null, "Veuillez choisir le type de carburant.", "Erreur",
	                           JOptionPane.ERROR_MESSAGE);
	                   return;  // Ajoutez un return ici pour sortir de la méthode en cas d'erreur
	               }
	               preparedStatement.setString(4, carburant);

	                // Parse the prix value from the text field
	                double prix = Double.parseDouble(textFieldPrix.getText());
	                preparedStatement.setDouble(5, prix);

	                // Execute the SQL statement
	                preparedStatement.executeUpdate();
	                // Optionally, you may show a success message or clear the input fields
	                JOptionPane.showMessageDialog(null, "Voiture ajoutée avec succès.", "Succès",
	                JOptionPane.INFORMATION_MESSAGE);
	                viderChamps();  // Ajoutez cette méthode pour vider les champs après l'ajout
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }


	    }
}