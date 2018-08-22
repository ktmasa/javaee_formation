package com.courtalon.inclusionsJpaForm.beans;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString
@Entity
public class Trajet {
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id 								private int id;
										private String libelle;
	@AttributeOverrides( {
		@AttributeOverride(name="longitude", column= @Column(name="DEPART_LONGITUDE")),
		@AttributeOverride(name="latitude", column= @Column(name="DEPART_LATITUDE"))
	}
	)									
	@Embedded							private Localisation depart;
	@AttributeOverrides( {
		@AttributeOverride(name="longitude", column= @Column(name="DEST_LONGITUDE")),
		@AttributeOverride(name="latitude", column= @Column(name="DEST_LATITUDE"))
	}
	)
	@Embedded							private Localisation destination;
	
	
	public Trajet(int id, String libelle, Localisation depart, Localisation destination) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.depart = depart;
		this.destination = destination;
	}
	
	
}
