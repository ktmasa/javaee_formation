package collaborationWorker;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App {

	public static void main(String[] args) throws InterruptedException {
		// compteur commun à 0
		CompteurCommun cc = new CompteurCommun(0);
		
		WorkerCompteur wc1 = new WorkerCompteur(cc);
		WorkerCompteur wc2 = new WorkerCompteur(cc);
		//wc1.run();
		//wc2.run();
		ExecutorService executor = Executors.newFixedThreadPool(4);
		executor.submit(wc1);
		executor.submit(wc2);
		
		executor.shutdown();
		executor.awaitTermination(100, TimeUnit.SECONDS);
		
		// non thread safe
		StringBuilder sb = new StringBuilder();
		// thread safe
		StringBuffer sb2 = new StringBuffer();
		
		System.out.println(cc);

	}

}
