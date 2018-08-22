package com.courtalon.inclusionsJpaForm.beans;

import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString
@Embeddable
public class Localisation {
	private double longitude;
	private double latitude;
	
	
	public Localisation(double longitude, double latitude) {
		super();
		this.longitude = longitude;
		this.latitude = latitude;
	}

}
