package introThreadForm;

public class App {

	public static void main(String[] args) {
		
		Worker w1 = new Worker("bob");
		Worker w2 = new Worker("patrick");
		Worker w3 = new Worker("paul");
		
		// le Thread est crée, mais pas démarré
		Thread t1 = new Thread(w1);
		Thread t2 = new Thread(w2);
		Thread t3 = new Thread(w3);
		
		long debut = System.currentTimeMillis();
		t1.start(); // demarrage
		t2.start();
		t3.start();
		
	/*	w1.run();
		w2.run();
		w3.run();
		*/
		try {
			System.out.println("attente des workers");
			t1.join();
			t2.join();
			t3.join();
			System.out.println("worker terminés!");
		} catch (InterruptedException e) {e.printStackTrace();}
		
		long fin = System.currentTimeMillis();
		System.out.println("durée = " + (fin - debut));

	}

}
