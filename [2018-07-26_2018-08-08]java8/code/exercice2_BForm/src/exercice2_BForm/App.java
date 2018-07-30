package exercice2_BForm;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		System.out.println("quelle est votre age ? ");
		Scanner input = new Scanner(System.in);
		int age = Integer.parseInt(input.nextLine());
		affiche_age(age);

	}
	
	public static void affiche_age(int age) {
		String[] planetes = {"mercure", "venus", "mars", "jupiter", "saturne", "uranus", "neptune"};
		// nombre d'année terrienne pour une année de chaque planete
		double[] facteur_duree = { 0.24, 0.61, 1.88, 11.86, 29.44, 84.01, 164.79};
		
		for (int i = 0; i < planetes.length; i++) {
			System.out.println("sur " + planetes[i] + 
						", vous auriez " + (age / facteur_duree[i]) + " ans");
		}
		
	}

}
