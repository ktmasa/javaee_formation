package builderApp;

import java.util.ArrayList;
import java.util.List;

public class Ordinateur {
	private String ecran;
	private List<String> hdd;
	private boolean clavier;
	private boolean souris;
	private int ramMo;
	private String reseau;
	
	
	public String getEcran() {
		return ecran;
	}
	public void setEcran(String ecran) {
		this.ecran = ecran;
	}
	public List<String> getHdd() {
		return hdd;
	}
	public void setHdd(List<String> hdd) {
		this.hdd = hdd;
	}
	public boolean isClavier() {
		return clavier;
	}
	public void setClavier(boolean clavier) {
		this.clavier = clavier;
	}
	public boolean isSouris() {
		return souris;
	}
	public void setSouris(boolean souris) {
		this.souris = souris;
	}
	public int getRamMo() {
		return ramMo;
	}
	public void setRamMo(int ramMo) {
		this.ramMo = ramMo;
	}
	public String getReseau() {
		return reseau;
	}
	public void setReseau(String reseau) {
		this.reseau = reseau;
	}
	
	public Ordinateur(int ramMo, String firstHdd) {
		this.ramMo = ramMo;
		this.hdd = new ArrayList<>();
		this.hdd.add(firstHdd);
		this.clavier = true;
		this.souris = false;
	}
	@Override
	public String toString() {
		return "Ordinateur [ecran=" + ecran + ", hdd=" + hdd + ", clavier=" + clavier + ", souris=" + souris
				+ ", ramMo=" + ramMo + ", reseau=" + reseau + "]";
	}
	
	
	

}
