package interfacesForm;

import java.util.Iterator;

public class Intervale implements Iterable<Integer> {
	private int debut;
	private int fin;
	
	public int getDebut() {return debut;}
	public void setDebut(int debut) {this.debut = debut;}
	public int getFin() {return fin;}
	public void setFin(int fin) {this.fin = fin;}
	
	public Intervale() {}
	public Intervale(int debut, int fin) {
		super();
		this.debut = debut;
		this.fin = fin;
	}
	
	@Override
	public String toString() {
		return "Intervale [debut=" + debut + ", fin=" + fin + "]";
	}
	
	@Override
	public Iterator<Integer> iterator() {
		return new IntervalIterateur(); // nouveau curseur sur mon interval
	}
	
	// ma classe "curseur" pour parcourir l'interval
	public class IntervalIterateur implements Iterator<Integer> {

		private int position;
		
		public IntervalIterateur() {
			// je positionne le curseur sur le debut de l'interval
			this.position = debut;
		}
		
		@Override
		public boolean hasNext() {
			// tant que l'on a pas depassé la fin, le parcourt n'est pas fini
			return this.position <= fin;
		}

		@Override
		public Integer next() {
			// retourner la position actuelle, puis avancer de 1
			return this.position++;
		}
		
		
	}
	

}
