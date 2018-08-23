package com.courtalon.firstspringbootForm.metier;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
@Entity
public class Produit {
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id 				private int id;
						private String nom;
						private double prix;
						private double poids;

}
