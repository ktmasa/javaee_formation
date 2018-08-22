package com.courtalon.exercicejpa4form.beans;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString(callSuper=true)
@Entity
public class Galerie extends Contenu {
									private String titre;
	@OneToMany(mappedBy="galerie")	private Set<Image> images;
	
	public Galerie(int id, String nom, LocalDateTime dateCreation, LocalDateTime dateEdition, String titre) {
		super(id, nom, dateCreation, dateEdition);
		this.titre = titre;
	}
	
	
}
