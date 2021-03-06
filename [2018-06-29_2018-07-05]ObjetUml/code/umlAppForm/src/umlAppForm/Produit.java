package umlAppForm;
/**
 * 
 * @author Stagiaire
 * 
 * @startuml
 *
 * Object <|-- Produit
 * 
 * Catalogue "1" *-- "n" Produit : contient
 * 
class Produit {
	-int id
	-String nom
	-double prix
	+int getId()
	+void setId(int id)
	+String getNom()
	+void setNom(String nom)
	+double getPrix()
	+void setPrix(double prix)
	+Produit(int id, String nom, double prix)
	+String toString()
}
 * @enduml
 * 
 * @startuml
 * 
 */
public class Produit {
	private int id;
	private String nom;
	private double prix;
	
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	public String getNom() {return nom;}
	public void setNom(String nom) {this.nom = nom;}
	public double getPrix() {return prix;}
	public void setPrix(double prix) {this.prix = prix;}
	
	public Produit(int id, String nom, double prix) {
		this.id = id;
		this.nom = nom;
		this.prix = prix;
	}
	
	@Override
	public String toString() {
		return "Produit [id=" + id + ", nom=" + nom + ", prix=" + prix + "]";
	}
	
	
	
}
