package com.courtalon.exercicejpa4form.beans;

import java.time.LocalDateTime;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString(callSuper=true)
@Entity
public class DocumentPDF extends Contenu {
									private String titre;
									private String nomAuteur;
	
	
	public DocumentPDF(int id, String nom, LocalDateTime dateCreation, LocalDateTime dateEdition, String titre,
			String nomAuteur) {
		super(id, nom, dateCreation, dateEdition);
		this.titre = titre;
		this.nomAuteur = nomAuteur;
	}
	
	
}
