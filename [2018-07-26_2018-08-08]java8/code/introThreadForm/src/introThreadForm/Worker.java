package introThreadForm;

public class Worker implements Runnable {
	private String nom;
	
	public Worker(String nom) {
		this.nom = nom;
	}

	@Override
	public void run() {
		for (long x = 0; x < 1000000000L; x++) {
			double d = Math.sqrt(x + 1);
			if (x % 10000000 == 0) {
				System.out.println(nom + " iteration = " + x);
			}
		}
	}

}
