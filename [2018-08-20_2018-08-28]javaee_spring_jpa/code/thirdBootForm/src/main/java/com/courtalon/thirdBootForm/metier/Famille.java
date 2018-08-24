package com.courtalon.thirdBootForm.metier;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString(exclude="articles")
@Entity
public class Famille {
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id 											private int id;
													private String libelle;
	@JsonIgnore	@OneToMany(mappedBy="famille")		private Set<Article> articles;
	
	public Famille(int id, String libelle) {
		super();
		this.id = id;
		this.libelle = libelle;
	}
	
}
