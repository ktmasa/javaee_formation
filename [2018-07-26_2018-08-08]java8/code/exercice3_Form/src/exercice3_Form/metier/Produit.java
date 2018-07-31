package exercice3_Form.metier;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Produit {
	private static final double POIDS_MAX = 10.0;
	
	// id est une constante d'instance
	// elle ne peut être "ecrite" que dans le constructeur
	// c'est même obligatoire
	private final int id;
	private String nom;
	private double prix;
	private double poids;
	
	private static int nextId = 1;
	
	public Produit( String nom, double prix, double poids) {
		this(nextId++, nom, prix, poids);
	}	
	
	public Produit(int id, String nom, double prix, double poids) {
		super();
		this.id = id;
		this.nom = nom;
		this.prix = prix;
		setPoids(poids);
	}
	public int getId() {return id;}
	//public void setId(int id) {this.id = id;}
	public String getNom() {return nom;}
	public void setNom(String nom) {this.nom = nom;}
	public double getPrix() {return prix;}
	public void setPrix(double prix) {this.prix = prix;}
	public double getPoids() {return poids;}
	public void setPoids(double poids) {
		this.poids = (poids <= POIDS_MAX)? poids : POIDS_MAX;
	}

	public static Produit fromCSVLine(String line) {
		String[] champs = line.split(",");
		return new Produit(Integer.parseInt(champs[0]),
						   champs[1],
						   Double.parseDouble(champs[2]),
						   Double.parseDouble(champs[3]));
	}
	
	public static ArrayList<Produit> loadAllFromCSVFile(String fileName) 
											throws FileNotFoundException {
		int maxid = 1;
		Scanner reader = new Scanner(new File(fileName));
		ArrayList<Produit> produits = new ArrayList<>();
		
		while (reader.hasNextLine()) {
			Produit p = Produit.fromCSVLine(reader.nextLine());
			// on memorise le plus grand ID rencontré au chargement
			if (p.getId() > maxid)
				maxid = p.getId();
			produits.add(p);
		}
		nextId = maxid + 1;
		return produits;
	}
	
	
	public String toCSVLine() {
		return getId() + "," +
				getNom() + "," +
				getPrix() + "," +
				getPoids();
	}
	
	public static void saveAllToCSVFile(ArrayList<Produit> data, String fileName) 
			throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(fileName);
		for(Produit p : data) {
			pw.println(p.toCSVLine());
		}
		pw.close();
		return;
	}
	
	
	@Override
	public String toString() {
		return "Produit [id=" + id + ", nom=" + nom + ", prix=" + prix + ", poids=" + poids + "]";
	}
	
	

}
