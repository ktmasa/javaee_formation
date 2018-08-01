package parcourSystemeFichierForm;

import java.io.File;

public class App {

	public static void main(String[] args) {
		
		File repertoire = new File("C:\\eclipse");
		
		// on peut verifier plein d'informations sur l'emplacement indiqué
		System.out.println("existe il ? " + repertoire.exists());
		System.out.println("est ce un fichier ? " + repertoire.isFile());
		System.out.println("est ce un repertoire ? " + repertoire.isDirectory());
		
		if (repertoire.exists() && repertoire.isDirectory()) {
			File[] contenu = repertoire.listFiles();
			
			for (File f : contenu) {
				System.out.print(f.getName());
				System.out.print("  " + (f.isDirectory()? "REP" : "FIC"));
				if (f.isFile()) {
					// taille en octets du fichier
					System.out.print(" " + f.length());
				}
				System.out.println();
			}
			
		}
		

	}

}
