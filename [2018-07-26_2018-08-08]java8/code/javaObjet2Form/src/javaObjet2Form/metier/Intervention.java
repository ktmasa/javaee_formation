package javaObjet2Form.metier;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

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
	
	// methode retournant une ligne de fichier csv contenant les informations de notre intervention
	public String toCsvLine() {
		return 	  this.id + "," 
				+ this.materielSerial + ","
				+ this.intervenant + ","
				+ this.dateIntervention;
	}
	// instantiation d'une intervention a partir d'une ligne CSV
	public static Intervention fromCsvLine(String line) {
		// decoupage par les ','
		String[] champs = line.split(",");
		return new Intervention(
				Integer.parseInt(champs[0]),		// id -> Integer
				champs[1],							// serialMateriel -> String
				champs[2],							// intervenant -> String
				LocalDateTime.parse(champs[3]));	// date -> LoacalDateTime 
	}
	
	// chargement complet d'une liste d'intervention depuis un fichier CSV
	public static ArrayList<Intervention> loadAllInterventionsFromCSV(String fileName)
									throws FileNotFoundException {
		Scanner reader = new Scanner(new File(fileName));
		ArrayList<Intervention> data = new ArrayList<>();
		while (reader.hasNextLine()) {
			data.add(Intervention.fromCsvLine(reader.nextLine()));
		}
		reader.close();
		return data;
	}
	
	// methode a appeler pour sauvegarder une collection d'interventions
	public static void saveAllInterventionsToCSV(ArrayList<Intervention> data, String fileName) 
												throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(fileName);
		for (Intervention inter : data) {
			pw.println(inter.toCsvLine());
		}
		pw.close();
	}
	
	
}
