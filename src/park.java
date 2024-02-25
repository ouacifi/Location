import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import net.proteanit.sql.DbUtils;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import java.awt.Component;
import java.awt.Dimension;

public class park {

	private Connection conn;
	JFrame frame;
	private JTable table;
	private JTextField textField;
	PreparedStatement ps ;
	ResultSet rs ;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					park window = new park();
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
	public park() {
		initialize();
		initialiserConnexion ();
		chargerTable();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 950, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		table = new JTable();
	    JScrollPane scrollPane = new JScrollPane(table);
	    scrollPane.setBounds(50, 50, 700, 400);
		table.setRowHeight(30); 						// Définit la hauteur des cellules de la table à 30 pixels
	    frame.getContentPane().add(scrollPane);
		table.setFont(new Font("Tahoma", Font.ITALIC, 18));
		table.setBounds(50, 50, 700, 400);

		JButton retourBtn = new JButton("Retour");
		retourBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		
		retourBtn.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		retourBtn.setBounds(801, 392, 89, 50);
		frame.getContentPane().add(retourBtn);
		
		textField = new JTextField();
		textField.setBounds(570, 480, 150, 40);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnAfficherTous = new JButton("Afficher tous");
		btnAfficherTous.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnAfficherTous.setBounds(140, 470, 150, 70);
		frame.getContentPane().add(btnAfficherTous);
		
		JButton btnRechercherVoiture = new JButton("Rechercher Voiture");
		btnRechercherVoiture.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnRechercherVoiture.setBounds(364, 470, 165, 70);
		frame.getContentPane().add(btnRechercherVoiture);
		
		JButton AjouterVoitureBtn = new JButton("Ajouter Voiture");
		AjouterVoitureBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ParkForm.main(null);
				frame.dispose();

			}
		});
		AjouterVoitureBtn.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		AjouterVoitureBtn.setBounds(774, 49, 150, 70);
		frame.getContentPane().add(AjouterVoitureBtn);
		
		JButton modifierVoitureBtn = new JButton("Modifier Voiture");
		modifierVoitureBtn.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		modifierVoitureBtn.setBounds(774, 169, 150, 70);
		frame.getContentPane().add(modifierVoitureBtn);
		
		JButton supprimerVoitureBtn = new JButton("Supprimer Voiture");
		supprimerVoitureBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				initialiserConnexion();
				SupprimerEnregTable();
			}
		});
		supprimerVoitureBtn.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		supprimerVoitureBtn.setBounds(774, 282, 150, 70);
		frame.getContentPane().add(supprimerVoitureBtn);
								}
		
		//méthode pour initialiser la connexion avec la base de données
		public void initialiserConnexion (){
									//coordonnées de la base de données //
				String url ="jdbc:mysql://localhost:3306/location";
				String user = "root"; 
				String pass = ""; 
								 // établir connexion  avec la base de données
				try{
					conn = DriverManager.getConnection(url,user,pass);
					System.out.println("Connecter");
				}catch(SQLException e) {														
					System.out.println("Erreur lors de la connexion à la base de données :");
			         e.printStackTrace()	; 
			         } 
				}

		//méthode pour afficher la liste des voiture ''chargement des table "
				
		public void  chargerTable() {
			String 	requete = "select * from garage";
			try {
			ps = conn.prepareStatement(requete);
			rs =	ps.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
				
				} catch (SQLException e) {
				}
			}
			//methode pour supprimer une ligne dans la table /
			
		public void SupprimerEnregTable() {
			
			int selectedRow = table.getSelectedRow();

			if (selectedRow != -1) {
				// Récupérer la valeur de l'identifiant de l'enregistrement
				String id = table.getValueAt(selectedRow, 0).toString();

				// Supprimer l'enregistrement de la base de données
				String requeteDelete = "DELETE FROM garage WHERE voiture	 = ?";
				try (PreparedStatement ps = conn.prepareStatement(requeteDelete)) {
					ps.setString(1, id);
					ps.executeUpdate();
				} catch (SQLException ex) {
					ex.printStackTrace();
					return;
				}

				// Supprimer la ligne du modèle de données
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.removeRow(selectedRow);

				// Rafraîchir l'affichage de la table
				table.repaint();
			} else {
				System.out.println("Veuillez sélectionner une ligne à supprimer.");
			}

		}
	}