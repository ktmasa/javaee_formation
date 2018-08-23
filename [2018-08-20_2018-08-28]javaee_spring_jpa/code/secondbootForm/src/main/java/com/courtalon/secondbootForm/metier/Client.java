package com.courtalon.secondbootForm.metier;

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
public class Client {
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id 					private int id;
							private String nom;
							private String prenom;
							private String email;

}
