package lambdaEtStreamForm;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import lambdaEtStreamForm.metier.Produit;

public class App {

	public static void main(String[] args) {
		// un lambda est une fonction implémentant
		// une interface fonctionnelle
		// une interface est dite fonctionelle si elle ne contient
		// qu'une seule fonction
		
		// un lambda garde un accès aux variables final visible
		// lors de sa création -> une closure
		
		// un lambda permet donc de déclarer un triatement "léger"
		// facilement
		
		// la syntaxe  (parametres -> code)
		
		String[] villes = { "paris", "toulouse", "lyon", "marseille",
							"valence", "rouen", "bordeaux", "nantes"};
		
		// exemple de lambda implementant Comparator
		Comparator<String> longeurComp = 
				(str1, str2) -> Integer.compare(str1.length(), str2.length());
		
		Arrays.sort(villes, longeurComp);
		
		for (String ville : villes)
			System.out.println(ville);
				
		
		Arrays.sort(villes, (str1, str2) -> str2.compareTo(str1));
		
		System.out.println("-----------------------------");
		
		for (String ville : villes)
			System.out.println(ville);
		
		// premier exemple de stream
		
		System.out.println("-----------------------------");
		Arrays.stream(villes).map(v -> v.toUpperCase()) // passage des villes en majuscule
							 .forEach(v -> System.out.println(v)); // affichage de chaque element
		
		System.out.println("-----------------------------");
		Arrays.stream(villes).filter(v -> v.length() > 5)
							 .forEach(v -> System.out.println(v));
		
		
		Produit[] produits = {
				new Produit(1, "steak de lama", 24.99, 0.75),
				new Produit(2, "steak d'autruche", 33.99, 0.65),
				new Produit(3, "miel des carpathes", 7.99, 1.0),
				new Produit(4, "tofu tout fou", 15.99, 0.5),
				new Produit(5, "biere d'algues oceania", 9.99, 1.5),
				new Produit(6, "quinoa des andes", 12.99, 1.0),
				new Produit(7, "viandes des grisons vegetale", 18.99, 0.25)
		};
		
		
		List<Produit> luxe = Arrays.stream(produits)
								   .filter(p -> p.getPrix() > 20.0)
								   .collect(Collectors.toList());
		
		System.out.println(luxe);
		
		List<String> luxenom = Arrays.stream(produits)
				   					.filter(p -> p.getPrix() > 20.0)
				   					.map( p -> p.getLibelle())
				   					.collect(Collectors.toList());
		
		System.out.println(luxenom);
		
		
		
		/*new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return 0;
			}
			
		};*/
		
		Scanner sc = new Scanner(System.in);
		System.out.println("poids max =  ? ");
		double poidsMax = Double.parseDouble(sc.nextLine());
		
		// wherePoids me renvoie un lambda qui compare le poids a un maximum fournis
		// je l'utilise ici pour filtrer les produits
		Arrays.stream(produits).filter(wherePoids(poidsMax))
								.forEach(p -> System.out.println(p));
		System.out.println("-----------------------");
		Arrays.stream(produits).filter(p -> p.getId() == 10)
							   .findFirst()
							   .ifPresent(p -> System.out.println(p));
		// un Optional permet d'encapsuler une donnée avec gestion de sa
		// présence ou non
		// -> isPresent() -> est elle disponnible
		// -> get() -> récuperer valeur
		// -> ifPresent(lambda) -> executer le lambda si la valeur est la
		
		Arrays.stream(produits)
			  .filter(p -> p.getPoids() > 0.5)
			  .mapToDouble(p -> p.getPrix())
			  .average()
			  .ifPresent(moyenne -> System.out.println("la moyenne est " + moyenne));
		
		
		
	}
	
	public static Predicate<Produit> wherePoids(double poidsMax) {
		final double pMax = poidsMax < 0 ? 0 : poidsMax;
		// attention, les lambda n'on acces qu'aux vriable final
		// soit explicitement déclarée, soit implicitement
		return p -> p.getPoids() < pMax;
	}
	
	

}
