package com.courtalon.exercicejpa3form.beans;

import java.time.LocalDate;
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

@Getter @Setter @NoArgsConstructor @ToString(exclude= {"courses"})
@Entity
public class Matiere {
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id 										private int id;
												private String libelle;
	@OneToMany(mappedBy="matiere")				private Set<Cours> courses;
	
	
	
	public Matiere(int id, String libelle) {
		super();
		this.id = id;
		this.libelle = libelle;
	}
	

}
