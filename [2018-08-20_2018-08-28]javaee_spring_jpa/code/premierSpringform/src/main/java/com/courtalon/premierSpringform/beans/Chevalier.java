package com.courtalon.premierSpringform.beans;

public class Chevalier implements IChevalier {
	private String nom;
	private FournisseurQuete fournisseurQuete;
	
	public String getNom() {return nom;}
	public void setNom(String nom) {this.nom = nom;}
	public FournisseurQuete getFournisseurQuete() {return fournisseurQuete;}
	public void setFournisseurQuete(FournisseurQuete fournisseurQuete) {this.fournisseurQuete = fournisseurQuete;}
	
	
	public Chevalier(String nom) {
		this.nom = nom;
	}
	
	@Override
	public String toString() {
		return "Chevalier [nom=" + nom + "]";
	}
	
	/* (non-Javadoc)
	 * @see com.courtalon.premierSpringform.beans.IChevalier#partirEnQuete()
	 */
	@Override
	public void partirEnQuete() {
		System.out.println("moi, sir " + getNom() + " part en quete");
		Quete q = fournisseurQuete.fournirNouvelleQuete();
		System.out.println("je fais la quete: " + q.getLibelle());
		System.out.println("moi, sir " + getNom() + " reviens de quete");
	}

}
