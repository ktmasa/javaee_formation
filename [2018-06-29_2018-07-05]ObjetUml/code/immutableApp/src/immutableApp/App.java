package immutableApp;

import java.time.LocalDate;

public class App {

	public static void main(String[] args) {

		Vecteur v1 = new Vecteur(1.0,  2.0, -2.0);
		System.out.println(v1);
		Vecteur v2 = v1;
		fonctionModif(v2);
		Vecteur v3 = new Vecteur(5.0,  -3.0, -4.0);
		System.out.println(v3);
		v2 = v1.add(v3);
		
		System.out.println(v1);
		System.out.println(v3);
		System.out.println(v2);
		
		Transaction t1 = new Transaction(LocalDate.now(), 200, "livretA", "comptecourant");
		System.out.println(t1);
		Transaction t2 = t1.changeMontant(300);
		System.out.println(t2);
		System.out.println(t1);
		
		
	}

	public static void fonctionModif(Vecteur v) {
		v = v.translate(5, 0, 0);
		System.out.println(v);
	}
}
