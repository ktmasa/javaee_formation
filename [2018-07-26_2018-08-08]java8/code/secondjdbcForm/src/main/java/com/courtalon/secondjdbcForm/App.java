package com.courtalon.secondjdbcForm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import com.courtalon.secondjdbcForm.metier.Livre;
import com.courtalon.secondjdbcForm.repositories.LivreRepository;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	// chargement de la classe du driver
 	   try {
 		   Class.forName("com.mysql.jdbc.Driver");
			// ouverture de la connection a la base de donnée
	 	   Connection connection = DriverManager.getConnection(
	 			   "jdbc:mysql://localhost:3306/base_fnoc",
	 			   "root",
	 			   "");
	 	   // on est connecté à la base!
	 	   System.out.println("connection réussie!!");
	 	   
	 	   // instancier le repository
	 	   LivreRepository repo = new LivreRepository(connection);
	 	   
	 	   List<Livre> livres = repo.findAll();
	 	   for (Livre l : livres) {
	 		   System.out.println(l);
	 	   }
	 	   System.out.println("-------------------------------------");
	 	   Livre lvr = repo.findById(3);
	 	   System.out.println(lvr);
	 	   
	 	   lvr = new Livre(0, "l'ile au trésor", "87645354", "R.L.Stevenson", 400);
	 	   repo.save(lvr);
	 	   
	 	   
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
