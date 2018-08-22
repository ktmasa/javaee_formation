package com.courtalon.jpalistenersForm.beans;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostLoad;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString
@Entity
public class Personne {
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id					private int id;
						private String nom;
						private LocalDate dateNaissance;
	@Transient			private int age;
	
	
	@PostLoad
	public void calculAge() {
		setAge(LocalDate.now().getYear() - getDateNaissance().getYear());
	}
	
	public Personne(int id, String nom, LocalDate dateNaissance) {
		super();
		this.id = id;
		this.nom = nom;
		this.dateNaissance = dateNaissance;
	}
	
	

}
