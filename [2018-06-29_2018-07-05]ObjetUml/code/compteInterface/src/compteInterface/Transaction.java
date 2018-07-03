package compteInterface;

import java.time.LocalDate;

public class Transaction {
	private int numero;
	private LocalDate dateTransaction;
	private CompteBancaire source;
	private CompteBancaire destination;
	private double montant;
	private boolean effectue;
	
	public int getNumero() {return numero;}
	public void setNumero(int numero) {this.numero = numero;}
	public LocalDate getDateTransaction() {return dateTransaction;}
	public void setDateTransaction(LocalDate dateTransaction) {this.dateTransaction = dateTransaction;}
	public CompteBancaire getSource() {return source;}
	public void setSource(CompteBancaire source) {this.source = source;}
	public CompteBancaire getDestination() {return destination;}
	public void setDestination(CompteBancaire destination) {this.destination = destination;}
	public double getMontant() {return montant;}
	public void setMontant(double montant) {this.montant = montant;}
	public boolean isEffectue() {return effectue;}
	public void setEffectue(boolean effectue) {this.effectue = effectue;}
	
	public Transaction(int numero,
						CompteBancaire source,
						CompteBancaire destination,
						double montant) {
		this.numero = numero;
		this.source = source;
		this.destination = destination;
		this.montant = montant;
		this.dateTransaction = LocalDate.now();
		this.effectue = false;
	}
	
	
	public boolean executerTransaction() {
		if (this.source.retirer(montant)) {
			this.destination.deposer(montant);
			this.effectue = true;
		}
		else
			this.effectue = false;
		return this.effectue;
	}

}
