package com.courtalon.exercicejpa2form.beans;

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

@Getter @Setter @NoArgsConstructor @ToString(exclude= {"posts"})
@Entity
public class Categorie {
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id										private int id;
											private String libelle;
	@OneToMany(mappedBy="categorie")		private Set<Post> posts;
	
	
	public Categorie(int id, String libelle) {
		super();
		this.id = id;
		this.libelle = libelle;
	}
}
