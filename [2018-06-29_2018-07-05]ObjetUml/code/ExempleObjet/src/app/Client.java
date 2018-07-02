package app;

import java.time.LocalDate;

public class Client extends Personne {
	private int noClient;
	private String email;
	
	public Client(String nom, String prenom, LocalDate dateNaissance, int noClient, String email) {
		super(nom, prenom, dateNaissance);
		this.noClient = noClient;
		this.email = email;
	}
	
	public void prospecter(String message) {
		System.out.println("envoie " + message + " à " + this.email);
	}
	
	
}
