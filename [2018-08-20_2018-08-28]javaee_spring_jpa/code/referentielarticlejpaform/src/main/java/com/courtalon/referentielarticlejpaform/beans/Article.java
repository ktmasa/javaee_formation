package com.courtalon.referentielarticlejpaform.beans;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString
@Entity
public class Article {
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id										private int id;
											private String nom;
											private double prix;
	@Temporal(TemporalType.DATE)			private Date dateCreation;
											
	// n -> 1
	// JoinColumn permet de modifier la clé etrangère par défaut
	// par exemple son nom 
	@JoinColumn(name="FAMILY_ID")
	@ManyToOne(cascade= {CascadeType.PERSIST})	private Famille famille;
	// par defaut, manyToOne est en Eager Loading, ou chargement gourmand
	
	public Article(int id, String nom, double prix) {
		this.id = id;
		this.nom = nom;
		this.prix = prix;
	}

}
