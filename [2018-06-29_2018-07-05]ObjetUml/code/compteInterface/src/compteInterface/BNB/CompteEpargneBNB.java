package compteInterface.BNB;

import compteInterface.CompteBancaire;

public class CompteEpargneBNB extends CompteAbstraitBNB
							  implements CompteBancaire
{

	private double solde;

	// c'est un accesseur, une fontion qui permet de lire la valeur de l'attribut privé solde
	public double getSolde() {return solde;}

	public CompteEpargneBNB(String numeroCompte, String gestionnaire, double solde) {
		super(numeroCompte, gestionnaire);
		this.solde = solde;
	}

	@Override
	public void deposer(double montant) {
		this.solde += montant;
	}

	@Override
	public boolean retirer(double montant) {
		if (montant <= solde) {
			solde -= montant;
			return true;
		}
		return false;
	}

	
	@Override
	public String toString() {
		return "CompteEpargneBNB [solde=" + solde + ", numeroCompte=" + numeroCompte + ", gestionnaire=" + gestionnaire
				+ "]";
	}
	
	
	
	
}
