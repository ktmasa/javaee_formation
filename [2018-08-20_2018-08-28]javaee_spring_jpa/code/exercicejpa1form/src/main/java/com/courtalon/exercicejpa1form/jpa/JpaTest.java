package com.courtalon.exercicejpa1form.jpa;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.courtalon.exercicejpa1form.beans.*;
import com.mysql.jdbc.StandardSocketFactory;

public class JpaTest {

	private static Livre lvr = null;
	
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
		test2(emf);

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
		Livre l1 = new Livre(0, "java commando", "134532145", 350, 39.99);
		Livre l2 = new Livre(0, "opera pour les nuls", "244532145", 225, 29.99);
		Livre l3 = new Livre(0, "cuisine extreme", "28852145", 175, 19.99);
		Livre l4 = new Livre(0, "litterature facile", "987987987", 725, 59.99);
		
		em.persist(l1);
		em.persist(l2);
		em.persist(l3);
		em.persist(l4);
		
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
		
		TypedQuery<Livre> q1 = em.createQuery(
				"select lv from Livre lv where lv.prix > :pmin",
				Livre.class);
		Scanner reader = new Scanner(System.in);
		double saisie = Double.parseDouble(reader.nextLine());
		q1.setParameter("pmin", saisie);
		List<Livre> livres = q1.getResultList();
		
		// affichage des livres dont le prix est > à prixmin
		livres.stream().forEach(lv -> System.out.println(lv));
		
		
		
		System.out.println("-----------------------------------------");
		// affiche le livre no 1
		Livre lv2 = em.find(Livre.class, 1);
		System.out.println(lv2);
		
		lv2.setNbPages(600);
		System.out.println("------------------------------------");
		lv2.setNbPages(450);
		lv2.setIsbn("555568745");
		System.out.println("------------------------------------");
		//----------------------------------------------------
		tx.commit();
		em.close();
		// ce livre est maintenant dans un état "détaché"
		lv2.setNbPages(800);
		
		lvr = lv2;
		
	}

	public static void test3(EntityManagerFactory emf)
	{
		// on recupere un entityManager
		EntityManager em = emf.createEntityManager();
		// et une transaction
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		//----------------------------------------------------
		lvr.setIsbn("87987987987");
		System.out.println(lvr);
		
		Livre lv1 = em.merge(lvr);
		
		//----------------------------------------------------
		tx.commit();
		em.close();
	
		
	}
}
