package structureControleForm;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
	
		// lecteur sur l'entree standard
		Scanner input = new Scanner(System.in);
		
		System.out.println("saisissez votre age:");
		String saisie = input.nextLine();

		// convertir une chaine de caractere en entier
		int age = Integer.parseInt(saisie);
		
		System.out.println("vous avez " + age + " ans");
		// if (expression renvoyant un boolean)
		if (age < 20) {
			System.out.println("salut, comment ca va!");
		}
		else if (age < 60) {
			System.out.println("bonjour, comment allez vous ?");
		}
		else {
			System.out.println("bonjour, comment va la santé?");
		}
		
		System.out.println("----------------------------------");
		
		System.out.println("code du pays?");
		String code = input.nextLine().toUpperCase();
		
		switch(code) {
			case "FR":
			case "BE":
				System.out.println("francais");
				break;
			case "UK":
			case "US":
			case "CA":
				System.out.println("anglais");
				break;
			case "ES":
			case "MX":
				System.out.println("espagnol");
				break;
			case "JP":
				System.out.println("japonais");
				break;
			case "RO":
				System.out.println("roumain");
				break;
			default:
				System.out.println("esperanto");
		}
		
		// operateur ternaire
		
		System.out.println("poids article ?");
		double poids = Double.parseDouble(input.nextLine());
		
		poids = (poids > 0)? poids : 0;
		System.out.println("poids = " + poids);
		
		// les boucles
		
		int compteur = 0;
		// boucle de base, while
		// while(condition) {code a repeter)
		while (compteur < 10) {
			if (compteur == 7) {
				break;
			}
			System.out.println("compteur = " + compteur);
			compteur++; // augmenter le compteur de 1
		}
		System.out.println("----------------------------------");
		// do while
		compteur = 15;
		do {
			System.out.println("dowhile compteur = " + compteur);
			compteur++;
		} while(compteur < 10);
		
		
		System.out.println("----------------------------------");
		// la boucle for
		// for(initialisation;test d'arret; incrementation) { code}
		
		for (int i = 1; i < 10; i++) {
			if (i == 5) {
				continue; // saute directement a la prochaine itération
			}
			System.out.println("for i = " + i);
		}
		
		//System.out.println(i);
		String[] pays = {"france",
						"roumanie",
						"georgie",
						"espagne",
						"italie",
						"republique lunaire"};
		
		for (String p : pays) {
			System.out.println(p);
		}
		
		//int bc42;
		// un identifiant (nom de variable par exemple) en java
		// ne peut pas commencer par un chiffre
		// mais peut en contenir
		// les caracteres alphanumérique et _
		// mais pas les signes mathématiquer (-, *...)
		// pas les mot clé du langage
		
		
		
	}

}
