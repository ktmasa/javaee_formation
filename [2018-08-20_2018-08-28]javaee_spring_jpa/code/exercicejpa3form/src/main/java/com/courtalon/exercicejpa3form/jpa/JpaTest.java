package com.courtalon.exercicejpa3form.jpa;

import java.time.LocalDate;
import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.courtalon.exercicejpa3form.beans.*;

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
		Matiere[] matieres = {
				new Matiere(0, "java"),
				new Matiere(0, "opera"),
				new Matiere(0, "commando")
		};
		for (Matiere m : matieres)
			em.persist(m);
		
		Professeur[] profs = {
				new Professeur(0, "courlaton", "vincent", 1000),
				new Professeur(0, "pavarotti", "luciano", 1500),
				new Professeur(0, "steagal", "steven", 2000)
		};
		for (Professeur p : profs)
			em.persist(p);

		for (int i = 1; i <= 100; i++) {
			em.persist(new Etudiant(0, "bob"+ i, "joe"+ i, "bobjoe"+ i +" @gmail.com"));
		}
		
		Random rd = new Random();
		Cours[] courses = {
			new Cours(0, "java base", LocalDate.now(), rd.nextInt(30) + 15, matieres[0], profs[0]),
			new Cours(0, "java avance", LocalDate.now(), rd.nextInt(30) + 15, matieres[0], profs[0]),
			new Cours(0, "chant base", LocalDate.now(), rd.nextInt(30) + 15, matieres[1], profs[1]),
			new Cours(0, "chant expert", LocalDate.now(), rd.nextInt(30) + 15, matieres[1], profs[1]),
			new Cours(0, "chant de combat", LocalDate.now(), rd.nextInt(30) + 15, matieres[1], profs[1]),
			new Cours(0, "commando base", LocalDate.now(), rd.nextInt(30) + 15, matieres[2], profs[2]),
			new Cours(0, "commando jungle", LocalDate.now(), rd.nextInt(30) + 15, matieres[2], profs[2]),
			new Cours(0, "commando developeur", LocalDate.now(), rd.nextInt(30) + 15, matieres[2], profs[2]),
			new Cours(0, "java et opera", LocalDate.now(), rd.nextInt(30) + 15, matieres[1], profs[0]),
			new Cours(0, "angular sans voie", LocalDate.now(), rd.nextInt(30) + 15, matieres[0], profs[0])
		};
		
		for (Cours c : courses) {
			// je parcours tous les etudiants
			for (int i = 1; i <= 100; i++) {
				// une chance sur 4 que chaque etudiant participe a ce cours
				if (rd.nextDouble() > 0.75) {
					c.addEtudiant(em.find(Etudiant.class, i));
				}
			}
			em.persist(c);
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
		
		TypedQuery<Etudiant> q1 = em.createQuery("from Etudiant", Etudiant.class);
		List<Etudiant> etudiants = q1.getResultList();
		for (Etudiant et : etudiants)
			System.out.println(et);
		
		System.out.println("------------------------------------------------");
		TypedQuery<Cours> q2 = em.createQuery("from Cours", Cours.class);
		List<Cours> courses = q2.getResultList();
		for (Cours c : courses) {
			System.out.println(   c + " - " 
								+ c.getMatiere().getLibelle() + " - " 
								+ c.getProfesseur().getNom());
		}
		
		System.out.println("------------------------------------------------");
		Query q3 = em.createQuery("select cr.libelle, count(et.id) from Cours cr"
													+ " join cr.etudiants as et "
													+ " group by cr.libelle"); 
		List<Object[]> results = q3.getResultList();
		for (Object[] ligne : results) {
			System.out.println(Arrays.toString(ligne));
		}
		//----------------------------------------------------
		tx.commit();
		em.close();
	}

}
