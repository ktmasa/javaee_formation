package com.courtalon.associationmanytomanyform.beans;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PreRemove;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString(exclude= {"films"})
@Entity
public class Acteur {
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id										private int id;
											private String nom;
											private String prenom;
	@ManyToMany(mappedBy="acteurs"/*, cascade=CascadeType.REMOVE*/)			private Set<Film> films;
	
	
	// méthode à appeler avant la supression d'un acteur
	@PreRemove
	public void removeFilmActeur() {
		for (Film f : this.films) {
			f.getActeurs().remove(this);
		}
		this.films.clear();
	}
	
	public Acteur(int id, String nom, String prenom) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
	}
	
	
}
