package interfacesForm;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;

public class App {

	public static void main(String[] args) throws FileNotFoundException {
		Produit[] produits = {
			new Produit(1, "tie fighter", 15000),
			new Produit(2, "ATAT walker", 45000),
			new Produit(3, "X-WING", 20000),
			new Produit(4, "Y-WING", 30000)
		};
		Arrays.sort(produits);
		saveCollectionToCSV("space.csv", produits);

	}
	
	public static void saveCollectionToCSV(String fileName, CsvWritable[] data) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(fileName);
		for (CsvWritable item : data) {
			// pas besoin de savoir concretement le type précis de item
			// c'est un CSVWritable, et ca nous suffit
			pw.println(item.toCsvLine());
		}
		pw.close();
	}

}
