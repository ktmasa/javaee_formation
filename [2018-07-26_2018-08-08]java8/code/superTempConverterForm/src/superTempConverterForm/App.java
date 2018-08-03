package superTempConverterForm;

import superTempConverterForm.temperature.ConvertisseurTemp;
import superTempConverterForm.temperature.ConvertisseurTemp.TooColdTemperatureException;
import superTempConverterForm.temperature.ConvertisseurTemp.UnknownUnitException;

public class App {

	public static void main(String[] args) {

		ConvertisseurTemp ct = new ConvertisseurTemp();
		
		try {
			ct.saisieTemperature();
			System.out.println("en kelvin :" + ct.getKelvin());
			System.out.println("en celcius :" + ct.getCelcius());
			System.out.println("en farhenheit :" + ct.getFahrenheit());
		}
		catch (TooColdTemperatureException ex) {
			System.out.println("il fait trp froid: " + ex.getMessage());
		}
		catch (UnknownUnitException ex) {
			System.out.println("unite non supportée: " + ex.getMessage());
		}
	}

}
