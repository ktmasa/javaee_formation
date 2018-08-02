package exercice6_BForm;

public class IpAdresse implements Comparable<IpAdresse>{
	private long adresse;
	
	
	public IpAdresse(long adresse) {
		this.adresse = adresse;
	}

	public IpAdresse(String adr) {
		String[] parts = adr.split("[.]");
		adresse = Integer.parseInt(parts[3]) & 255;
		adresse += (Integer.parseInt(parts[2]) & 255) << 8;
		adresse += (Integer.parseInt(parts[1]) & 255) << 16;
		adresse += ((long)(Integer.parseInt(parts[0]) & 255)) << 24;
	}

	@Override
	public String toString() {
		return "IpAdresse [" + ((adresse >> 24) & 255) +   "." 
					+ ((adresse >> 16) & 255) + "."
					+ ((adresse >> 8) & 255) + "."
					+ (adresse & 255) + "]";
	}

	
	public IpAdresse nextIp() {
		return new IpAdresse(this.adresse + 1);
	}

	@Override
	public boolean equals(Object obj) {
		IpAdresse other = (IpAdresse) obj;
		if (adresse != other.adresse)
			return false;
		return true;
	}

	@Override
	public int compareTo(IpAdresse o) {
		return Long.compare(adresse, o.adresse);
	}
	
	
	
	
}
