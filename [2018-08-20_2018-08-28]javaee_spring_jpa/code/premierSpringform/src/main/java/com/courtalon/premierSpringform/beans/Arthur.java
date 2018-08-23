package com.courtalon.premierSpringform.beans;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Arthur implements FournisseurQuete {

	private List<String> libelles;
	private Random rd;
	
	// fichier contenant les libelles quetes
	public Arthur(File libelleFile) {
		// lire les lignes dans le fichier
		libelles = new ArrayList<>();
		libelles.add("faire le tour des tavernes");
		libelles.add("collecter les taxes");
		libelles.add("installer les routes pavées");
		libelles.add("faire un tour de garde");
		
		/*libelles = new ArrayList<>();
		try {
			Scanner reader = new Scanner(libelleFile);
			while(reader.hasNextLine()) {
				// et les ajouter dans "libelles"
				libelles.add(reader.nextLine());
			}
			reader.close();	
		} catch (FileNotFoundException e) {e.printStackTrace();}*/
		rd = new Random();
	}
	
	
	@Override
	public Quete fournirNouvelleQuete() {
		Quete q = new Quete();
		q.setLibelle(libelles.get(rd.nextInt(libelles.size())));
		return q;
	}

}
