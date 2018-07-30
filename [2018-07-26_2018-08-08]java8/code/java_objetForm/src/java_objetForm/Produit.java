package java_objetForm;

public class Produit {
	
	public int id;
	public String nom;
	public double prix;
	public double poids;

	// en java, un constructeur est une méthode qui a le MEME nom que la classe
	// et aucun type de retour
	// cette méthode sera automatiquement appelée par java quand on fera un "new"
	// sur l'objet
	public Produit() {
		this(0, "inconnu", 0.01, 0.01); // chainage de constructeur
		/*this.nom = "inconnu";
		this.poids = 0.01;
		this.prix = 0.01;*/
	}
	
	// 2 eme constructeur
	public Produit(int id, String nom, double prix, double poids) {
		this.id = id;
		this.nom = nom;
		this.prix = prix;
		this.poids = poids;
	}
	
	// methode ou operation de l'objet Produit
	public void afficher() {
		System.out.println(this.id + ", " + nom + " prix= " + prix + " et poids = " + poids);
		
	}
}
