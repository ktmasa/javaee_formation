package gestionErreur;

import java.util.Scanner;

public class App {

	public static void main(String[] args)  {
		
		System.out.println("quel est votre age ? ");
	//	Scanner sc = new Scanner(System.in);
		// try { code sous surveillance }
		try {
			/*String saisie = sc.nextLine();
			// conversion
			int age = Integer.parseInt(saisie);
	*/
			int age = saisieAge();
			
			System.out.println("vous avez " + age + " ans");
		}
		catch (NumberFormatException ex) {
			// code de gestion de l'erreur
			System.out.println("ce n'est pas un nombre, un age est forcement un nombre");
			//System.err.println(ex.getMessage());
		}
		catch (AgeException ex) {
			System.out.println("valeur age : " + ex.getMessage());
		}
		
		catch (Exception ex) {
			System.out.println("autre erreur : " + ex.getMessage());
		}
		finally {
			// code de nettoyage / cleanup
			System.out.println("nettoyage....");
		}
		System.out.println("programme terminé");
	}

	public static int saisieAge() {
		int age = 0;
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("votre age ? ");
			age = Integer.parseInt(sc.nextLine());
			if (age < 0) {
				throw new AgeException("un age ne peut etre négatif");
			}
		}
		catch (NumberFormatException ex) {
			System.out.println("pas un nombre!!");
		}
		return age;
	}
	
	
}
