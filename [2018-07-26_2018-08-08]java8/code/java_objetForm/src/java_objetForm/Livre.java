package java_objetForm;

public class Livre {
	private int id;
	private String titre;
	private String auteur;
	private int nbPages;
	
	public Livre(int id, String titre, String auteur, int nbPages) {
		this.id = id;
		this.titre = titre;
		this.auteur = auteur;
		setNbPages(nbPages);
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public int getNbPages() {
		return nbPages;
	}

	public void setNbPages(int nbPages) {
		this.nbPages = (nbPages < 0 || nbPages > 1000)? 100 : nbPages;
		//this.nbPages = (nbPages >= 0 && nbPages <= 1000)? nbPages: 100;
	}
	
	public void afficher() {
		System.out.println("livre[ id=" + getId() 
						+ ", titre=" + getTitre() 
						+ ", auteur=" + getAuteur() 
						+ ", nbPages=" + getNbPages() + "]");
	}
	

}
