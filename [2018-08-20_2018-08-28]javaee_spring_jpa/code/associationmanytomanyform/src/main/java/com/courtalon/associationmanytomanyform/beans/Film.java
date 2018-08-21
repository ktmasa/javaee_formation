package com.courtalon.associationmanytomanyform.beans;

import java.time.LocalDate;
import java.util.HashSet;
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

@Getter @Setter @NoArgsConstructor @ToString(exclude= {"acteurs", "genres"})
@Entity
public class Film {
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id									private int id;
										private String titre;
										private LocalDate dateSortie;
										private int dureeMinute;
										
	@ManyToMany							private Set<Acteur> acteurs;
	@ManyToMany							private Set<Genre> genres;
	
	public void addActeur(Acteur a) {
		if (this.acteurs == null)
			this.acteurs = new HashSet<>();
		this.acteurs.add(a);
	}
	
	public void addGenre(Genre g) {
		if (this.genres == null)
			this.genres = new HashSet<>();
		this.genres.add(g);
	}
	
	
	public Film(int id, String titre, LocalDate dateSortie, int dureeMinute) {
		super();
		this.id = id;
		this.titre = titre;
		this.dateSortie = dateSortie;
		this.dureeMinute = dureeMinute;
	}
	
	
	
}
