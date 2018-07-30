package java_objetForm;

public class App {

	public static void main(String[] args) {

		Produit p1 = new Produit();
		// pour acceder aux "membres" de l'objet, on utilise le '.'
		
		p1.id = 1;
		p1.nom = "tofu tout fou";
		p1.prix = 19.99;
		p1.poids = 0.75;
		
		
		System.out.println(p1.nom);
		
		Produit p2 = new Produit(2, "steak de lama", 39.99, 0.5);
		/*p2.id = 2;
		p2.nom = "steak de lama";
		p2.prix = 39.99;
		p2.poids = 0.5;
		*/
		System.out.println(p2.nom);
		
		System.out.println(p1.nom);
		
		// attention , les objets sont des type reference
		Produit p3 = p1; // p3 et p1 "reference" en memoire la même instance de l'objet produit
		
		p3.prix = 29.99;
		
		System.out.println(p1.prix);
		
		// appel de la méthode afficher de produit , dans la methode this -> p1
		p1.afficher();
		
		Produit p4 = new Produit();
		p4.afficher();
		
//		Scanner input = new Sc
		
		p4.prix = -50;
		p4.afficher();
		
		
		Article a1 = new Article(1, "java commando", -34.99);
		System.out.println(a1.getId());
		System.out.println(a1.getNom());
		System.out.println(a1.getPrix());
		//a1.setPrix(-50);
		//System.out.println(a1.getPrix());
		
		Livre l1 = new Livre(1, "it's time to go", "van damme", 250);
		l1.afficher();
		Livre l2 = new Livre(2, "les shampoing", "nabilla", -4);
		l2.afficher();
		l2.setNbPages(250);
		l2.afficher();
		
	}

}
