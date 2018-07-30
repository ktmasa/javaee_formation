package exercice2_AForm;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		
		System.out.println("votre nom ?");
		Scanner input = new Scanner(System.in);
		String nom = input.nextLine();
		oneFor(nom);

	}
	
	public static void oneFor(String nom) {
		System.out.println("one for me, one for " + nom);
	}

}
