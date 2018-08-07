package collaborationWorker;

public class WorkerCompteur implements Runnable
{

	private CompteurCommun compteurcommun;
	
	public WorkerCompteur(CompteurCommun compteurcommun) {
		this.compteurcommun = compteurcommun;
	}


	@Override
	public void run() {
		System.out.println("demarrage");
		for (int i = 0; i < 100000000; i++) {
			double d = Math.sqrt(i) + Math.asin(i);
			
			this.compteurcommun.incrementeCompteur();
		}
		System.out.println("fini");
	}

}
