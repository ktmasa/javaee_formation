package immutableApp;

import java.time.LocalDate;

public class Transaction {
	private final LocalDate date;
	private final double  montant;
	private final String source;
	private final String destination;
	
	public LocalDate getDate() {return date;}
	public double getMontant() {return montant;}
	public String getSource() {return source;}
	public String getDestination() {return destination;}
	
	public Transaction(LocalDate date, double montant, String source, String destination) {
		this.date = date;
		this.montant = montant;
		this.source = source;
		this.destination = destination;
	}
	
	public Transaction changeMontant(double montant) {
		return new Transaction(this.date, montant, this.source, this.destination);
	}
	
	public Transaction combinerTransaction(Transaction t2) {
		return new Transaction(this.date,this.montant + t2.montant, this.source, t2.destination);
	}
	
	
	
	@Override
	public String toString() {
		return "Transaction [date=" + date + ", montant=" + montant + ", source=" + source + ", destination="
				+ destination + "]";
	}

	
	

}
