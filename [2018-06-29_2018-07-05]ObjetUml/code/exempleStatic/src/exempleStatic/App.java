package exempleStatic;

import java.time.LocalDate;

public class App {

	public static void main(String[] args) {
		System.out.println(Personne.getNbPersonnes());
		
		Personne p1 = new Personne("bob", "joe", LocalDate.of(1992, 10, 2));
		Personne p2 = new Personne("bob2", "joe2", LocalDate.of(1994, 10, 2));
		
		System.out.println(p1);
		System.out.println(p2);
		
		System.out.println(Personne.getNbPersonnes());
		

	}

}
