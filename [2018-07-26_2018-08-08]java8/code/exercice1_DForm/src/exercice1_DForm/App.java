package exercice1_DForm;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("taille du triangle");
		int taille = Integer.parseInt(input.nextLine());
		taille = (taille <= 0)? 5 : taille;
		taille = (taille > 30)? 30 : taille;
		
		for (int ligne = 0; ligne < taille; ligne++) {
			//System.out.println("*");
			for (int colonne = 0; colonne < taille - ligne; colonne++) {
				if (colonne == 0 || ligne == 0 || colonne == taille - ligne -1) {
					System.out.print("*");
				}
				else {
					System.out.print("-");
				}
			}
			System.out.println();
		}
		

	}

}
