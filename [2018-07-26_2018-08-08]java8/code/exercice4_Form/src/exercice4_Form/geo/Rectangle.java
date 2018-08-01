package exercice4_Form.geo;

// classe finale, elle ne peut pas avoir de descendant
public final class Rectangle extends Figure {
	private int longueur;
	private int hauteur;
	
	public int getLongueur() {return longueur;}
	public void setLongueur(int longueur) {this.longueur = longueur;}
	public int getHauteur() {return hauteur;}
	public void setHauteur(int hauteur) {this.hauteur = hauteur;}
	
	public Rectangle(char bord, char centre, int longueur, int hauteur) {
		super(bord, centre);
		this.longueur = longueur;
		this.hauteur = hauteur;
	}
	
	@Override
	public void afficher() {
		for (int ligne = 0; ligne < hauteur; ligne++) {
			for (int colonne = 0; colonne < longueur; colonne++) {
				if (ligne == 0 || 
					colonne == 0 ||
					colonne == longueur - 1 ||
					ligne == hauteur - 1)
					System.out.print(getBord());
				else
					System.out.print(getCentre());
			}
			System.out.println();
		}
	}

	@Override
	public double getSurface() {
		return longueur * hauteur;
	}

	@Override
	public void scale(double factor) {
		longueur *= factor;
		hauteur *= factor;
	}

}
