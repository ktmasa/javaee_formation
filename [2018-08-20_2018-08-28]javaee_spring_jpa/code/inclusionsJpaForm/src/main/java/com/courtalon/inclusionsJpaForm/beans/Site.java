package com.courtalon.inclusionsJpaForm.beans;

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
public class Site {
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id 					private int id;
							private String nom;
	@Embedded				private Localisation loc;
	
	
	public Site(int id, String nom, Localisation loc) {
		super();
		this.id = id;
		this.nom = nom;
		this.loc = loc;
	}
	

}
