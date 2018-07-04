package factoryApp;

public class FabriqueMoney {
	
	public static IMoney fabriqueMoney(String pays, double somme) {
		/*switch(pays.toLowerCase()) {
			case "france":
			case "espagne":
			case "italie":
				return new Euro(somme);
			case "japon":
				return new Yen(somme);
			default:
				return new Dollar(somme);
		}*/
		if (pays.equalsIgnoreCase("france") ||
			pays.equalsIgnoreCase("espagne") ||
			pays.equalsIgnoreCase("italie")) {
			return new Euro(somme);
		}
		else if (pays.equalsIgnoreCase("japon")) {
			return new Yen(somme);
		}
		else {
			return new Dollar(somme);
		}
	}

}
