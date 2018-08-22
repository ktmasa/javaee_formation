package com.courtalon.heritageTablePerClassForm.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.TableGenerator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString
@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)   // stratégie de mapping pour heritage
public class Personne {
	
	@TableGenerator(
			name="personne_sequence",
			table="mes_sequences",
			pkColumnName="nom_sequence",
			valueColumnName="compteur_courant",
			pkColumnValue="personne",
			allocationSize=1000,
			initialValue=1
	)
	@GeneratedValue(strategy=GenerationType.TABLE, generator="personne_sequence")
	@Id 								private int id;
										private String nom;
										private String prenom;
	
	
	public Personne(int id, String nom, String prenom) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
	}
	

}
