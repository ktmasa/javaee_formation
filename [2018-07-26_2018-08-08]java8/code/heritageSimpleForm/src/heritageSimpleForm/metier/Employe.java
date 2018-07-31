package heritageSimpleForm.metier;

import java.time.LocalDate;

public class Employe extends Personne {
	private String poste;
	private double salaire;
	
	public String getPoste() {return poste;}
	public void setPoste(String poste) {this.poste = poste;}
	public double getSalaire() {return salaire;}
	public void setSalaire(double salaire) {this.salaire = salaire;}
	
	public Employe() {}
	public Employe(String nom, String prenom, LocalDate dateNaissance, String poste, double salaire) {
		super(nom, prenom, dateNaissance);
		this.poste = poste;
		this.salaire = salaire;
	}
	
	@Override
	public String toString() {
		//return super.super.
		return "Employe [poste=" + poste + ", salaire=" + salaire + ", getNom()=" + getNom() + ", getPrenom()="
				+ getPrenom() + ", getDateNaissance()=" + getDateNaissance() + "]";
	}
	
	@Override
	public String toCsvLine() {
		return super.toCsvLine() + "," + this.poste + "," + this.salaire;
	}

	
	
	
	
	
	
}
