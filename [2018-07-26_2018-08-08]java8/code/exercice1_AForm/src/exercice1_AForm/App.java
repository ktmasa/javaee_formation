package exercice1_AForm;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("combien de notes à saisir ? ");
		int nbNotes = Integer.parseInt(input.nextLine());

		double somme = 0.0;
		double min = 10000; //Double.POSITIVE_INFINITY;
		double max = -10000; //Double.NEGATIVE_INFINITY;
		
		// répeter nbNotes fois
		for (int i = 0; i < nbNotes; i++) {
			System.out.println("nouvelle notes ? ");
			double note = Double.parseDouble(input.nextLine());
			somme += note;
			if (note < min) {
				min = note;
			}
			if (note > max) {
				max = note;
			}
		}
		
		System.out.println("note minimum = " + min);
		System.out.println("note maximum = " + max);
		System.out.println("moyenne = " + (somme / nbNotes));
	}

}
