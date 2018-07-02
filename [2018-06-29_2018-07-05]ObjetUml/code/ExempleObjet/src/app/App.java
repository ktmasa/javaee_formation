package app;

import java.time.LocalDate;

public class App {

	public static void main(String[] args) {
		Personne p1 = new Personne("courtalon", "vincent", LocalDate.of(1976, 10, 2));
		
		p1.contacter();
		p1.prenom = "bobby";
		p1.contacter();
		//p1.dateNaissance = LocalDate.of(1986, 10, 2);
		
		Client c1 = new Client("Willis",
								"bruce",
								LocalDate.of(1955, 3, 19),
								42,
								"bruce@nakatomiplaza.com");
		c1.prospecter("nouveau gel rasage! ");
		// la méthode contacter est héritée depuis la classe personne pour mon client
		c1.contacter();
		
		Personne p2 = c1;
		p2.contacter();
		
		Employe e1 = new Employe("Dujardin",
								"jean",
								LocalDate.of(1972, 6, 19), 
								"jardinier",
								1299.99);
		
		e1.contacter();
		
		Personne p3 = e1;
		// le polymorphisme
		// une méthode peut avoir plusieurs "forme", suivant le type réel de l'instance
		p3.contacter();
		
		p3 = c1;
		p3.contacter();
		
		
	}

}
