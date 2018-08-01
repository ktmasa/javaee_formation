package exercice5_Form.echecs;

public class Fou extends Piece {

	public Fou(int colonne, int ligne, EchecCouleur couleur) {
		super(colonne, ligne, couleur);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getDeplacementsPossible() {
		StringBuilder sb = new StringBuilder();
		sb.append(generateDeplacement(1, 1));
		sb.append(generateDeplacement(1, -1));
		sb.append(generateDeplacement(-1, -1));
		sb.append(generateDeplacement(-1, 1));
		return sb.toString();
	}

	@Override
	public String toString() {
		return "Fou [" + getColonneLabel(getColonne()) + getLigne() 
					+ " couleur =" + getCouleur()
				+ "]";
	}
}
