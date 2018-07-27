package fonctionsForm;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("votre nom ?");
		String saisie = input.nextLine();

		// appel de la fonction
		salutation(saisie);
		salutation(saisie, "mr");
		
		double prix = 15.99;
		System.out.println(calculTTC(prix));
		
		double a = 4.5;
		double b = 15.6;
		System.out.println("a = " + a +  " b = " + b);
		echange(a, b);
		System.out.println("a = " + a +  " b = " + b);
		
		// suivant que l'on passe en parametre un type valeur ou un type reference
		// l'original ne sera pas modifié ou le sera
		// type valeur -> copie
		// type reference -> original
		System.out.println("---------------------------------");
		double[] tab = {4.5  , 15.6};
		System.out.println("tab[0] = " + tab[0] + " tab[1] = " + tab[1]);
		echange(tab);
		System.out.println("tab[0] = " + tab[0] + " tab[1] = " + tab[1]);
		
		long result = factorielle(6);
		System.out.println("resultat = " + result);
		
		System.out.println("moyenne = " + moyenne(10.5, 3.6, 12.2, 18.7, 9.9));
		
	}
	
	// la liste variable d'argument est forcément en denrier dans les arguments
	// on a par contre le droit d'avoir d'autres arguments avant
	public static double moyenne(double ... notes) {
		double somme = 0.0;
		for (double n : notes)
			somme += n;
		return somme / notes.length;
	}
	
	// fonction récursive
	public static long factorielle(long n) {
		if (n <= 1) 
			return 1;
		else 
			return n * factorielle(n - 1);
	}
	
	
	
	public static void echange(double[] values) {
		System.out.println("v[0] = " + values[0] + " v[1] = " + values[1]);
		double temp = values[0];
		values[0] = values[1];
		values[1] = temp;
		System.out.println("v[0] = " + values[0] + " v[1] = " + values[1]);
	}
	
	
	public static void echange(double x, double y) {
		System.out.println("x = " + x +  " y = " + y);
		double temp = x;
		x = y;
		y = temp;
		System.out.println("x = " + x +  " y = " + y);
	}
	
	
	
	// les regles de nommage des fonctions sont les même que pour les variable 
	public static double calculTTC(double prixHT) {
		return prixHT * 1.2;
	}
	
	// fonction salutation
	// ne renvoie rien
	// prend un argument de type String en parametre
	public static void salutation(String nom) {
		System.out.println("bonjour, " + nom);
	}
	
	// signature différente, car arguments différent
	public static void salutation(String nom, String civilite) {
		System.out.println("bonjour, " + civilite + " " + nom);
	}
	
	/*
	public static String salutation(String nom) {
		return "bonjour, " + nom;
	}*/
	
	
}
