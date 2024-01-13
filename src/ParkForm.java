import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ParkForm {

	private JFrame frame;
	private JTextField textFieldVoiture;
	private JTextField textFieldPrix;
	private JTextField textFieldNimmatriculation;
	private JTextField textFieldModèle;
	private final ButtonGroup buttonGroup = new ButtonGroup();

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
		
		JRadioButton rdbtnDiesel = new JRadioButton("Diesel");
		rdbtnDiesel.setFont(new Font("Tahoma", Font.BOLD, 13));
		buttonGroup.add(rdbtnDiesel);
		rdbtnDiesel.setBounds(50, 200, 109, 23);
		frame.getContentPane().add(rdbtnDiesel);
		
		JRadioButton rdbtnEssence = new JRadioButton("Essence");
		rdbtnEssence.setFont(new Font("Tahoma", Font.BOLD, 13));
		buttonGroup.add(rdbtnEssence);
		rdbtnEssence.setBounds(50, 243, 109, 23);
		frame.getContentPane().add(rdbtnEssence);
	}
}
