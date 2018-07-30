package exercice2_FForm;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("saisissez temp a convertir suivi de l'unite(C,K,F) : ");
		String saisie = input.nextLine();
		
		convertTemp(saisie);
		

	}
	
	public static void convertTemp(String saisie) {
		// découper la saisie entre la valeur et l'unité
		// l'unité est le dernier caractere
		String unit = saisie.substring(saisie.length() - 1);
		// le reste de la chaine est la valeur a convertir (la chaine moins le dernier caractere)
		double temp = Double.parseDouble(saisie.substring(0, saisie.length() - 1));
		
		switch(unit.toUpperCase()) {
			case "C":
				System.out.println("en kelvin : " + (temp + 273.15));
				System.out.println("en farheneit: " + ((temp * 1.8) + 32));
				return;
			case "K":
				System.out.println("en celcius : " + (temp - 273.15));
				System.out.println("en farheneit: " + ((temp  * 1.8) - 459.67));
				return;
			case "F":
				System.out.println("en celcius : " + ((temp - 32) / 1.8));
				System.out.println("en kelvin : " + ((temp + 459.67) / 1.8));
				return;
			default:
				System.out.println("connait pas cette unité");
		}
	}

}
