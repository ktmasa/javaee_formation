package javaObjet2Form.metier;

import java.time.LocalDateTime;

public class Intervention {
	private int id;
	private String materielSerial;
	private String intervenant;
	private LocalDateTime dateIntervention;
	
	// variable de classe, et non d'instance
	// elle est partagée par toutes les instances et la classe
	private static int compteurId = 1;
	
	// methode static, méthode liée a la classe et pas uà une instance spécifique de Intervention
	public static int getCompteurId() {
		return compteurId;
	}
	
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	public String getMaterielSerial() {return materielSerial;}
	public void setMaterielSerial(String materielSerial) {this.materielSerial = materielSerial;}
	public String getIntervenant() {return intervenant;}
	public void setIntervenant(String intervenant) {this.intervenant = intervenant;}
	public LocalDateTime getDateIntervention() {return dateIntervention;}
	public void setDateIntervention(LocalDateTime dateIntervention) {this.dateIntervention = dateIntervention;}
	
	public Intervention( String materielSerial, String intervenant, LocalDateTime dateIntervention) {
		// rappel le constructeur du dessous avec l'id en plus
		this(compteurId++, materielSerial, intervenant, dateIntervention);
	}
	
	public Intervention(int id, String materielSerial, String intervenant, LocalDateTime dateIntervention) {
		this.id = id;
		this.materielSerial = materielSerial;
		this.intervenant = intervenant;
		this.dateIntervention = dateIntervention;
	}

	@Override
	public String toString() {
		return "Intervention [id=" + id + ", materielSerial=" + materielSerial + ", intervenant=" + intervenant
				+ ", dateIntervention=" + dateIntervention + "]";
	}
	
	
	
	
}
