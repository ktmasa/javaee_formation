package superTempConverterForm.temperature;

import java.util.Scanner;

public class ConvertisseurTemp {
	
	private double kelvin;

	public double getKelvin() {
		return kelvin;
	}
	public void setKelvin(double kelvin) {
		if (kelvin < 0)
			throw new TooColdTemperatureException("ne peu pas etre plus froid que le zero absolu");
		this.kelvin = kelvin;
	}

	public double getCelcius() {
		return getKelvin() - 273.15;
	}
	public void setCelcius(double celcius) {
		setKelvin(celcius + 273.15);
		
	}
	public double getFahrenheit() {
		return ((getKelvin()  * 1.8) - 459.67); 
	}
	public void setFahrenheit(double fahrenheit) {
		setKelvin(((fahrenheit + 459.67) / 1.8));
	}
	
	public void saisieTemperature() {
		Scanner sc = new Scanner(System.in);
		String saisie, unite;
		double valeur;
		// boucle de saisie tant que le format n'est pas bon
		while(true) {
			try {
				System.out.println("temperature a convertir (c,f,k) ?");
				saisie = sc.nextLine();
				// saisie = "45c"
				// unite  =   "c"
				// valeur = "45"
				unite = saisie.substring(saisie.length() -1).toLowerCase();
				valeur = Double.parseDouble(saisie.substring(0, saisie.length() -1));
				break;
			}
			catch (NumberFormatException ex) {
				System.out.println("pas un nombre!");
			}
		}
		switch(unite) {
			case "c":
				setCelcius(valeur);
				break;
			case "k":
				setKelvin(valeur);
				break;
			case "f":
				setFahrenheit(valeur);
				break;
			default:
				throw new UnknownUnitException( unite + " n'est pas une unité connue");
		}
	}
	/*
	 *  les classe d'erreur
	 * 
	 */
	
	public static class UnknownUnitException extends RuntimeException{

		public UnknownUnitException(String msg) {
			super(msg);
		}
		
	}
	
	
	public static class TooColdTemperatureException extends RuntimeException{

		public TooColdTemperatureException(String msg) {
			super(msg);
		}
		
	}
	

}
