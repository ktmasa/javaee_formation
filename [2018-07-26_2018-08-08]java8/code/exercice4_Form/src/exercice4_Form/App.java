package exercice4_Form;

import java.util.Random;

import exercice4_Form.geo.Figure;
import exercice4_Form.geo.Rectangle;
import exercice4_Form.geo.Triangle;

public class App {

	public static void main(String[] args) {

		Random rd = new Random();
		
		Figure[] figs = new Figure[10];
		for (int i = 0; i < figs.length; i++) {
			if (rd.nextBoolean()) {
				figs[i] = new Triangle('*', '.', rd.nextInt(10) + 5);
			}
			else {
				figs[i] = new Rectangle('#', '-', rd.nextInt(10) + 5, rd.nextInt(10) + 5);
			}
		}
		
		for (Figure f : figs) {
			System.out.println("surface = " + f.getSurface());
			f.afficher();
		}

	}

}
