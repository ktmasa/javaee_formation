package singletonApp;

import java.awt.Color;

public class App {

	public static void main(String[] args) {
		//AppConfig c = new AppConfig();

		// on passe par la méthode du singleton
		AppConfig c = AppConfig.getApptConfig();
		c.couleurFond = Color.orange;
		
		Fenetre1 f1 = new Fenetre1();
		f1.setVisible(true);
		
	}

}
