/**
 * Modul: Programmierung 3 (SoSe 23)
 * Dozent: Dorothea Hubrich
 * 
 * Name: Timo Ji
 * Matrikelnummber: 575725
 * 
 * Partner: /
 * 
 * Anmerkungen: /
 */

package bruch;

import java.util.Comparator;

/**
 * Klasse BruchVergleichen implementiert die compare-Methode, 
 * welche zwei Brueche (absteigend) nach ihrer differenz vergleicht
 * @author timoji
 *
 */
public class BruchVergleichen implements Comparator<Bruch>{

	@Override
	public int compare(Bruch o1, Bruch o2) {
		double differenzBruch1 = o1.getZaehler() - o1.getNenner();
		double differenzBruch2 = o2.getZaehler() - o2.getNenner();
		
		if (differenzBruch1 > differenzBruch2) {
			return -1;
		} else if (differenzBruch1 < differenzBruch2) {
			return 1;
		} 
		return 0;
	}

}
