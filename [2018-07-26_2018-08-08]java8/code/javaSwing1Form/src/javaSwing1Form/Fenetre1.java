package javaSwing1Form;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Fenetre1 extends JFrame {
	
	private JButton boutonA;
	private JButton boutonB;
	private JButton boutonC;
	private JButton boutonD;
	private JLabel labelA;
	
	public Fenetre1() {
		super("ma super fenetre");
		// dimensionner la fenetre
		this.setSize(600, 500);
		// centrer la fenetre
		this.setLocationRelativeTo(null);
		// quand on ferme la fenetre, terminer l'application
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// creation des composants de la fenetre
		this.boutonA = new JButton("bouton A");
		this.boutonB = new JButton("bouton B");
		this.boutonC = new JButton("bouton C");
		this.boutonD = new JButton("bouton D");
		this.labelA = new JLabel("texte temporaire");
		
		// indiquer a la fenetre comment organiser son contenu
		// LayoutManager
		// FlowLayout -> de gauche a droite, et de haut en bas
		this.setLayout(new FlowLayout());
		// placement des boutons dans la fenetre
		this.add(boutonA);
		this.add(boutonB);
		this.add(boutonC);
		this.add(boutonD);
		// et du label
		this.add(labelA);
		
		this.boutonA.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "bonjour");
			}
		});
		
		this.boutonB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				labelA.setText("nous somme le " + LocalDateTime.now());
				
			}
		});	
	}
	
}
