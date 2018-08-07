package com.courtalon.exercice8Form;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.courtalon.exercice8Form.metier.Produit;
import com.courtalon.exercice8Form.repositories.ProduitRepository;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(
		 			   "jdbc:mysql://localhost:3306/base_produits",
		 			   "root",
		 			   "");
	 	   System.out.println("connection réussie!!");
	 	   ProduitRepository repo = new ProduitRepository(connection);
	 	   
	 	   Scanner sc = new Scanner(System.in);
	 	   System.out.println("BIENVENUE SUR SUPER PRODUCT MANAGER!! (bio edition)");
	 	   while (true) {
	 		   System.out.println("que voulez vous faire ?");
	 		   System.out.println(" l) lister les produits");
	 		   System.out.println(" e) editer un produit produit");
	 		   System.out.println(" a) ajouter un produit");
	 		   System.out.println(" d) effacer un produit");
	 		   System.out.println(" c) chercher un produit par libelle");
	 		   System.out.println(" p) chercher un produit par prix");
	 		   System.out.println(" q) quitter");
	 		   String choix = sc.nextLine().substring(0, 1).toLowerCase();
	 		   switch(choix) {
		 		   case "l":
		 			   System.out.println("liste des produits");
		 			   List<Produit> prods1 = repo.findAll();
		 			   for (Produit p : prods1) 
		 				   System.out.println(p);
		 			   break;
		 		   case "e":
		 			   System.out.println("id du produit à éditer ? ");
		 			   int pid = Integer.parseInt(sc.nextLine());
		 			   Produit pedit = repo.findOne(pid);
		 			   if (pedit == null) {
		 				   System.out.println("ce produit est épuisé");
		 				   break;
		 			   }
		 			   System.out.println(pedit);
		 			   saisieProduit(pedit);
		 			   System.out.println(pedit);
		 			   repo.save(pedit);
		 			   System.out.println("sauvegarde effectuée");
		 			   break;
		 		   case "a":
		 			   System.out.println("saisie d'un nouveau produit");
		 			   Produit pnew = new Produit(0,"",0.0,0.0);
		 			   saisieProduit(pnew);
		 			   System.out.println(pnew);
		 			   repo.save(pnew);
		 			   System.out.println("sauvegarde effectuée");
		 			   break;
		 		   case "q":
		 			   System.out.println("au revoir!");
		 			   connection.close();
		 			   return;
		 		   case "d":
		 			  System.out.println("id du produit à effacer ? ");
		 			  pid = Integer.parseInt(sc.nextLine());
		 			  repo.delete(pid);
		 			  System.out.println("produit effacé");
		 			  break;
		 		   case "c":
		 			   System.out.println("terme a rechercher ? ");
		 			   String searchTerm = sc.nextLine();
		 			   prods1 = repo.searchByLibelle(searchTerm);
		 			   for (Produit p : prods1)
		 				   System.out.println(p);
		 			   break;
		 		   default:
		 				System.out.println("choix inconnu");
	 		   }
	 	   }

		} catch (ClassNotFoundException e) {e.printStackTrace();}
		 catch (SQLException e) {e.printStackTrace();}
    }
    
    public static void saisieProduit(Produit p) {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("nouveau libelle (entree pour ne pas modifier)?");
    	String saisie = sc.nextLine();
    	if (saisie.length() > 0)
    		p.setLibelle(saisie);
    	
    	System.out.println("nouveau prix (entree pour ne pas modifier)?");
    	saisie = sc.nextLine();
    	if (saisie.length() > 0) {
    		p.setPrix(Double.parseDouble(saisie));
    	}
    	
    	System.out.println("nouveau poids (entree pour ne pas modifier)?");
    	saisie = sc.nextLine();
    	if (saisie.length() > 0) {
    		p.setPoids(Double.parseDouble(saisie));
    	}
    }
}
