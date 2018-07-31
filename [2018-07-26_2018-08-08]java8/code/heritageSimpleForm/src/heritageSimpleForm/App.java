package heritageSimpleForm;

import java.time.LocalDate;

import heritageSimpleForm.metier.Client;
import heritageSimpleForm.metier.Employe;
import heritageSimpleForm.metier.Personne;

public class App {

	public static void main(String[] args) {
	
		Client c1 = new Client("bob",
								"joe",
								LocalDate.of(1980, 11, 3),
								42,
								"bob@joe.com");
		
		System.out.println(c1);
		//System.out.println(c1.toCsvLine());
		// la relation d'heritage (extends) est une relation pouvant etre traduite en
		// Client extends Personne => Client est une version spéicalisée de Personne
		//					=> Client est une Personne
		
		Personne p1 = new Personne("john", "john", LocalDate.of(1975, 2, 5));
		System.out.println(p1);
		
		// une variable de type Personne peut contenir un Objet de type Client
		Personne p2 = null;
		if (Math.random() > 0.5) {
			p2 = new Client("wallas",
					"marcelus",
					LocalDate.of(1972, 7, 31),
					7,
					"marcelus@pulp.com");
		}
		else {
			p2 = new Personne("barbare", "conan", LocalDate.of(1965, 10, 5));
		}
				
		System.out.println(p2.toString());
		// au moment de la compilation, on ne peut etre sur que c'est bien un client
		// dans p2, donc java limite la visibilité a ce qui est sur d'etre présent
		//  les attributs de Personne
		//  les methodes déjà définie au niveau de la classe Personne
		
		System.out.println(p2.toCsvLine());
		
		Personne p3 = new Employe("haddock",
							"archibald",
							LocalDate.of(1901, 5, 3),
							"oenologue",
							25000);
		System.out.println(p3.toCsvLine());
		
		
		
	}

}
