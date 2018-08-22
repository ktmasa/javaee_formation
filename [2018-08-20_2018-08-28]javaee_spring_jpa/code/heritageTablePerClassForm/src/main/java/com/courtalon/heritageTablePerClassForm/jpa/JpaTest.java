package com.courtalon.heritageTablePerClassForm.jpa;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


import com.courtalon.heritageTablePerClassForm.beans.*;

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
		em.persist(new Personne(0, "bob", "joe"));
		em.persist(new Personne(0, "marcelus", "wallas"));
		
		em.persist(new Client(0, "uzumaki", "naruto", "ramen@gmail.com", 1500));
		em.persist(new Client(0, "haruno", "sakura", "sakura@gmail.com", 1700));
		
		em.persist(new Employe(0, "stark", "tony", "ceo", 100000));
		em.persist(new Employe(0, "parker", "peter", "journaliste", 1300));
		

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
		TypedQuery<Client> q1 = em.createQuery("from Client", Client.class);
		List<Client> clients = q1.getResultList();
		for (Client c : clients) {
			System.out.println(c);
		}
		
		System.out.println("---------------------------------");
		TypedQuery<Personne> q2 = em.createQuery("from Personne", Personne.class);
		List<Personne> peoples = q2.getResultList();
		for (Personne p : peoples) {
			System.out.println(p);
		}
		
		System.out.println("---------------------------------");
		Employe tony = em.find(Employe.class, 5);
		em.remove(tony);
		
		
		
		//----------------------------------------------------
		tx.commit();
		em.close();
	}

}
