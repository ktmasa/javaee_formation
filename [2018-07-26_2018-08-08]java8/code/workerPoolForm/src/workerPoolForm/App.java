package workerPoolForm;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App {

	public static void main(String[] args) {
		
		// creation d'un service d'execution de tache avec 4 thread alloués
		ExecutorService executeur = Executors.newFixedThreadPool(4);
		
		// pour des questions de performance, il est TRES RECOMMAND2 d'utiliser
		// les ExecutorService
		/*
		 * la creation d'un thread est TRES couteuse 
		 * on veut eviter au maximum les creations inutiles de Thread
		 * les executorService savent "recycler" un Thread déjà utiliser
		 * pour une nouvelle tache
		 * 
		 */
		
		Random rd = new Random();
		for (int i = 0; i < 10; i++) {
			// tirer aleatoirement entre 42 et 46
			WorkerFibonacci wf = new WorkerFibonacci(rd.nextInt(5) + 42);
			// soumet la tache a l'executeur
			executeur.submit(wf);
		}
		System.out.println("terminer de soumettre toutes les taches");
		// shutdown n'interromp pas les taches déjà soumise
		// mais empeche la soumission de nouvelles taches
		executeur.shutdown();
		
		try {
			System.out.println("attente fin execution");
			executeur.awaitTermination(60, TimeUnit.SECONDS);
			System.out.println("fini!");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		
		//WorkerFibonacci wf = new WorkerFibonacci(45);
		//wf.run();
		//System.out.println("fini");
	}

}
