package com.courtalon.premierSpringform.beans;

import java.util.Random;

public class Merlin implements FournisseurQuete {

	private String[] libelleQuetes;
	private Random rd;
	
	public String[] getLibelleQuetes() {return libelleQuetes;}
	public void setLibelleQuetes(String[] libelleQuetes) {this.libelleQuetes = libelleQuetes;}

	public Merlin() {
		this.rd = new Random();
	}
	
	@Override
	public Quete fournirNouvelleQuete() {
		Quete q = new Quete();
		q.setLibelle(libelleQuetes[rd.nextInt(libelleQuetes.length)]);
		return q;
	}

}
