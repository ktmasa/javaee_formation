package factoryApp;

public class Euro implements IMoney {
	private final static double TAUX = 1.16;
	
	double somme = 0.0;
	
	public Euro(double somme) {
		this.somme = somme / TAUX;
	}

	@Override
	public void add(IMoney somme) {
		this.somme += somme.getDollar() / TAUX;
	}

	@Override
	public void sub(IMoney somme) {
		this.somme -= somme.getDollar() / TAUX;
	}

	@Override
	public String formattage() {
		return this.somme + " €";
	}
	@Override public double getDollar() 			{return this.somme * TAUX;}
	@Override public void setDollar(double dollar) 	{this.somme = dollar / TAUX;}

}
