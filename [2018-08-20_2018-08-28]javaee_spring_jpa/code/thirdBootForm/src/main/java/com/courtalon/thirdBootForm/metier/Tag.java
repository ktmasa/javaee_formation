package com.courtalon.thirdBootForm.metier;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
@Entity
public class Tag {
	@Id @GeneratedValue
	private int id;
	private String libelle;
	@JsonIgnore
	@ManyToMany(mappedBy="tags") private Set<Article> articles;

}
