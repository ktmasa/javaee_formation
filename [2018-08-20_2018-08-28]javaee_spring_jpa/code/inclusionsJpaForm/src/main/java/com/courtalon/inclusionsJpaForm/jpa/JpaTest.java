package com.courtalon.inclusionsJpaForm.jpa;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.courtalon.inclusionsJpaForm.beans.*;

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
		
		Localisation loc1 = new Localisation(40.0, 75.0);
		Localisation loc2 = new Localisation(45.0, 38.0);
		
		Site s1 = new Site(0, "zorglub corp", loc1);
		Site s2 = new Site(0, "omni consumer products", loc2);
		
		em.persist(s1);
		em.persist(s2);
		
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
		TypedQuery<Site> q1 = em.createQuery(
				"select s from Site s where s.loc.longitude > :lmin",
				Site.class);
		q1.setParameter("lmin", 42.0);
		List<Site> sites = q1.getResultList();
		for (Site s : sites) {
			System.out.println(s);
		}
		
		
		//----------------------------------------------------
		tx.commit();
		em.close();
	}

}
