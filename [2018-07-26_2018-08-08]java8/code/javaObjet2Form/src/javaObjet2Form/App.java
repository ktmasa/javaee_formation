package javaObjet2Form;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

import javaObjet2Form.metier.Intervention;

public class App {

	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("compteur = " + Intervention.getCompteurId());
		
		// tableau dynamique en java
		ArrayList<Intervention> tableau = new ArrayList<>();
		
		// pour ajouter un element dans un tableau dynamique, utiliser add()
		tableau.add(new Intervention("1234567", "bob", LocalDateTime.now()));
		tableau.add(new Intervention("5678912", "max", LocalDateTime.now()));
		
		System.out.println("taille tableau " + tableau.size());
		
		// get permet d'acceder a une case du tableau
		System.out.println(tableau.get(0));
		
		System.out.println(tableau.get(0).toCsvLine());
		
		System.out.println("compteur = " + Intervention.getCompteurId());
		
		// sauvegarde de toutes mes interventions
		//Intervention.saveAllInterventionsToCSV(tableau, "interventions.csv");
		
		System.out.println("--------------------------------------------");
		ArrayList<Intervention> loaded = Intervention.loadAllInterventionsFromCSV("interventions.csv");
		System.out.println(loaded);
		
		
		/*
		// la classe File represente un fichier ou repertoire dans le systeme de fichier
		File fichier = new File("test.txt");
		System.out.println("text.txt existe ? " + fichier.exists());
		// le printwriter permet d'ecrire simplement du texte dans un fichier
		PrintWriter pw = new PrintWriter(fichier);
		// ecrire une ligne dans le fichier
		pw.println("bonjour java!");
		// ne JAMAIS oublier de fermer le fichier quand on a fini
		// risque de ne pas ecrire pour de vrais si on ne le fait pas
		pw.close();
		
		// lecture de fichier texte
		Scanner reader = new Scanner(new File("src/javaObjet2Form/App.java"));
		// tant qu'il reste une ligne a lire
		while(reader.hasNextLine()) {
			// la lire et l'afficher
			System.out.println(reader.nextLine());
		}
		reader.close();
		*/
	}

}
