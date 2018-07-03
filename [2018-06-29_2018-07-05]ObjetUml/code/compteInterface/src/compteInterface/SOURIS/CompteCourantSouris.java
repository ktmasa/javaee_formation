package compteInterface.SOURIS;

import compteInterface.CompteBancaire;

public class CompteCourantSouris extends CompteBasiqueSouris implements CompteBancaire {

	public double balance;
	
	
	public CompteCourantSouris(String iban, int numeroFildelite, double balance) {
		super(iban, numeroFildelite);
		this.balance = balance;
	}

	@Override
	public double getSolde() {
		return this.balance;
	}

	@Override
	public void deposer(double montant) {
		this.balance += montant;

	}

	@Override
	public boolean retirer(double montant) {
		if ( montant <= this.balance + 200) {
			this.balance -= montant;
		}
		return false;
	}

	@Override
	public String toString() {
		return "CompteCourantSouris [balance=" + balance + ", Iban=" + Iban + ", numeroFildelite=" + numeroFildelite
				+ "]";
	}

}
