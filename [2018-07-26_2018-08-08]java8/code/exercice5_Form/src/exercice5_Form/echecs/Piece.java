package exercice5_Form.echecs;

public abstract class Piece {
	public static final String colonnesLabel = "abcdefgh";
	public static String getColonneLabel(int col) {
		return colonnesLabel.substring(col -1, col);
	}
	
	private int colonne;
	private int ligne;
	private EchecCouleur couleur;
	
	
	
	public int getColonne() {return colonne;}
	public void setColonne(int colonne) {this.colonne = colonne;}
	public int getLigne() {return ligne;}
	public void setLigne(int ligne) {this.ligne = ligne;}
	public EchecCouleur getCouleur() {return couleur;}
	public void setCouleur(EchecCouleur couleur) {this.couleur = couleur;}
	
	public Piece(int colonne, int ligne, EchecCouleur couleur) {
		this.colonne = colonne;
		this.ligne = ligne;
		this.couleur = couleur;
	}
	// generateur de deplacement dans une direction
	public String generateDeplacement(int deplacementCol, int deplacementLig) {
		StringBuilder sb = new StringBuilder();
		int col = getColonne() + deplacementCol;
		int lig = getLigne() + deplacementLig;
		
		while(col >= 1 && col <= 8 && lig >=1 && lig <= 8) {
			sb.append(getColonneLabel(col) + lig + " ");
			col = col + deplacementCol;
			lig = lig + deplacementLig;
		}
		return sb.toString();
	}
	
	public abstract String getDeplacementsPossible();
	

}
