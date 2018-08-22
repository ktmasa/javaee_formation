package com.courtalon.exercicejpa4form.beans;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString(callSuper=true)
@Entity
public class Image extends Contenu {
									private String fileName;
									private String typeImage;
	@ManyToOne						private Galerie galerie;
	
	
	public Image(int id, String nom, LocalDateTime dateCreation, LocalDateTime dateEdition, String fileName,
			String typeImage) {
		super(id, nom, dateCreation, dateEdition);
		this.fileName = fileName;
		this.typeImage = typeImage;
	}
	
	
}
