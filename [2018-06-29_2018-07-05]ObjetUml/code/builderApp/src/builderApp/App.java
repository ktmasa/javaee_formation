package builderApp;

public class App {

	public static void main(String[] args) {

		OrdinateurBuilder builder = new OrdinateurBuilder();
		
		Ordinateur o = builder.addHdd("disque 2 To")
							  .setReseau(OrdinateurBuilder.RESEAU_100MBIT)
							  .addHdd("disque ssd 500Go")
							  .setSouris(false)
							  .addRAM(8096)
							  //.addRAM(153135435)
							  .build();
		
		System.out.println(o);

	}

}
