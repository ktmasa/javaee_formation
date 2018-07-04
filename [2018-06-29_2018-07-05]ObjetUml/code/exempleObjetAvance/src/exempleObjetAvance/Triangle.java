package exempleObjetAvance;

public class Triangle extends Figure {

	private int taille;
	
	public int getTaille() {return taille;}
	public void setTaille(int taille) {this.taille = taille;}

	public Triangle(int x, int y, int taille) {
		super(x, y);
		this.taille = taille;
	}
	
	@Override
	public final void dessiner() {
		System.out.println("dessin de triangle de taille " + this.getTaille());
	}

}
