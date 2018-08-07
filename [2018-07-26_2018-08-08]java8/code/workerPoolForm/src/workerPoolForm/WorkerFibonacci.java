package workerPoolForm;

public class WorkerFibonacci implements Runnable{

	private long valeur;
	
	public WorkerFibonacci(long valeur) {
		this.valeur = valeur;
	}

	@Override
	public void run() {
		System.out.println("demarrage calcul fibonacci " + valeur);
		long result = fibonacci(valeur);
		System.out.println("calcul fibonacci " + valeur + " = " + result);
	}

	private long fibonacci(long n) {
		if (n <= 1)
			return n;
		else
			return fibonacci(n-1) + fibonacci(n-2);
	}
	
}
