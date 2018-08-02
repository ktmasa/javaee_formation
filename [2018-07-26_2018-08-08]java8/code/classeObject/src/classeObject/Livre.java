package classeObject;

public class Livre {
	private String isbn;
	private String titre;
	
	public String getIsbn() {return isbn;}
	public void setIsbn(String isbn) {this.isbn = isbn;}
	public String getTitre() {return titre;}
	public void setTitre(String titre) {this.titre = titre;}
	
	public Livre(String isbn, String titre) {
		this.isbn = isbn;
		this.titre = titre;
	}
	
	@Override
	public String toString() {
		return "Livre [isbn=" + isbn + ", titre=" + titre + "]";
	}
	
	/*
	 * la methode equals permet de comparer un objet a un autre
	 *  pour egalité
	 *  toutes ls collection/librairie java l'utilise
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		// si ce n'est pas un livre, ce n'est pas egal
		if (!(obj instanceof Livre))
			return false;
		// conversion de other en Livre
		Livre other = (Livre)obj;
		// nos livres sont egaux si le code ISBN est le même
		return this.getIsbn().equals(other.getIsbn());
	}
	
	
	
	

}
