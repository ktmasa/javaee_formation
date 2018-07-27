package exercice1_CForm;

public class App {

	public static void main(String[] args) {
		String texte = "Horum adventum praedocti speculationibus fidis"
				+ " rectores militum tessera data sollemni armatos omnes"
				+ " celeri eduxere procursu et agiliter praeterito Calycadni"
				+ " fluminis ponte, cuius undarum magnitudo murorum adluit"
				+ " turres, in speciem locavere pugnandi. neque tamen exiluit"
				+ " quisquam nec permissus est congredi. formidabatur enim"
				+ " flagrans vesania manus et superior numero et ruitura sine"
				+ " respectu salutis in ferrum";

		String separateurs = " ,;.";
		
		String mot_courant = "";
		String mot_le_plus_long = "";
		for (int pos = 0; pos < texte.length(); pos++) {
			char caractere_courant = texte.charAt(pos);
			// on termine un mot, voire s'il est plus long
			if (separateurs.indexOf(caractere_courant) != -1) {
				if (mot_courant.length() > mot_le_plus_long.length()) {
					mot_le_plus_long = mot_courant;
				}
				mot_courant = "";
			}
			// on est toujours dans un mot, continuer a le parcourir
			else {
				mot_courant += caractere_courant;
			}
		}
		
		if (mot_courant.length() > mot_le_plus_long.length()) {
			mot_le_plus_long = mot_courant;
		}
		
		System.out.println("le mot le plus long est : " + mot_le_plus_long);
		
	}

}
