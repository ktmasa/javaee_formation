package exercice5_Form;

import exercice5_Form.echecs.EchecCouleur;
import exercice5_Form.echecs.Fou;
import exercice5_Form.echecs.Piece;
import exercice5_Form.echecs.Pion;
import exercice5_Form.echecs.Tour;

public class App {

	public static void main(String[] args) {
		Piece p1 = new Pion(3, 5, EchecCouleur.noire);
		
		System.out.println(p1);
		System.out.println("deplacement p1 = " + p1.getDeplacementsPossible());
		
		Piece p2 = new Pion(3, 8, EchecCouleur.Blanche);
		System.out.println(p2);
		System.out.println("deplacement p2 = " + p2.getDeplacementsPossible());
		
		Piece p3 = new Tour(3, 4, EchecCouleur.Blanche);
		System.out.println(p3);
		System.out.println("deplacement p3 = " + p3.getDeplacementsPossible());

		Piece p4 = new Fou(3, 4, EchecCouleur.Blanche);
		System.out.println(p4);
		System.out.println("deplacement p4 = " + p4.getDeplacementsPossible());
	}

}
