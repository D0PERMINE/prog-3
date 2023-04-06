/**
 * Modul: Programmierung 3 (SoSe 23)
 * Dozent: Dorothea Hubrich
 * 
 * Name: Timo Ji
 * Matrikelnummber: 575725
 * 
 * Partner: /
 * 
 * Anmerkungen: 
 * System.lineSeparator() funktioniert bei mir nicht? 
 * Es macht keinen Zeilenumbruch.
 */

package bruch;

import java.util.Arrays;

/**
 * Main Klasse mit der main-Methode zum Testen von Methoden
 * @author timoji
 *
 */
public class Main {
	
	public static void main(String[] args) {

		Bruch[] bruchArray = {
				new Bruch(1, 2),
				new Bruch(6, 10),
				new Bruch(1, 3)
				};
		printBruchArray(bruchArray);
		Arrays.sort(bruchArray);
		printBruchArray(bruchArray);
		Arrays.sort(bruchArray, new BruchVergleichen());
		printBruchArray(bruchArray);
			
	}
	
	public static void printBruchArray(Bruch[] bruchArray) {
		for (int i = 0; i < bruchArray.length; i++) {
			System.out.println(bruchArray[i].toString());
		}
//		System.lineSeparator(); // funktioniert nicht?
		System.out.println();

	}

}
