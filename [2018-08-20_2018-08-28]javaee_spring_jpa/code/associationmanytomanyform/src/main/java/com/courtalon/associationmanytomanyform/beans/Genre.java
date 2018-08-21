package com.courtalon.associationmanytomanyform.beans;

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

@Getter @Setter @NoArgsConstructor @ToString(exclude= {"films"})
@Entity
public class Genre {
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id									private int id;
										private String libelle;
	@ManyToMany(mappedBy="genres")		private Set<Film> films;
	
	
	public Genre(int id, String libelle) {
		super();
		this.id = id;
		this.libelle = libelle;
	}
	
	

}
