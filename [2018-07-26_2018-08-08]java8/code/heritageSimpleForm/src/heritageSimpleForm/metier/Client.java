package heritageSimpleForm.metier;

import java.time.LocalDate;

public class Client extends Personne{
	
	private int noClient;
	private String email;
	
	public int getNoClient() {return noClient;}
	public void setNoClient(int noClient) {this.noClient = noClient;}
	public String getEmail() {return email;}
	public void setEmail(String email) {this.email = email;}
	
	public Client(String nom,
					String prenom,
					LocalDate dateNaissance,
					int noClient,
					String email) {
		// super permet de chainer vers un constructeur de moa classe parente
		// si on omet super ou this (aucun chainage définit), par defaut, c'est
		// comme si on avait super() -> chainage vers constructeur par defaut du parent
		// le chainage de constructeur est FORCEMENT la premiere instruction du constructeur
		super(nom, prenom, dateNaissance);
		this.noClient = noClient;
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "Client [noClient=" + noClient + ", email=" + email + ", getNom()=" + getNom() + ", getPrenom()="
				+ getPrenom() + ", getDateNaissance()=" + getDateNaissance() + "]";
	}
	
	
	@Override
	public String toCsvLine() {
		return super.toCsvLine() + ","
				+ noClient + ","
				+ email;
		
	/*	return this.getNom() + ","
				+ this.getPrenom() + ","
				+ this.getDateNaissance() + ","
				+ noClient + ","
				+ email;*/
	}
	
	

}
