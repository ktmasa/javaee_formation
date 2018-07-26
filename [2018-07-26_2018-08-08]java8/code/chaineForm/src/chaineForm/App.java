package chaineForm;

import java.util.Arrays;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		
		String str1 = "bonjour";
		System.out.println(str1);
		String str2 = " monde";
		System.out.println(str1 + str2);
		// length() -> longueur de la chaine
		System.out.println(str1.length());
		
		System.out.println("4eme caractere -> " + str1.charAt(3));
		// \n -> newline
		String str3 = "hello\nworld";
		System.out.println(str3);

		// \" -> le caractere ", \\ -> caractere \
		String str4 = "bonjour \"bob\"";
		System.out.println(str4);
		
		System.out.println("-------------------------------------");
		
		int x = 15;
		int y = 12;
		System.out.println(x == y);
		int z = 15;
		System.out.println(x == z);
		
		System.out.println("---------------------------------------");
		String stra = "lundi";
		String strb = "mardi";
		System.out.println(stra == strb);
		String strc = "lundi";
		System.out.println(stra == strc);
		String strd = "lun";
		strd += "di";
		System.out.println(stra == strd);
		
		/*
		 * en java
		 * on ne compare JAMAIS les chaines de caractere avec ==
		 *  JAMAIS
		 * 
		 * on compare avec la methode Equals ou une autre
		 * 
		 */
		
		System.out.println("stra equals strb ->" + stra.equals(strb));
		System.out.println("stra equals strc ->" + stra.equals(strc));
		System.out.println("stra equals strd ->" + stra.equals(strd));
	
		// saisie
		Scanner input = new Scanner(System.in);
		System.out.println("quel est votre nom? ");
		// récupération de la saisie
		String saisie = input.nextLine();
		
		System.out.println("bonjour, " + saisie);
		// passer en majuscule
		System.out.println("bonjour, " + saisie.toUpperCase());
		// remplacer un caractere par un autre
		System.out.println("bonjour, " + saisie.replace('e', '*'));
		// rechercher position dans le texte
		System.out.println("position de 'e', " + saisie.indexOf('e'));
		System.out.println("position de 'ou', " + saisie.indexOf("ou"));
		
		System.out.println("souschaine 2 - 5 =" + saisie.substring(2, 5));
		
		
		System.out.println("--------------------------");
		// tableaux
		int[] tab1 = {4, 5, 12, -3};
		System.out.println(tab1.length);
		System.out.println(tab1[2]);
		
		// tableau de chaines de 5 case vide pour l'instant
		String[] jours = new String[5];
		jours[0] = "lundi";
		jours[1] = "mardi";
		jours[2] = "mercredi";
		jours[3] = "jeudi";
		jours[4] = "vendredi";
		
		// affichage du tableau
		// la classe Arrays contient plein de méthodes utiles pour les tableaux
		System.out.println(Arrays.toString(jours));
		
		
		
	}

}
