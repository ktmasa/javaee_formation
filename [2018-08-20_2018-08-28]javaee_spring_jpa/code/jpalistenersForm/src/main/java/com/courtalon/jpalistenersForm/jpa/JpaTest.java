package com.courtalon.jpalistenersForm.jpa;

import java.time.LocalDate;
import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.courtalon.jpalistenersForm.beans.*;

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
		
		RapportIntervention r1 = new RapportIntervention(0, "serveur en feu", "reinstaller windows");
		RapportIntervention r2 = new RapportIntervention(0, "bourrage papier", "taper sur l'imprimante");
		em.persist(r1);
		em.persist(r2);
		
		em.persist(new Produit(0, "steak de lama des andes", 0.75, 29.99));
		em.persist(new Produit(0, "farine de boulgour veritable", 3.0, 8.99));
		
		em.persist(new Personne(0, "vincent", LocalDate.of(1976, 10, 2)));
		
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
		RapportIntervention r1 = em.find(RapportIntervention.class, 1);
		r1.setContenu("utiliser la lance à incendie");
		em.persist(new RapportIntervention(0, "email bloqué", "vider la corbeille outlook"));
		
		System.out.println("-----------------------------------------------------------------");
		TypedQuery<Produit> q1 = em.createQuery("from Produit", Produit.class);
		List<Produit> prods = q1.getResultList();
		for (Produit p : prods)
			System.out.println(p);
		
		System.out.println(em.find(Personne.class, 1) + " ans");
		
		//----------------------------------------------------
		tx.commit();
		em.close();
	}

}
