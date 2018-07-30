package exercice2_DForm;

import java.util.Arrays;

public class App {

	public static void main(String[] args) {
		
		String texte_mat = "1 12 -3 4\n5 4 -7 23\n2 0 0 5";
		System.out.println(texte_mat);
		
		int[][] mat = texte_to_mat(texte_mat);
		System.out.println(Arrays.deepToString(mat));
		mat[1][2] = 453;
		System.out.println(Arrays.deepToString(mat));
	}
	
	
	public static int[][] texte_to_mat(String texte) {
		String lignes[] = texte.split("\n");
		int[][] matrice = null;
		for (int ligne = 0; ligne < lignes.length; ligne++ ) {
			String champs[] = lignes[ligne].split(" ");
			// creer le tableau lors du demarrage de l'ananlyse
			if (ligne == 0) {
				matrice = new int[lignes.length] [champs.length];
			}
			for (int colonne = 0; colonne < champs.length; colonne++) {
				matrice[ligne][colonne] = Integer.parseInt(champs[colonne]);
			}
		}
		return matrice;
	}

}
