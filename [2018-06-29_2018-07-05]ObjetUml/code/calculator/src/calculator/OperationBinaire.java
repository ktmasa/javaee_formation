package calculator;

public abstract class OperationBinaire implements Calculable
{
	private Calculable Operande1;
	private Calculable Operande2;
	
	public Calculable getOperande1() {return Operande1;}
	public void setOperande1(Calculable operande1) {Operande1 = operande1;}
	public Calculable getOperande2() {return Operande2;}
	public void setOperande2(Calculable operande2) {Operande2 = operande2;}
	
	public OperationBinaire(Calculable operande1, Calculable operande2) {
		Operande1 = operande1;
		Operande2 = operande2;
	}
	
	
	

}
