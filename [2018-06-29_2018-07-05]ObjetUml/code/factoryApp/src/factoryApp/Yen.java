package factoryApp;

public class Yen implements IMoney {
	private final static double TAUX = 110.5;
	
	double somme = 0.0;
	
	public Yen(double somme) {
		this.somme = somme * TAUX;
	}

	@Override
	public void add(IMoney somme) {
		this.somme += somme.getDollar() * TAUX;
	}

	@Override
	public void sub(IMoney somme) {
		this.somme -= somme.getDollar() * TAUX;
	}

	@Override
	public String formattage() {
		return this.somme + " ¥";
	}
	@Override public double getDollar() 			{return this.somme / TAUX;}
	@Override public void setDollar(double dollar) 	{this.somme = dollar * TAUX;}
}
