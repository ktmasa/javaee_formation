package app;

import java.time.LocalDate;

public class Personne {
	public String nom;
	public String prenom;
	private LocalDate dateNaissance;
	
	public Personne(String nom, String prenom, LocalDate dateNaissance) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
	}
	
	public LocalDate getDateNaissance() {
		return this.dateNaissance;
	}
	
	public void contacter() {
		System.out.println("bonjour, " + this.nom 
							+ " " + this.prenom 
							+ " né le " + this.dateNaissance);
	}
}
