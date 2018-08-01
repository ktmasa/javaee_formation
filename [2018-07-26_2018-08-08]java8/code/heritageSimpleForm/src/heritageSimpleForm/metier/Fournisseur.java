package heritageSimpleForm.metier;

public class Fournisseur extends Personne {

	@Override
	public void contacter(String message) {
		// comme fournisseur herite de Personne
		// j'ai access a internalId (protected)
		System.out.println(this.internalId);

	}

}
