package expressionsRegulieresForm;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {

	public static void main(String[] args) {
		
		/*
		 * un motif de texte a valider ou rechercher
		 * 
		 * pour la plupart des caracteres, il représente eux même
		 * 
		 * "to" --> "titota"
		 * 			   ^^
		 * le caracter '.' signifie n'importe quel caractere UNE FOIS
		 * 
		 * "t."  --> "patara"
		 * 				^^
		 * 
		 * [aeiou] -> un parmis ces caracteres la
		 * "t[aeiou]" -> "patatratx"
		 * 					^^
		 * 
		 * [a-z] -> un caractere de a jusqu'a z
		 * [a-zA-Z0-9] -> alphanumerique
		 * 
		 * + repete de 1 a n fois ce qui precede immédiatement
		 * 
		 * t[aeiou]+ -> ta tae touia teeeeeeee...
		 * 
		 * '*' repete de 0 à n fois
		 * t[aeiou]* -> t ta tae touia teeeeeeee...
		 * 
		 * '?' repete de 0 à 1 fois
		 * t[aeiou]? -> t ta te
		 * 
		 *  2 à 5 fois
		 * t[aeiou]{2,5} -> tae taiou tuoo 
		 * 
		 * les parentheses permettent de regrouper des caracteres ensembles
		 * 
		 * ra(ta)+touille -> ratatouille ratatatouille ratatatatatatouille
		 * 
		 * 
		 */
		// la classe Pattern représente une expression régulière compilée
			Pattern p = Pattern.compile("[0-9]{4,6}");
			
		// un Matcher permet de tester une chaine avec un Pattern fournis
			Matcher m = p.matcher("toto");
			System.out.println("correspondance ? " + m.matches());
			m = p.matcher("15345");
			System.out.println("correspondance ? " + m.matches());
			
			Scanner input = new Scanner(System.in);
			String saisie = input.nextLine();
			m = p.matcher(saisie);
			System.out.println("correspondance ? " + m.matches());
			
			// si vous avez besoin de rechercher des caracters speciaux
			// [ (, . + ?
			// les préceder de \
			p=  Pattern.compile("[a-zA-Z]+\\.[a-zA-Z]+");
			
			saisie = input.nextLine();
			m = p.matcher(saisie);
			System.out.println("correspondance ? " + m.matches());
			
			// exemple email
			p=  Pattern.compile("[a-zA-Z0-9.]+@[a-zA-Z0-9]+\\.[a-zA-Z]{2,5}");
			saisie = input.nextLine();
			m = p.matcher(saisie);
			System.out.println("correspondance ? " + m.matches());
			
		

	}

}
