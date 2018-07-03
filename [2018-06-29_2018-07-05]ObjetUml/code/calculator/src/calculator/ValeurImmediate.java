package calculator;

public class ValeurImmediate implements Calculable {

	private double valeur;
	
	public ValeurImmediate(double valeur) {
		this.valeur = valeur;
	}

	@Override
	public double calculer() {
		return this.valeur;
	}

}
