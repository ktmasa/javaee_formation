package exercice3_Form;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import exercice3_Form.metier.Produit;

public class App {

	public static void main(String[] args) throws FileNotFoundException {
		
		ArrayList<Produit> produits = new ArrayList<>();
		Scanner input = new Scanner(System.in);
		
		while(true) {
			System.out.println("que voulez vous faire ?");
			System.out.println("a) ajouter produit");
			System.out.println("d) supprimer ligne no");
			System.out.println("l) lister les produits");
			System.out.println("s) sauver les produits");
			System.out.println("c) charger les produits");
			System.out.println("q) quitter");
			String choix = input.nextLine().substring(0, 1).toLowerCase();
			switch(choix) {
				case "a":
					produits.add(creerProduit());
					break;
				case "d":
					System.out.println("quelle ligne ?");
					int noLigne = Integer.parseInt(input.nextLine());
					produits.remove(noLigne);
					System.out.println("effacement fait");
					break;
				case "l":
					listerProduit(produits);
					break;
				case "s":
					Produit.saveAllToCSVFile(produits, "produits.csv");
					System.out.println("sauvegarde effectuée!");
					break;
				case "c":
					produits = Produit.loadAllFromCSVFile("produits.csv");
					System.out.println("chargement effectué!");
					break;
				case "q":
					System.out.println("bye bye");
					return;
			}
			
		}
	

	}

	public static void listerProduit(ArrayList<Produit> produits) {
		for (Produit p : produits)
			System.out.println(p);
	}
	
	public static Produit creerProduit() {
		Scanner input = new Scanner(System.in);
		System.out.println("nom produit ? ");
		String nom = input.nextLine();
		System.out.println("prix produit ? ");
		double prix = Double.parseDouble(input.nextLine());
		System.out.println("poids produit ? ");
		double poids = Double.parseDouble(input.nextLine());
		return new Produit(nom, prix, poids);
	}
}
