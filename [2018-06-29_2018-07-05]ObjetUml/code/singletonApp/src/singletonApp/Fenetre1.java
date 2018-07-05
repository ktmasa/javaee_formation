package singletonApp;

import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Fenetre1 extends JFrame implements ActionListener{

	private AppConfig config;
	
	public Fenetre1() throws HeadlessException {
		super();
		setSize(800, 600);
		setLocationRelativeTo(null);
		setLayout(new FlowLayout());
		JButton bt =new JButton("bouton");
		add(bt);
		
		bt.addActionListener(this);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		config = AppConfig.getApptConfig();
		setBackground(config.couleurFond);
		setTitle("Fenetre1 " + config.piedPageStandard);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null, "coucou");
		
	}
	
	

}
