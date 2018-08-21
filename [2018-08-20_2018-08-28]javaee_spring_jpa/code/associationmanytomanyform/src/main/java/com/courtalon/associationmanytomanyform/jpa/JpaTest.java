package com.courtalon.associationmanytomanyform.jpa;

import java.time.LocalDate;
import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.courtalon.associationmanytomanyform.beans.*;

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

       /* input.nextLine();
		System.out.println("--------------------------------------");
		test2(emf);
*/
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
	
		Acteur a1 = new Acteur(0, "Dujardin", "Jean");
		Acteur a2 = new Acteur(0, "Belmondo", "paul");
		Acteur a3 = new Acteur(0, "VanDamme", "jean-claude");
		
		Genre g1 = new Genre(0, "action");
		Genre g2 = new Genre(0, "comédie");
		Genre g3 = new Genre(0, "art martiaux");
		
		em.persist(a1);
		em.persist(a2);
		em.persist(a3);
		
		em.persist(g1);
		em.persist(g2);
		em.persist(g3);
		
		
		Film f1 = new Film(0, "Rio ne répond plus", LocalDate.of(2012, 10, 15), 115);
		f1.addActeur(a1);
		f1.addGenre(g2);
		f1.addGenre(g1);
		em.persist(f1);
		
		Film f2 = new Film(0, "nid d'espion en chine", LocalDate.of(2005, 11, 9), 130);
		f2.addActeur(a1);
		f2.addActeur(a3);
		f2.addGenre(g2);
		f2.addGenre(g3);
		em.persist(f2);
		
		Film f3 = new Film(0, "attaque des sushis tueurs", LocalDate.of(2010, 11, 9), 95);
		f3.addActeur(a2);
		f3.addActeur(a3);
		f3.addGenre(g1);
		f3.addGenre(g3);
		em.persist(f3);
		
		Film f4 = new Film(0, "guerre des smartphones", LocalDate.of(2003, 11, 9), 140);
		f4.addActeur(a1);
		f4.addActeur(a2);
		f4.addGenre(g2);
		em.persist(f4);
		
		
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
		
		TypedQuery<Film> q1 = em.createQuery("select f from Film f", Film.class);
		List<Film> films = q1.getResultList();
		for (Film f : films) {
			System.out.println(f);
			//System.out.println(f.getActeurs());
		}

		//-----------------------------------------------------------------

		System.out.println("genre de film recherché ?");
		Scanner reader = new Scanner(System.in);
		String genre = reader.nextLine();
		TypedQuery<Film> q2 = em.createQuery(
				"select f from Film f join f.genres g where g.libelle=:libelle",
				Film.class);
		q2.setParameter("libelle", genre);
		
		films = q2.getResultList();
		for (Film f : films) {
			System.out.println(f);
			//System.out.println(f.getActeurs());
		}
		System.out.println("-----------------------------------");
		// je ne suis pas obligé de requeter les objet entité complets
		Query q3 = em.createQuery("select f.titre, f.dateSortie from Film f");
		List<Object[]> results = q3.getResultList();
		for (Object[] ligne : results) {
			System.out.println(Arrays.toString(ligne));
		}
		// lister les acteurs avec le nombre de films auquels ils ont participé
		System.out.println("------------------------------------");
		Query q4 = em.createQuery("select a.id, a.nom, count(f.id) from Acteur a "
								+ "	join a.films as f group by a.id");
		results = q4.getResultList();
		for (Object[] ligne : results) {
			System.out.println(Arrays.toString(ligne));
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
		
		Acteur a1 = em.find(Acteur.class, 1);
		//a1.removeFilmActeur();
		em.remove(a1);
		
		
		//----------------------------------------------------
		tx.commit();
		em.close();
	}

	
}
