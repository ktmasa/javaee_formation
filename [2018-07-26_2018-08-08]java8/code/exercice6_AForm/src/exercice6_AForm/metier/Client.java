package exercice6_AForm.metier;

public class Client implements Comparable<Client>, JsonWritable {
	private int id;
	private String nom;
	private String prenom;
	private String email;
	
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	public String getNom() {return nom;}
	public void setNom(String nom) {this.nom = nom;}
	public String getPrenom() {return prenom;}
	public void setPrenom(String prenom) {this.prenom = prenom;}
	public String getEmail() {return email;}
	public void setEmail(String email) {this.email = email;}
	
	public Client() {}
	public Client(int id, String nom, String prenom, String email) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
	}
	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + "]";
	}
	@Override
	public int compareTo(Client o) {
		int comparaison = this.getNom().compareTo(o.getNom());
		// si les noms ne sont pas les memes
		if (comparaison != 0) 
			return comparaison; // on retourne le resultat de la comparaison des noms
		// sinon, on compare les prenoms
		return getPrenom().compareTo(o.getPrenom());
	}
	@Override
	public String toJson() {
		StringBuilder sb = new StringBuilder();
		sb.append("{ \"id\": ").append(id).append(",\n")
			.append("\"nom\": \"").append(nom).append("\",\n")
			.append("\"prenom\": \"").append(prenom).append("\",\n")
			.append("\"email\": \"").append(email).append("\"\n")
			.append("}");
		return sb.toString();
	}
	
	

}
