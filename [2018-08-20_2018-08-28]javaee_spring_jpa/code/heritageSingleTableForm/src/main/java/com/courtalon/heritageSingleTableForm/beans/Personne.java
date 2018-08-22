package com.courtalon.heritageSingleTableForm.beans;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)   // stratégie de mapping pour heritage
@DiscriminatorColumn(name="typePersonne", discriminatorType=DiscriminatorType.INTEGER)
@DiscriminatorValue("1")
public class Personne {
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id 								private int id;
										private String nom;
										private String prenom;
	
	
	public Personne(int id, String nom, String prenom) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
	}
	

}
