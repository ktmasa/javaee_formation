package com.courtalon.secondjdbcForm.metier;

public class Livre {
	private int id;
	private String titre;
	private String isbn;
	private String auteur;
	private int nb_pages;
	
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	public String getTitre() {return titre;}
	public void setTitre(String titre) {this.titre = titre;}
	public String getIsbn() {return isbn;}
	public void setIsbn(String isbn) {this.isbn = isbn;}
	public String getAuteur() {return auteur;}
	public void setAuteur(String auteur) {this.auteur = auteur;}
	public int getNb_pages() {return nb_pages;}
	public void setNb_pages(int nb_pages) {this.nb_pages = nb_pages;}
	
	public Livre() {}
	public Livre(int id, String titre, String isbn, String auteur, int nb_pages) {
		this.id = id;
		this.titre = titre;
		this.isbn = isbn;
		this.auteur = auteur;
		this.nb_pages = nb_pages;
	}
	
	@Override
	public String toString() {
		return "Livre [id=" + id + ", titre=" + titre + ", isbn=" + isbn + ", auteur=" + auteur + ", nb_pages="
				+ nb_pages + "]";
	}
	
	
	
	

}
