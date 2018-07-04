package factoryApp;

public interface IMoney {
	
	void add(IMoney somme);
	void sub(IMoney somme);
	String formattage();
	double getDollar();
	void setDollar(double dollar);
}
