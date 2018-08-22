package com.courtalon.jpalistenersForm.beans;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString
@Entity
public class RapportIntervention {
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id 								private int id;
										private String titre;
										private String contenu;
										private LocalDateTime createdAt;
										private LocalDateTime updatedAt;
	

	// entity Listener
	// permet de speciier des fonctions a appeler à divers point du cyle de vie
	// d'une entite: chargement, mise a jour, effacement, creation....
	
	// avant insertion (persist)
	@PrePersist
	public void horodateCreation() {
		LocalDateTime maintenant = LocalDateTime.now();
		setCreatedAt(maintenant);
		setUpdatedAt(maintenant);
	}
	
	// avant mise à jour
	@PreUpdate
	public void horodateMiseAJour() {
		LocalDateTime maintenant = LocalDateTime.now();
		setUpdatedAt(maintenant);
	}
	
	public RapportIntervention(int id, String titre, String contenu) {
		super();
		this.id = id;
		this.titre = titre;
		this.contenu = contenu;
	}

	public RapportIntervention(int id, String titre, String contenu, LocalDateTime createdAt, LocalDateTime updatedAt) {
		super();
		this.id = id;
		this.titre = titre;
		this.contenu = contenu;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	
	
	

}
