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
public class Auteur {
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id										private int id;
											private String nom;
											private String prenom;
											private String email;
	@OneToMany(mappedBy="auteur")			private Set<Post> posts;
	
	
	public Auteur(int id, String nom, String prenom, String email) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
	}

	
}
