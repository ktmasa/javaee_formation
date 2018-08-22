package com.courtalon.exercicejpa4form.beans;

import java.time.LocalDateTime;

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
@Inheritance(strategy=InheritanceType.JOINED)
public class Contenu {
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id 												private int id;
														private String nom;
														private LocalDateTime dateCreation;
														private LocalDateTime dateEdition;
	
	
	public Contenu(int id, String nom, LocalDateTime dateCreation, LocalDateTime dateEdition) {
		super();
		this.id = id;
		this.nom = nom;
		this.dateCreation = dateCreation;
		this.dateEdition = dateEdition;
	}

	
}
