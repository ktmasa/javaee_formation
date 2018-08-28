package com.courtalon.thirdBootForm.metier;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString(exclude= {"famille", "tags"})
@Entity
public class Article {
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id 						private int id;
								private String nom;
								private String marque;
								private LocalDate dateCreation;
	@ManyToOne					private Famille famille;
	@ManyToMany					private Set<Tag> tags;
	
	
	
	public Article(int id, String nom, String marque, LocalDate dateCreation, Famille famille) {
		super();
		this.id = id;
		this.nom = nom;
		this.marque = marque;
		this.dateCreation = dateCreation;
		this.famille = famille;
	}



	public Article(int id, String nom, String marque, LocalDate dateCreation) {
		super();
		this.id = id;
		this.nom = nom;
		this.marque = marque;
		this.dateCreation = dateCreation;
	}




	
	
	

}
