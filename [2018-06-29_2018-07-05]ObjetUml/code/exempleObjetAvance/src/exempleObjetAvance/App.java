package exempleObjetAvance;

public class App {

	public static void main(String[] args) {
		
		ClasseA ca = new ClasseA();
		ClasseB cb = new ClasseB();
		ClasseA cc = new ClasseB();
		
		// attention, lors de l'appel du methode statique,
		// la méthode choisi sera en fonction du type de la variable uniquement
		// et pas de l'instance à l'intérieur
		System.out.println("ca1 = " + ca.getValeur1());
		System.out.println("ca2 = " + ca.getValeur2());
		System.out.println("cb1 = " + cb.getValeur1());
		System.out.println("cb2 = " + cb.getValeur2());
		System.out.println("cc1 = " + cc.getValeur1());
		System.out.println("cc2 = " + cc.getValeur2());
		
		
	}

}
