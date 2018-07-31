package heritageSimpleForm.metier;

import java.time.LocalDate;

public class Personne {
	private String nom;
	private String prenom;
	private LocalDate dateNaissance;
	
	public String getNom() {return nom;}
	public void setNom(String nom) {this.nom = nom;}
	public String getPrenom() {return prenom;}
	public void setPrenom(String prenom) {this.prenom = prenom;}
	public LocalDate getDateNaissance() {return dateNaissance;}
	public void setDateNaissance(LocalDate dateNaissance) {this.dateNaissance = dateNaissance;}
	
	public Personne() {}
	public Personne(String nom, String prenom, LocalDate dateNaissance) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
	}
	
	@Override
	public String toString() {
		return "Personne [nom=" + nom + ", prenom=" + prenom + ", dateNaissance=" + dateNaissance + "]";
	}
	
	public String toCsvLine() {
		return getNom() + "," + getPrenom() + "," + getDateNaissance();
	}

}
