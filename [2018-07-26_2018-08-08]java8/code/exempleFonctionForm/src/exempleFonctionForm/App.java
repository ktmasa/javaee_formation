package exempleFonctionForm;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.println("temperature en celsius ?");
		double t = Double.parseDouble(input.nextLine());
		System.out.println("en farheneit = " + conversionFahreneit(t));
		
		System.out.println("temperature en fahreneit ?");
		t = Double.parseDouble(input.nextLine());
		System.out.println("en celcius = " + conversionCelcius(t));
		
	}

	public static double conversionCelcius(double fahreneit) {
		return (fahreneit - 32) / 1.8;
		
	}

	public static double conversionFahreneit(double celcius) {
		return celcius * 1.8 + 32;
	}

}
