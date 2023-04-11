package a;

import java.util.Arrays;
import java.util.function.IntToDoubleFunction;
import java.util.function.IntUnaryOperator;


/**
 * Eine kleine Spielerei mit Arrays, um den Umgang mit Interfaces 
 * zu üben
 */
public class EinigeArrays {

	/**
	 * erzeugt zwei Arrays mit Hilfe von Arrays.setAll
	 * @param args wird nicht verwendet
	 */
	public static void main(String[] args) {
		System.out.println("Die Zahlen von 20 bis 1: ");
		int[] eins = new int[20];
		
		Arrays.setAll(eins, new IntUnaryOperator() {
			
			@Override
			public int applyAsInt(int operand) {
				return operand + 1;
			}
		});
		
//		for(int i = 0; i< eins.length; i++)
//		{
//			eins[i] = i + 1;
//		}
		System.out.println(Arrays.toString(eins));
		
		System.out.println("Die Zweierpotenzen von 2 hoch 0 bis 2 hoch 19:");
		double[] zwei = new double[20];
		
		Arrays.setAll(zwei, new IntToDoubleFunction() {

			@Override
			public double applyAsDouble(int value) {
				return Math.pow(2, value);
			}
		});
		
//		for(int i = 0; i< zwei.length; i++)
//		{
//			zwei[i] = Math.pow(2, i);
//		}
		System.out.println(Arrays.toString(zwei));
	}

}
