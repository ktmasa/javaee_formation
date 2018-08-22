package com.courtalon.heritageJpaForm.beans;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString(callSuper=true)
@Entity
public class Client extends Personne {
	private String email;
	private double soldeCompte;
	
	
	public Client(int id, String nom, String prenom, String email, double soldeCompte) {
		super(id, nom, prenom);
		this.email = email;
		this.soldeCompte = soldeCompte;
	}
	
}
