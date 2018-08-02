package classeObject;

import java.util.ArrayList;

public class App {

	public static void main(String[] args) {
		
		Object o1;
		String str1 = "hello";
		// la classe Object étant racine de l'héritage
		// une variable de type Object peut contenir
		// n'importe quel type
		o1 = str1;
		// dans object, la méthode Equals permet de 
		// comparer un objet a un autre, dans le sens egalité
		// on peut donc l'overrider si on veut rédéfinir l'egalite entre nos objets
		
		
		ArrayList<Livre> livres = new ArrayList<>();
		Livre l1 = new Livre("123456789", "la bete humaine");
		System.out.println(l1);
		livres.add(l1);
		livres.add(new Livre("234567890", "le tour du monde en 80 jours"));
		livres.add(new Livre("234567891", "de la terre a la lune"));
		livres.add(new Livre("234567892", "voyage au centre de la terre"));
		
		System.out.println("l1 est il présent? " + livres.contains(l1));
		
		Livre l2 = new Livre("234567890", "le tour du monde en 80 jours");
		System.out.println("l2 est il présent? " + livres.contains(l2));
		
		ArrayList<String> fruits = new ArrayList<>();
		fruits.add(new String("pomme"));
		fruits.add(new String("poire"));
		fruits.add(new String("fraise"));
		fruits.add(new String("banane"));
		
		System.out.println("poire est il présent ? " + fruits.contains(new String("poire")));
		
		
		
	}

}
