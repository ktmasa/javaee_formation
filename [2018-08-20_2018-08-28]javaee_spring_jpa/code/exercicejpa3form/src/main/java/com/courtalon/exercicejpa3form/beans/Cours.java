package com.courtalon.exercicejpa3form.beans;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString(exclude= {"matiere", "professeur", "etudiants"})
@Entity
public class Cours {
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id 										private int id;
												private String libelle;
												private LocalDate dateDebut;
												private int capaciteMax;
	@ManyToOne									private Matiere matiere;
	@ManyToOne									private Professeur professeur;
	
	/*@JoinTable(name="participations",
			joinColumns = @JoinColumn(name="Idcours"),
			inverseJoinColumns = @JoinColumn(name="IdEtudiant")
	)*/
	@ManyToMany									private Set<Etudiant> etudiants;
	
	
	public void addEtudiant(Etudiant et) {
		if (etudiants == null) {
			etudiants = new HashSet<>();
		}
		etudiants.add(et);
	}
	
	
	public Cours(int id, String libelle, LocalDate dateDebut, int capaciteMax, Matiere matiere, Professeur professeur) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.dateDebut = dateDebut;
		this.capaciteMax = capaciteMax;
		this.matiere = matiere;
		this.professeur = professeur;
	}
	
	
	

}
