package com.courtalon.jpalistenersForm.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostLoad;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString
@Entity
public class Produit {
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id 												private int id;
														private String nom;
														private double poids;
														private double prix;
	@Transient											private double prixLivraison;
	
	// appeler cette méthode dés qu'un produit est chargé depuis la base
	@PostLoad
	public void calculPrixLivraison() {
		// prix livraison = prix + tva et 1.5 euros par kilos
		setPrixLivraison(getPrix() * 1.2 + getPoids() * 1.5);
	}
	
	
	public Produit(int id, String nom, double poids, double prix) {
		super();
		this.id = id;
		this.nom = nom;
		this.poids = poids;
		this.prix = prix;
	}
	

}
