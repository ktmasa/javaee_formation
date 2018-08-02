package exercice6_BForm;

import java.io.FileNotFoundException;

public class App {

	public static void main(String[] args) {
		IpAdresse ip1 = new IpAdresse("192.168.10.255");
		System.out.println(ip1);
		IpAdresse ip2 = ip1.nextIp();
		System.out.println(ip2);
		
		IpIntervale r1 = new IpIntervale(new IpAdresse("192.168.10.98"),
				new IpAdresse("192.168.12.10"));
		
		System.out.println("-------------------------");
		for (IpAdresse ip : r1)
			System.out.println(ip);
	}
	
}
