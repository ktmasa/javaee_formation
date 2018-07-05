package builderApp;

import java.util.ArrayList;
import java.util.List;

public class OrdinateurBuilder {
	public static final String RESEAU_10MBIT = "reseau 10 mbits";
	public static final String RESEAU_100MBIT = "reseau 100 mbits";
	public static final String RESEAU_1GBIT = "reseau 1 gbits";
	
	
	private List<String> currentHdd;
	private int currentRam;
	private String currentEcran;
	private boolean currentClavier;
	private boolean currentSouris;
	private String currentReseau;
	
	
	public OrdinateurBuilder() {
		currentHdd = new ArrayList<>();
		currentRam = 4096;
		currentClavier = true;
		currentSouris = true;
	}
	
	public OrdinateurBuilder addHdd(String hdd) {
		if (currentHdd.size() < 8)
			currentHdd.add(hdd);
		return this;
	}
	public OrdinateurBuilder addRAM(int ram) {
		currentRam += ram;
		if (currentRam > 65536)
			currentRam = 65536;
		return this;
	}
	public OrdinateurBuilder setClavier(boolean clavier) {
		currentClavier = clavier;
		if (!currentClavier && !currentSouris)
			currentSouris = true;
		return this;
	}
	
	public OrdinateurBuilder setSouris(boolean souris) {
		currentSouris = souris;
		if (!currentClavier && !currentSouris)
			currentClavier = true;
		return this;
	}
	
	public OrdinateurBuilder setReseau(String typereseau) {
		this.currentReseau = typereseau;
		return this;
	}
	
	// la methode build
	public Ordinateur build() {
		// si aucun dique dur, en mettre un par defaut
		if (currentHdd.isEmpty())
			currentHdd.add("disque 500Go");
		Ordinateur o = new Ordinateur(currentRam, currentHdd.get(0));
		o.setClavier(currentClavier);
		o.setSouris(currentSouris);
		o.setEcran("ecran lcd");
		o.setReseau(currentReseau);
		// copier le reste des disques durs dans l'oridnateur
		currentHdd.remove(0);
		o.getHdd().addAll(currentHdd);
		return o;
				
	}
	
	

}
