package java_objetForm;

public class Article {
	
	// private permet d'interdire l'accès externe
	// a mes attributs/méthodes
	
	private int id;
	private String nom;
	private double prix;
	
	
	public Article(int id, String nom, double prix) {
		this.id = id;
		this.nom = nom;
		setPrix(prix);
	}
	
	// accesseur en lecture pour le champs id, c'est un getter
	public int getId() {
		return this.id;
	}
	// en ecriture
	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getPrix() {
		return prix;
	}

	// le setter controle que l'on ne fixe pas un prix negatif
	// si le prix voule est négatif, on le repasse à 0 avant de l'ecrire
	public void setPrix(double prix) {
		this.prix = (prix >= 0)? prix : 0.0;
	}
	
	
	
	
	

}
