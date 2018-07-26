package helloWorldForm;

public class App {

	public static void main(String[] args) {
		
		System.out.println("bonjour monde");
		
		// types de variables
		/*
		 * declaration de variable locale
		 * 
		 * type nom;
		 * type nom = valeur;
		 * 
		 * var n'existe pas, variable sont fortement typée
		 * obligatoirement
		 * 
		 * a l'interieur d'une fonction, c'est une variable
		 * locale
		 */
		
		// types numériques
		// types entiers
		
		// int -> entier 32 bits signé
		int entierA = 15;
		int entierB = 453;
		System.out.println(entierA + entierB);
		// + * - / %(modulo)
		System.out.println(entierA - entierB);
		System.out.println(entierA * entierB);
		System.out.println(entierB / entierA);
		System.out.println(entierB % entierA);
		
		// long -> entier 64 bits signé
		long entierC = 456;
		// y compris des valeur plus importantes que 2^31
		// L a la fin permet de spécifier un 'literal' 64 bits
		long entierD = 456656576434654654L;
		System.out.println(entierC);
		System.out.println(entierD);
		
		// cast explicite, car risque de perte de précisions
		entierA = (int)entierD;
		System.out.println(entierA);
		// cast implicite, la conversion marche à tous les coups
		// 32bits -> 64 bits : implicite
		entierD = entierB;
		System.out.println(entierD);
		
		System.out.println("--------------------------------------");
		// short -> entier 16 bits signés (-32768 , 32767)
		short entierE = 12456;
		//short entierF = 124656;
		System.out.println(entierE);
		
		// byte -> eniter 8 bits signé un octet
		byte entierF = 112;
		System.out.println(entierF);
		
		// conversion implicite, pas de cast necessaire
		// byte -> short -> int -> long
		// explicite
		// long -> int -> short -> byte
		entierE = entierF; // byte dans short ok
		entierF = (byte)entierE; // short dans byte -> cast requis
		
		// calcul -> précision le plus grande
		int entierG = entierE + entierF;
		
		/*
		 * la plupart du temps, on utilise int
		 * 
		 * de temps en temps long si nécéssaire
		 * 
		 */
		
		// numerique non entiere, a virgule flottante
		System.out.println("---------------------------");
		// double -> flottant 64 bits
		double flottantA = 3.1415;
		System.out.println(flottantA);
		flottantA = 3.1415161718;
		System.out.println(flottantA);
		flottantA = 3.14151617181920212223;
		System.out.println(flottantA);
		// float -> flottant 32 bits
		System.out.println("---------------------------");
		float flottantB = 3.1415F;
		System.out.println(flottantB);
		flottantB = 3.1415161718F;
		System.out.println(flottantB);
		
		// float -> double : pas de probleme, implicite
		flottantA = flottantB;
		// double -> float : perte de précision, cast requis
		flottantB = (float)flottantA;
		
		// type boolean -> vrai/faux
		boolean b1 = true;
		boolean b2 = false;
		
		System.out.println("b1 = " + b1);
		System.out.println("b2 = " + b2);
		
		System.out.println("b1 ET b2 = " + (b1 && b2));
		System.out.println("b1 OU b2 = " + (b1 || b2));
		System.out.println("not b1 = " + !b1);
		
		// type char -> un caractere
		// la simple quote -> 'a' un caractere
		char c1 = 'e';
		System.out.println("c1 = " + c1);
		
	}

}
