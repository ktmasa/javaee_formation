package javaObjet2Form;

import java.time.LocalDateTime;

import javaObjet2Form.metier.Intervention;

public class App {

	public static void main(String[] args) {
		System.out.println("compteur = " + Intervention.getCompteurId());
		
		Intervention i1 = new Intervention("1234567", "bob", LocalDateTime.now());
		Intervention i2 = new Intervention("5678912", "max", LocalDateTime.now());
		
		System.out.println(i1);
		System.out.println(i2);
		
		System.out.println("compteur = " + Intervention.getCompteurId());
		
	}

}
