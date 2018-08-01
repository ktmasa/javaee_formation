package exercice5_Form.echecs;

public class Pion extends Piece {

	
	public Pion(int colonne, int ligne, EchecCouleur couleur) {
		super(colonne, ligne, couleur);
	}

	@Override
	public String getDeplacementsPossible() {
		// vers le bas
		if (getCouleur() == EchecCouleur.Blanche) {
			int newLigne = getLigne() + 1;
			if (newLigne <= 8) {
				return getColonneLabel(getColonne()) + newLigne;
			}
			return ""; 
		}
		// vers le haut
		else {
			int newLigne = getLigne() - 1;
			if (newLigne >= 1) {
				return getColonneLabel(getColonne()) + newLigne;
			}
			return ""; 
		}
	}

	@Override
	public String toString() {
		return "Pion [" + getColonneLabel(getColonne()) + getLigne() 
					+ " couleur =" + getCouleur()
				+ "]";
	}
	
	

}
