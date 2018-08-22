package com.courtalon.exercicejpa3form.beans;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString(exclude= {"courses"})
@Entity
public class Professeur {
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id 									private int id;
											private String nom;
											private String prenom;
											private double salaire;
	@OneToMany(mappedBy="professeur")		private Set<Cours> courses;
	
	
	public Professeur(int id, String nom, String prenom, double salaire) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.salaire = salaire;
	}
	
	

}
