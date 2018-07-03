package compteInterface.BNB;

public abstract class CompteAbstraitBNB {
	public String numeroCompte;
	public String gestionnaire;
	
	
	public CompteAbstraitBNB(String numeroCompte, String gestionnaire) {
		this.numeroCompte = numeroCompte;
		this.gestionnaire = gestionnaire;
	}
	
	
}
