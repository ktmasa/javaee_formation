package compteInterface;

public interface CompteBancaire {
	
	double getSolde();
	void deposer(double montant);
	boolean retirer(double montant);

}
