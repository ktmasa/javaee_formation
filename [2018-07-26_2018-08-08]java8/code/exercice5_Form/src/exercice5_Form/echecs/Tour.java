package exercice5_Form.echecs;

public class Tour extends Piece {

	public Tour(int colonne, int ligne, EchecCouleur couleur) {
		super(colonne, ligne, couleur);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getDeplacementsPossible() {
		StringBuilder sb = new StringBuilder();
		// deplacement vers la droite
		sb.append(generateDeplacement(1, 0));
		// deplacement vers la gauche
		sb.append(generateDeplacement(-1, 0));
		// deplacement vers le haut
		sb.append(generateDeplacement(0, -1));
		// deplacement vers le bas
		sb.append(generateDeplacement(0, 1));
				
		return sb.toString();
	}
	
	@Override
	public String toString() {
		return "Tour [" + getColonneLabel(getColonne()) + getLigne() 
					+ " couleur =" + getCouleur()
				+ "]";
	}
	
}
