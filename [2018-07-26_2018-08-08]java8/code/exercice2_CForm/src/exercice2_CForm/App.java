package exercice2_CForm;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		System.out.println("que vas on chanter ?");
		Scanner input = new Scanner(System.in);
		String refrain = input.nextLine();

		chansonEnervante(refrain);
		
	}
	
	public static void chansonEnervante(String refrain) {
		for (int i = 99; i > 0; i--) {
			System.out.println(i + " " 
						+ refrain + " restant, "
						+ " 1 " + refrain + " tombe");
		}
		System.out.println("plus de " + refrain);
		
	}

}
