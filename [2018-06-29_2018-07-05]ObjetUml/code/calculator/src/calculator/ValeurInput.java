package calculator;

import java.util.Scanner;

public class ValeurInput implements Calculable {

	private String nom;
	
	public ValeurInput(String nom) {
		this.nom = nom;
	}


	@Override
	public double calculer() {
		System.out.println("saisissez valeur pour " + nom);
		Scanner input = new Scanner(System.in);
		return Double.parseDouble(input.nextLine());
	}

}
