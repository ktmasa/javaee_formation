package com.courtalon.premierJdbcForm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       System.out.println("connection en cours....");
       try 
       {
    	   // chargement de la classe du driver
    	   Class.forName("com.mysql.jdbc.Driver");
    	   // ouverture de la connection a la base de donnée
    	   Connection connection = DriverManager.getConnection(
    			   "jdbc:mysql://localhost:3306/base_fnoc",
    			   "root",
    			   "");
    	   // on est connecté à la base!
    	   System.out.println("connection réussie!!");
    	   
    	   // le statement est l'objet permettant d'executer des requettes
    	   Statement statement = connection.createStatement();
    	   // le ResultSet est un "curseur" permettant de parcourir les enregistrement
    	   // renvoyé par l'execution de la requette, ligne par ligne
    	   ResultSet rs = statement.executeQuery("select * from `livre`");
    	   
    	   // parcourir les lignes renvoyée
    	   while (rs.next()) {
    		   System.out.println("titre = " + rs.getString("titre") 
    		   				+ " - auteur = " + rs.getString("auteur"));
    	   }
    	   // pour etre "propre" et ne pas consommer inutilement des ressources
    	   // fermer le resultset après usage
    	   rs.close();
    	   
    	   Scanner sc = new Scanner(System.in);
    	   System.out.println("récupérer les détails de quel livre (id) ? ");
    	   int id = Integer.parseInt(sc.nextLine());
    	   
    	   // NE PAS FAIRE CELA!!! PROBLEME POTENTIEL DE SECURITE et aussi performance
    	   String sql = "select * from `livre` where `id`=" + id;
    	   // execution de la request
    	   rs = statement.executeQuery(sql);
    	   while (rs.next()) {
    		   System.out.println("id = " + rs.getInt("id"));
    		   System.out.println("titre = " + rs.getString("titre"));
    		   System.out.println("auteur = " + rs.getString("auteur"));
    		   System.out.println("nbPages = " + rs.getInt("nb_pages"));
    		   System.out.println("isbn = " + rs.getString("isbn"));
    	   }
    	   rs.close();
    	   
    	   // utilisons plutot les requetes paramétrées
    	   // une requete contenant des '?' qui seront remplacé par les parametres
    	   // à l'execution
    	   // 1) c'est le driver mysql qui gère le controle de la syntaxe des parametre
    	   // 2) en cas de requete complexe, la requete est réutilisable en changeant
    	   //    la valeur des parametres à moindre cout
    	   
    	   
    	   System.out.println("nb_pages minimum ? ");
    	   int nb_pages = Integer.parseInt(sc.nextLine());
    	   
    	   // création de la requete paramétrée
    	   PreparedStatement ps = connection.prepareStatement(
    			   "select * from `livre` where `nb_pages`>?");
    	   
    	   // remplacement du premier parametre, c.a.d le premier '?' dans la requete
    	   ps.setInt(1, nb_pages);
    	   
    	   rs = ps.executeQuery();
    	   while (rs.next()) {
    		   System.out.println("titre = " + rs.getString("titre"));
    	   }
    	   rs.close();
    	   
    	   System.out.println("id du livre a supprimer ?");
    	   id = Integer.parseInt(sc.nextLine());
    	   PreparedStatement psDelete = connection.prepareStatement(
    			   "delete from `livre` where `id`=?");
    	   psDelete.setInt(1, id);
    	   
    	   int nbLigneDeleted = psDelete.executeUpdate();
    	   System.out.println("nb lignes effacées = " + nbLigneDeleted);
    	   
    	   /*
    	   System.out.println("id du livre ou changer le nombre de pages ?");
    	   id = Integer.parseInt(sc.nextLine());
    	   System.out.println("nouveau nombre de pages ? ");
    	   nb_pages = Integer.parseInt(sc.nextLine());
    	   PreparedStatement psUpdate = connection.prepareStatement(
    			   "update `livre` set `nb_pages`=? where `id`=?");
    	   psUpdate.setInt(1, nb_pages);
    	   psUpdate.setInt(2, id);
    	   
    	   int nbLignes = psUpdate.executeUpdate();
    	   System.out.println("nb lignes mises à jours = " + nbLignes);
    	   */
    	   
    	   /*
    	   // exemple d'insertion
    	   System.out.println("nouveau livre à insérer");
    	   System.out.println("titre ? ");
    	   String titre = sc.nextLine();
    	   System.out.println("auteur ? ");
    	   String auteur = sc.nextLine();
    	   System.out.println("isbn ? ");
    	   String isbn = sc.nextLine();
    	   System.out.println("nb_pages ? ");
    	   nb_pages = Integer.parseInt(sc.nextLine());
    	   
    	   PreparedStatement psInsert = connection.prepareStatement(
    		"insert into `livre` (`titre`, `auteur`, `isbn`, `nb_pages`) VALUES (?,?,?,?)"
    			   );
    	   psInsert.setString(1, titre);
    	   psInsert.setString(2, auteur);
    	   psInsert.setString(3, isbn);
    	   psInsert.setInt(4, nb_pages);
    	   
    	   // executeUpdate -> toutes requetes modifiant la base
    	   //  insert, update, delete
    	   // renvoie le nombre de lignes afféctées par la requete
    	   int nbLignes = psInsert.executeUpdate();
    	   System.out.println("nb lignes insérées = " + nbLignes);
    	   
    	   */
    	   
    	   
    	   
    	   
    	   
    	   /*
    	    * JDBC -> java database connector
    	    * 
    	    * mysq, oracle, posgressql....
    	    * 
    	    */
    	   // le package java.sql continet toutes les classes/interfaces pour sql
    	   // non spécifique
    	   // chaque driver ajoute ses propres classes dans son propre package
    	   // com.mysql.Connection ....
    	   // les classes spécifiques à la base de donnée implémente les interface
    	   // générale de java.sql
    	   
    	   
    	   
    	   
    	   connection.close();
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
       
    }
}
