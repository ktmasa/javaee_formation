package exercice1_BForm;

import java.util.Random;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		
		Random rd = new Random();
		
		int nbToGuess = rd.nextInt(51);
		
		int nbEssaisRestant = 7;
		Scanner input = new Scanner(System.in);
		
		while (nbEssaisRestant > 0) {
			System.out.println("quelle chiffre (0-50),"
							+ nbEssaisRestant + " essais restants? ");
			// chiffre saisie pour tenter de deviner
			int guess = Integer.parseInt(input.nextLine());
			if (guess < nbToGuess) {
				System.out.println("plus grand!");
			}
			else if (guess > nbToGuess) {
				System.out.println("plus petit!");
			}
			else {
				break;
			}
			nbEssaisRestant--;
		}

		if (nbEssaisRestant > 0 ) {
			System.out.println("gagné!, il vous restait " + nbEssaisRestant + " essais");
		}
		else {
			System.out.println("perdu, c'était :" + nbToGuess);
		}
	}

}
