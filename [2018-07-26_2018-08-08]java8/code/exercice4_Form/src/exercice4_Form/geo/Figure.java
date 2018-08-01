package exercice4_Form.geo;

public abstract class Figure {
	public static final char BORD_DEFAUT = '*';
	public static final char CENTRE_DEFAUT = '-';
	
	private char bord;
	private char centre;
	
	public Figure(char bord, char centre) {
		super();
		this.bord = bord;
		this.centre = centre;
	}

	public char getBord() {return bord;}
	public void setBord(char bord) {this.bord = bord;}
	public char getCentre() {return centre;}
	public void setCentre(char centre) {this.centre = centre;} 

	public abstract void afficher();
	public abstract double getSurface();
	public abstract void scale(double factor);

	

}
