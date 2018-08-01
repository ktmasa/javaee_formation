package javaEnumerationForm;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		
		JoursSemaine j1 = JoursSemaine.Mardi;
		
		System.out.println(j1);
		System.out.println(j1.ordinal());

		if (j1 == JoursSemaine.Mardi) {
			System.out.println("nous somme mardi");
		}
		else {
			System.out.println("un autre jour");
		}
		
		Scanner sc = new Scanner(System.in);
		System.out.println("saisissez un jour");
		JoursSemaine j2 = JoursSemaine.valueOf(sc.nextLine());
		
		System.out.println(j2);
		System.out.println(j2.ordinal());
		
		// on peut parcourir toutes les valeurs possible d'une enumeration
		System.out.println("------------");
		for (JoursSemaine jr : JoursSemaine.values()) {
			System.out.println(jr + " - " + jr.ordinal());
		}
		
		
	}

}
