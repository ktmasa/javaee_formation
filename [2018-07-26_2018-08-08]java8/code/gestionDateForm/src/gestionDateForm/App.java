package gestionDateForm;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class App {

	public static void main(String[] args) {
		
		// la date courante
		Date d = new Date();
		
		System.out.println(d);
		// cette classe Date historique a beaucoup de problemes
		// 1) elle est BIZARRE
		
		Date d2 = new Date(1995, 2, 10);
		System.out.println(d2);

		// date -> annee + 1900, mois commence à 0!!!
		Date d3 = new Date(95, 1, 10);
		System.out.println(d3);

		// date est mutable
		d3.setDate(15);
		System.out.println(d3);
		
		// en interne , une date est représentée par un compteur de milliseconde
		// depuis 1e janvier 1970
		// on ne peut pas remonter avant 1900
		Date d4 = new Date(15, 2, 10);
		System.out.println(d4);
		
		// nouvelle api date java 8
		// java.time
		
		LocalDateTime ldt1 = LocalDateTime.of(1995, 2, 10, 10, 30);
		System.out.println(ldt1);
		
		LocalDate ld1 = LocalDate.of(2015, 10, 15);
		System.out.println(ld1);
		
		LocalDate ld2 = ld1.plusDays(40);
		System.out.println(ld2);
		
		Duration dr1 = Duration.ofMinutes(125);
		System.out.println(dr1);
		Duration dr2 = Duration.ofDays(5);
		System.out.println(dr2);
		
		//Instant
		
		// cela n'utilise pas le nombre de milliseconde en interne
		
		LocalDate ld3 = LocalDate.of(1615, 10, 15);
		System.out.println(ld3);
		
//		System.out.println(d5);

		java.sql.Date ds1 = new java.sql.Date(95, 1, 10);
		System.out.println(ds1);
		
		// pour convertir de java.utilDate a java.sql.Date -> utiliser new Date(d.getTime())
		// getTime -> nb milliseconde depuis 1er janvier 1970
		ds1 = new java.sql.Date(d3.getTime());
		System.out.println(ds1);
		
	}

}
