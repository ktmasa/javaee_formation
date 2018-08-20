package com.courtalon.referentielarticlejpaform.beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString(exclude= {"articles"})
@Entity
public class Famille {
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id									private int id;
										private String libelle;
	// le mappedBy référence l'attribut dont est le mirroir, ici la
	// propriété "famille" dans l'objet Article
	@OneToMany(mappedBy="famille",
			 fetch=FetchType.EAGER /*,
			 cascade= {CascadeType.REMOVE}*/)	private Set<Article> articles;
	// par defaut, OneToMany est en Lazy Loading (chargement paresseux)
	
	// on creer automatiquement une collection vide d'article
	// si celle -ci n'existe pas
	public Set<Article> getArticles() {
		if (articles == null) {
			articles = new HashSet<>();
		}
		return articles;
	}
	
	
	public Famille(int id, String libelle) {
		this.id = id;
		this.libelle = libelle;
	}
	
}
