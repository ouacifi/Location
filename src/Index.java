import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Index {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Index window = new Index();
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
	public Index() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 806, 467);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton voirParkBtn = new JButton("Voir Park");
		voirParkBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				park.main(null);
			}
		});
		voirParkBtn.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		voirParkBtn.setBounds(292, 184, 170, 55);
		frame.getContentPane().add(voirParkBtn);
		
		JButton voirClientBtn = new JButton("Voir Locataire");
		voirClientBtn.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		voirClientBtn.setBounds(292, 263, 170, 55);
		frame.getContentPane().add(voirClientBtn);
		voirClientBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Locataire.main(null);
			}
		});
		
		JButton quitterBtn = new JButton("Quitter");
		quitterBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		quitterBtn.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		quitterBtn.setBounds(292, 342, 170, 55);
		frame.getContentPane().add(quitterBtn);
	}
}
