package com.courtalon.referentielarticlejpaform.jpa;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.courtalon.referentielarticlejpaform.beans.*;

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
		
		Famille f1 = new Famille(0, "imprimantes");
		Famille f2 = new Famille(0, "ecrans");
		
		//em.persist(f1);
		//em.persist(f2);
		
		//em.persist(f1);
		//em.persist(f2);
		
		Article a1 = new Article(0, "brother BL2154", 245.99);
		a1.setFamille(f1);
		Article a2 = new Article(0, "laissemarque LM12345", 75.99);
		a2.setFamille(f1);
		Article a3 = new Article(0, "flatron w2242S", 159.99);
		a3.setFamille(f2);
		
		/*f1.getArticles().add(a1);
		f1.getArticles().add(a2);
		f2.getArticles().add(a3);
		*/
		
		
		em.persist(a1);
		em.persist(a2);
		em.persist(a3);
		
	
		
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
		
		Article a1 = em.find(Article.class, 1);
		System.out.println("-------------------------");
		System.out.println(a1.getNom());
		
		System.out.println("-------------------------");
		System.out.println(a1.getFamille().getLibelle());
		
		// je peut bien sur modifier l'objet associé
		// il mettra à jour la clé étrangère
		Famille f3 = new Famille(0, "imprimantes jet encre");
		em.persist(f3);
		a1.setFamille(f3);
		
		
		
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
		Famille f1 = em.find(Famille.class, 1);
		System.out.println(f1);
		
		System.out.println(f1.getLibelle());
		
		em.remove(f1);
		
		
		//----------------------------------------------------
		tx.commit();
		em.close();
		// ATTENTION, NE MARCHE PAS SI LAZY LOADING
		// car l'entity manager n'est plus accessible pour
		// requeter la base
		/*System.out.println("--------------------------------");
		for (Article a : f1.getArticles()) {
			System.out.println(a.getNom());
		}*/
	}

}
