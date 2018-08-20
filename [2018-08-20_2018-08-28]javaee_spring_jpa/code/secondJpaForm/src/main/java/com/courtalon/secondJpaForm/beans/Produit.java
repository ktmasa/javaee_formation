package com.courtalon.secondJpaForm.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString
@Entity
@Table(name="products")  // le nom de la table est personnalisable
public class Produit {
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id  						private int id;
	@Column(length=100)			private String nom;
								private double prix;
	@Column(name="WEIGHT")		private double poids;
	
	public Produit(int id, String nom, double prix, double poids) {
		this.id = id;
		this.nom = nom;
		this.prix = prix;
		this.poids = poids;
	}
	

}
