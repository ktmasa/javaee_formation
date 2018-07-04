package factoryApp;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("quelle pays somme 1 ?");
		String pays = input.nextLine();
		
		System.out.println("quelle valeur somme 1 ?");
		double montant = Double.parseDouble(input.nextLine());
		
		IMoney m1 = FabriqueMoney.fabriqueMoney(pays, montant);
		System.out.println(m1.formattage());
		
		System.out.println("---------------------------------------------");

		System.out.println("quelle pays somme 2 ?");
		String pays2 = input.nextLine();
		
		System.out.println("quelle valeur somme 2 ?");
		double montant2 = Double.parseDouble(input.nextLine());
		
		IMoney m2 = FabriqueMoney.fabriqueMoney(pays2, montant2);
		
		System.out.println(m2.formattage());
		
		m1.add(m2);
		System.out.println(m1.formattage());

	}

}
