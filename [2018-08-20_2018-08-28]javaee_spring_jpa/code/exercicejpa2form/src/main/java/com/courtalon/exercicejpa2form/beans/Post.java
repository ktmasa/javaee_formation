package com.courtalon.exercicejpa2form.beans;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString
@Entity
public class Post {
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id									private int id;
										private String titre;
										private String corps;
	@Temporal(TemporalType.DATE)		private Date dateCreation;
	@ManyToOne							private Auteur auteur;
	@ManyToOne							private Categorie categorie;
										
	
	public Post(int id, String titre, String corps, Date dateCreation) {
		super();
		this.id = id;
		this.titre = titre;
		this.corps = corps;
		this.dateCreation = dateCreation;
	}
	public Post(int id, String titre, String corps, Date dateCreation,
			Auteur auteur, Categorie categorie) {
		super();
		this.id = id;
		this.titre = titre;
		this.corps = corps;
		this.dateCreation = dateCreation;
		this.auteur = auteur;
		this.categorie = categorie;
	}


}
