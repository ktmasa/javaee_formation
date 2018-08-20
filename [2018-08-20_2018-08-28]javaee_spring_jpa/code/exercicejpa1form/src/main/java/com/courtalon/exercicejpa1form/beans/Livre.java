package com.courtalon.exercicejpa1form.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString
@Entity
@Table(name="books")
public class Livre {
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id									private int id;
										private String titre;
	@Column(length=40, nullable=false)	private String isbn;
										private int nbPages;
										private double prix;
	
	public Livre(int id, String titre, String isbn, int nbPages, double prix) {
		this.id = id;
		this.titre = titre;
		this.isbn = isbn;
		this.nbPages = nbPages;
		this.prix = prix;
	}

	
	
}
