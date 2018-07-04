package factoryApp;


public class Dollar implements IMoney {
	double somme = 0.0;
	
	public Dollar(double somme) {
		this.somme = somme;
	}
	
	@Override
	public void add(IMoney somme) {
		this.somme += somme.getDollar();
	}
	@Override
	public void sub(IMoney somme) {
		this.somme -= somme.getDollar();
	}
	@Override
	public String formattage() {
		return this.somme + " $";
	}

	@Override	public double getDollar() {	return somme;}
	@Override	public void setDollar(double dollar) {this.somme = dollar;}

}
