package exercice6_BForm;

import java.util.Iterator;

public class IpIntervale implements Iterable<IpAdresse>
{
	private IpAdresse debut;
	private IpAdresse fin;
	
	public IpAdresse getDebut() {return debut;}
	public void setDebut(IpAdresse debut) {this.debut = debut;}
	public IpAdresse getFin() {return fin;}
	public void setFin(IpAdresse fin) {this.fin = fin;}
	
	public IpIntervale(IpAdresse debut, IpAdresse fin) {
		this.debut = debut;
		this.fin = fin;
	}
	
	@Override
	public Iterator<IpAdresse> iterator() {
		return new IpIterator();
	}
	
	public class IpIterator implements Iterator<IpAdresse>{

		private IpAdresse current;
		
		public IpIterator() {
			this.current = debut;
		}
		
		@Override
		public boolean hasNext() {
			return this.current.compareTo(fin) <= 0;
		}

		@Override
		public IpAdresse next() {
			IpAdresse c = current;
			current = current.nextIp();
			return c;
		}
		
	}
	
	

}
