package exercice6_AForm;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;

import exercice6_AForm.metier.Client;
import exercice6_AForm.metier.JsonWritable;

public class App {

	public static void main(String[] args) throws FileNotFoundException {
		Client[] clients = {
				new Client(1, "bob", "joe", "bob@joe.com"),
				new Client(2, "bob", "carl", "bob@carl.com"),
				new Client(3, "xavier", "marc", "xavier@marc.com"),
				new Client(4, "xavier", "fred", "xavier@fred.com"),
				new Client(5, "jean", "bon", "jean@bon.com"),
				new Client(6, "jean", "peuplu", "jean@peuplu.com")
		};
		Arrays.sort(clients);
		
		/*for (Client c : clients)
			System.out.println(c);
		*/
		saveToJson("clients.json", clients);

	}

	public static void saveToJson(String fileName, JsonWritable[] data) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(fileName);
		boolean first = true;
		pw.print("[\n");
		for (JsonWritable item : data) {
			if (!first) {
				pw.println(",");
			}
			else
				first = false;
			pw.println(item.toJson());
		}
		pw.println("]");
		pw.close();
	}
	
	
}
