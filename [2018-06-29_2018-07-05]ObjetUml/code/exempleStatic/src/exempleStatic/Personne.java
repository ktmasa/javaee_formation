package exempleStatic;

import java.time.LocalDate;

public class Personne {
	private static int nbPersonnes = 0;
	
	private String nom;
	private String prenom;
	private LocalDate dateNaissance;
	
	public String getNom() {return nom;}
	public void setNom(String nom) {this.nom = nom;}
	public String getPrenom() {return prenom;}
	public void setPrenom(String prenom) {this.prenom = prenom;}
	public LocalDate getDateNaissance() {return dateNaissance;}
	public void setDateNaissance(LocalDate dateNaissance) {this.dateNaissance = dateNaissance;}
	
	public Personne(String nom, String prenom, LocalDate dateNaissance) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		// cette variable est partagée par l'ensemble des personnes
		nbPersonnes += 1;
	}
	
	@Override
	public String toString() {
		return "Personne [nom=" + nom + ", prenom=" + prenom + ", dateNaissance=" + dateNaissance + "]";
	}
	
	
	// une méthode static n'est pas liée à une instance de Personne, donc
	// pas d'accès aux attributs d'instance nom, prenom, dateNaissance
	public static int getNbPersonnes() {
		
		return nbPersonnes;
	}
	
	
	

}
