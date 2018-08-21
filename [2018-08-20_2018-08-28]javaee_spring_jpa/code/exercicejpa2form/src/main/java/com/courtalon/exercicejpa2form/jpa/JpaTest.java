package com.courtalon.exercicejpa2form.jpa;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.courtalon.exercicejpa2form.beans.*;

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
		Auteur a1 = new Auteur(0, "norris", "chuck", "chuck@texas.com");
		Auteur a2 = new Auteur(0, "einstein", "albert", "albert@spaceflight.com");
		
		Categorie c1 = new Categorie(0, "sport");
		Categorie c2 = new Categorie(0, "science");
		
		em.persist(a1);
		em.persist(a2);
		em.persist(c1);
		em.persist(c2);
		
		Random rd = new Random();
		for (int i = 1; i <= 20; i++) {
			Post p = new Post(0, "post " + i, "balh blah " + i, new Date());
			
			if (rd.nextBoolean())
				p.setAuteur(a1);
			else
				p.setAuteur(a2);
			
			if (rd.nextBoolean())
				p.setCategorie(c1);
			else
				p.setCategorie(c2);
			
			em.persist(p);
		}
		
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
		
		TypedQuery<Post> q1 = em.createQuery(
				"select p from Post p", Post.class);
		//q1.setFirstResult(10);
		//q1.setMaxResults(20);
		List<Post> posts = q1.getResultList();
		for (Post p : posts) {
			System.out.println(p.getTitre() + " - " + p.getAuteur().getNom());
		}
		
		System.out.println("--------------");
		Categorie cat1 = em.find(Categorie.class, 1);
		System.out.println(cat1);
		for (Post p : cat1.getPosts()) {
			System.out.println(p);
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
		
		TypedQuery<Post> q1 = em.createQuery(
				"select p from Post p where p.auteur.id = :aid",
				Post.class);
		q1.setParameter("aid", 1);
		
		List<Post> posts = q1.getResultList();
		for (Post p : posts) {
			System.out.println(p.getTitre() + " - " + p.getAuteur().getNom());
		}
		
		//----------------------------------------------------
		tx.commit();
		em.close();
	}
}
