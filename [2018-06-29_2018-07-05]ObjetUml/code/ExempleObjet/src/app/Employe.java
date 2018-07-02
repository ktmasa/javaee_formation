package app;

import java.time.LocalDate;

public class Employe extends Personne {

	private String poste;
	public double salaire;
	
	
	public Employe(String nom, String prenom, LocalDate dateNaissance, String poste, double salaire) {
		super(nom, prenom, dateNaissance);
		this.poste = poste;
		this.salaire = salaire;
	}
	
	public void travailler() {
		System.out.println("au travail! " + this.nom);
	}

	@Override
	public void contacter() {
		System.out.println("l'employee " + this.nom + " est demandé au poste " + this.poste );
	}
	
	
	
}
