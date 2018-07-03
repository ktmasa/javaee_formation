package calculator;

public class App {

	public static void main(String[] args) {
		// 2 + 3 * 5
		
		Calculable c1 = new OpAddition(new ValeurImmediate(2.0),
								new OpMultiplication(new ValeurImmediate(3.0),
													new ValeurImmediate(5.0)));

		/*
		 * 	c1(OpAdd  -> VI(2.0)
		 * 			  -> OPMUL  -> VI 3.0
		 * 						-> VI 5.0
		 * 
		 * 
		 */
		
		System.out.println(c1.calculer());

		
		Calculable c2 = new OpAddition(new ValeurImmediate(2.0),
				new OpMultiplication(new ValeurImmediate(3.0),
									new ValeurInput("variable A")));

		
		System.out.println(c2.calculer());
	}

}
