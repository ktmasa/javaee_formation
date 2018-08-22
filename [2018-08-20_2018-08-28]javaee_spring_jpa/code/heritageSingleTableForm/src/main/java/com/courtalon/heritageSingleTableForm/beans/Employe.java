package com.courtalon.heritageSingleTableForm.beans;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString(callSuper=true)
@Entity
@DiscriminatorValue("2")
public class Employe extends Personne {
	/*@Column(nullable=false)*/ private String poste;
	private double salaire;
	
	
	public Employe(int id, String nom, String prenom, String poste, double salaire) {
		super(id, nom, prenom);
		this.poste = poste;
		this.salaire = salaire;
	}
}
