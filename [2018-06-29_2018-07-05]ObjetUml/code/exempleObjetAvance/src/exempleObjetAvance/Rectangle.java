package exempleObjetAvance;

public final class Rectangle extends Figure {

	private int longueur;
	private int largeur;
	
	public int getLongueur() {return longueur;}
	public void setLongueur(int longueur) {this.longueur = longueur;}
	public int getLargeur() {return largeur;}
	public void setLargeur(int largeur) {this.largeur = largeur;}

	public Rectangle(int x, int y, int longueur, int largeur) {
		super(x, y);
		this.longueur = longueur;
		this.largeur = largeur;
	}
	
	// on a le droit d'augmenter la visibilité d'une méthode héritée en la remplacant
	// mais absolument pas de la diminuer, cela ne respecterait pas le "contrat" de la 
	// classe dont on herite
	@Override
	public void dessiner() {
		System.out.println("rectangle de longueur " + longueur);
	}

}
