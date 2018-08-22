package com.courtalon.exercicejpa3form.beans;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString(exclude= {"courses"})
@Entity
public class Etudiant {
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id 											private int id;
													private String nom;
													private String prenom;
													private String email;
	@ManyToMany(mappedBy="etudiants")				private Set<Cours> courses;
	
	
	
	public Etudiant(int id, String nom, String prenom, String email) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
	}

}
