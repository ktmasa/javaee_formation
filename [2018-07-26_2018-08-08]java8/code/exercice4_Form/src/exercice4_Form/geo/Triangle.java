package exercice4_Form.geo;

public class Triangle extends Figure {
	private int taille;
	
	public int getTaille() {return taille;}
	public void setTaille(int taille) {this.taille = taille;}

	public Triangle(int taille) {
		this(BORD_DEFAUT, CENTRE_DEFAUT, taille);	
	}
	
	public Triangle(char bord, char centre, int taille) {
		super(bord, centre);
		this.taille = taille;
	}
	
	@Override
	public void afficher() {
		for (int ligne = 0; ligne < taille; ligne++) {
			for (int colonne = 0; colonne < taille - ligne; colonne++) {
				if (ligne == 0 || colonne == 0 || colonne == taille - ligne - 1)
					System.out.print(getBord());
				else
					System.out.print(getCentre());
			}
			System.out.println();
		}
	}

	// final devant une méthode permet d'interdire
	// son override par les descendants
	@Override
	public final double getSurface() {
		return taille * taille / 2.0;
	}

	@Override
	public void scale(double factor) {
		this.taille *= factor;
	}

}
