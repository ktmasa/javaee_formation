package perofrmanceChaineForm;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		String buffer = "";
		System.out.println("appuyez sur entree pour commencer test");
		input.nextLine();
		
		long start = System.currentTimeMillis();
		for(int i = 0; i < 100000; i++) {
			buffer += "hello!";
			if (i % 1000 == 0) {
				System.out.println("iteration = " + i);
			}
		}
		long fin = System.currentTimeMillis();
		System.out.println("temps ecoulé en millisecondes = " + (fin - start));
		
		System.out.println("--------------------------------");
		System.out.println("appuyez sur entree pour commencer test");
		input.nextLine();
		
		StringBuilder sb = new StringBuilder();
		start = System.currentTimeMillis();
		for(int i = 0; i < 100000; i++) {
			sb.append("hello!");
			if (i % 1000 == 0) {
				System.out.println("iteration = " + i + " - " + sb.capacity());
			}
		}
		String result = sb.toString();
		fin = System.currentTimeMillis();
		System.out.println("temps ecoulé en millisecondes = " + (fin - start));
		
	}

}
