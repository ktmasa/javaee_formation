package collectionsEtGeneriquesForm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class App {

	public static void main(String[] args) {
		
		Couple<String, Double> cp1 = new Couple<String, Double>("fraise", 15.5);
		cp1.setValeur2(19.99);
		System.out.println(cp1);
		
		Couple<Double, String> cp2;
		
		//Couple<Scanner, String> cp3;
		Couple<String, Scanner> cp4;
		//cp2 = cp1;
		
		
		
		
		// int[]
		// String[]   tableaux
		
		// tableau dynamique non générique
		
		ArrayList tab = new ArrayList();
		tab.add("lundi");
		tab.add(42.5);
		System.out.println(tab);
		
		Object o1 = tab.get(0);
		if (o1 instanceof String) {
			String str = (String)o1;
			System.out.println(str + " - " + str.length());
		}
		
		// tableau dynamique générique
		ArrayList<String> tab2 = new ArrayList<>();
		tab2.add("lundi");
		//tab2.add(45.5);
		tab2.add("mardi");
		tab2.add("mercredi");
		
		System.out.println("-------------------------");
		System.out.println(tab2);
		
		tab2.add("jeudi");
		System.out.println("-------------------------");
		System.out.println(tab2);
		System.out.println("taille tab2 = " + tab2.size());
		
		System.out.println("-------------------------");
		tab2.remove(1);
		System.out.println(tab2);
		System.out.println("taille tab2 = " + tab2.size());
		
		System.out.println("-------------------------");
		tab2.add(2, "juillet");
		System.out.println(tab2);
		System.out.println("taille tab2 = " + tab2.size());
		
		System.out.println("-------------------------");
		tab2.set(2, "aout");
		System.out.println(tab2);
		System.out.println("taille tab2 = " + tab2.size());
		
		// foreach possible
		for (String elem : tab2) {
			System.out.println(elem);
		}
		// tri du tableau
		Collections.sort(tab2);
		System.out.println(tab2);

		// les generiques ne supporte pas les types valeur de java (comme int, double...)
		//ArrayList<Integer> tab3;
		
		// les piles, ou stack
		/*
		 * les piles utilise le principe LIFO -> last in first out
		 */
		
		Stack<String> pile1 = new Stack<>();
		pile1.push("fraise");
		pile1.push("poire");
		pile1.push("ananas");
		
		System.out.println("-------------------------");
		System.out.println(pile1);

		System.out.println("-------------------------");
		System.out.println("pop = " + pile1.pop());
		System.out.println(pile1);
		
		System.out.println("-------------------------");
		pile1.push("raisin");
		System.out.println(pile1);
		
		System.out.println("-------------------------");
		System.out.println("pop = " + pile1.pop());
		System.out.println("pop = " + pile1.pop());

		// files d'attente
		/*
		 * FIFO -> first in first out
		 * 
		 */
		LinkedList<String> file1 = new LinkedList<>();
		file1.offer("bob");
		file1.offer("joe");
		file1.offer("marcelus");
		
		System.out.println("-------------------------");
		System.out.println(file1);
		
		System.out.println("-------------------------");
		System.out.println("poll -> " + file1.poll());
		System.out.println(file1);
		
		System.out.println("-------------------------");
		file1.offer("jean");
		System.out.println(file1);
		//  poll   <-  ["un", "deux", "trois" ] <- offer
		
		//---- dictionnaire /map / hashtable / tableau associatif
		
		// clef -> valeur
		
		HashMap<String, Double> map1 = new HashMap<>();
		map1.put("pomme", 9.99);
		map1.put("poire", 29.99);
		map1.put("fraise", 19.99);
			
		System.out.println(map1);
		
		System.out.println("poire ? -> " + map1.get("poire"));
		
		System.out.println("fraise présent ? " + map1.containsKey("fraise"));
		
		for (String clef : map1.keySet()) {
			System.out.println(clef + " -> " + map1.get(clef));
		}
		/*
		 * vous ne pouvez pas avoir deux fois la même clef dans la map
		 * si vous "ecrasez" une clef existante, la valeur est remplacée
		 */
		map1.put("poire", 12.99);
		System.out.println(map1);
		/*
		 * les Map (HashMap ou HashTable ou Dictionnary)
		 *  sont utilisé pour rapidement retrouver une valeur a partir de sa clef
		 * 
		 * 
		 */
		//HashMap<String, Double> map2 = new HashMap<>(1000);
		
		// interface List -> toutes les collection a access "random"
		// add et get(pos), les elements on une position dans la collection
		List<String> liste = new ArrayList<>();
		
		// interface Set -> ensemble
		// les elements n'on pas de position
		
		Set<String> ensemble = new HashSet<>();
		ensemble.add("tomate");
		ensemble.add("haricot");
		ensemble.add("pomme de terre");
		
		System.out.println("haricot présent ? " + ensemble.contains("haricot"));
		for (String elem : ensemble) {
			System.out.println(elem);
		}
		
		// interface Map -> HasMap/dictionnaire....
		Map<String, Double> map2 = new HashMap<>();
		
		
		
		
		
		
		
		
		
		
		
	}

}
