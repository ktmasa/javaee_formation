package com.courtalon.secondJpaForm.jpa;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.courtalon.secondJpaForm.beans.*;

public class JpaTest {

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("testHibernate");
        Scanner input = new Scanner(System.in);

        input.nextLine();
        System.out.println("--------------------------------------");
		test1(emf);

        input.nextLine();
		System.out.println("--------------------------------------");
		test3(emf);

        input.nextLine();
		System.out.println("--------------------------------------");		

	    emf.close();
		System.out.println("done...");
	}




	public static void test1(EntityManagerFactory emf)
	{
		// on recupere un entityManager
		EntityManager em = emf.createEntityManager();
		// et une transaction
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		//----------------------------------------------------
		// insertion en base
		
		Produit p1 = new Produit(0, "steak de lama", 19.99, 0.75);
		Produit p2 = new Produit(0, "tofu tout fou", 29.99, 0.55);
		Produit p3 = new Produit(0, "miel des carpathes", 8.99, 1.0);
		Produit p4 = new Produit(0, "biere d'algues", 5.99, 0.75);
		
		// em.persist -> insertion de nouvel objet en base
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		em.persist(p4);
		System.out.println("produits crées");
		
		//----------------------------------------------------
		tx.commit();
		em.close();
	}


	public static void test2(EntityManagerFactory emf)
	{
		// on recupere un entityManager
		EntityManager em = emf.createEntityManager();
		// et une transaction
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		//----------------------------------------------------
		
		// requette JPA sur des produits
		// 1er argument -> la requette
		// 2eme argument -> l'entité requeté (sa classe)
		TypedQuery<Produit> q1 = em.createQuery("from Produit", Produit.class);
		// execution de la requete
		List<Produit> produits = q1.getResultList();
		// affichage
		for (Produit p : produits) {
			System.out.println(p);
		}
		System.out.println("quel produit modifier (id)? ");
		Scanner reader = new Scanner(System.in);
		int id = Integer.parseInt(reader.nextLine());
		
		// chercher un produit via sa clé primaire
		Produit prod = em.find(Produit.class, id);
		
		if (prod != null) {
			System.out.println("produit trouvé");
			// modification du nom du produit
			System.out.println("nouveau nom du produit ? ");
			prod.setNom(reader.nextLine());
		}
		else {
			System.out.println("produit inconnu");
		}
		
		System.out.println("produit a supprimer (id) ?");
		id = Integer.parseInt(reader.nextLine());
		prod = em.find(Produit.class, id);
		if (prod != null) {
			System.out.println("suppression de " + prod);
			// delete dans la base
			em.remove(prod);
		}
		
		
		//----------------------------------------------------
		tx.commit();
		em.close();
	}

	public static void test3(EntityManagerFactory emf)
	{
		// on recupere un entityManager
		EntityManager em = emf.createEntityManager();
		// et une transaction
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		//----------------------------------------------------
		System.out.println("poids minimum ?");
		Scanner reader = new Scanner(System.in);
		double poids = Double.parseDouble(reader.nextLine());
		
		TypedQuery<Produit> q1 = em.createQuery(
				"select p from Produit p where p.poids > :poidsmin",
				Produit.class);
		// :nom_param est l'equivalent des ? dans les requetes paramétrées
		// la différence est que les parametres sont nommées, et non numérotés
		// le ':' est indispensable, c'est ce qui indique qu'il s'agit d'un parametre de la
		// requete
		q1.setParameter("poidsmin", poids);
		// execution de la requete
		List<Produit> produits = q1.getResultList();
		
		for (Produit p : produits) {
			System.out.println(p);
		}
		
		//----------------------------------------------------
		tx.commit();
		em.close();
	}
}
