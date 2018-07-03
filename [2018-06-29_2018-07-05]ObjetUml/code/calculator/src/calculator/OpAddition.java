package calculator;

public class OpAddition extends OperationBinaire {

	
	
	public OpAddition(Calculable operande1, Calculable operande2) {
		super(operande1, operande2);
	}

	@Override
	public double calculer() {
		return getOperande1().calculer() + getOperande2().calculer();
	}

}
