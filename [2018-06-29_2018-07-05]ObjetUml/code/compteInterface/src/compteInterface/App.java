package compteInterface;

import compteInterface.BNB.CompteAbstraitBNB;
import compteInterface.BNB.CompteEpargneBNB;
import compteInterface.SOURIS.CompteCourantSouris;

public class App {

	public static void main(String[] args) {
		CompteEpargneBNB c1 = new CompteEpargneBNB("32445454", "patrick", 650);
		CompteCourantSouris c2 = new CompteCourantSouris("987987987987", 7, 300);
		
		Transaction t1 = new Transaction(1, c1, c2, 150);
		System.out.println(c1);
		System.out.println(c2);
		
		t1.executerTransaction();

		System.out.println(c1);
		System.out.println(c2);

	}

}
