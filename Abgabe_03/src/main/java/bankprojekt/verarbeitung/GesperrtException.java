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
 * 
 */

package bankprojekt.verarbeitung;

/**
 * tritt bei einem schädigenden Zugriff auf ein gesperrtes Konto auf
 * @author Doro
 *
 */
@SuppressWarnings("serial")
public class GesperrtException extends Exception {
	
	/**
	 * Zugriff auf das Konto mit der angegebenen Kontonummer
	 * @param kontonummer die Nummer des gesperrten Kontos, auf das zugegriffen wurde
	 */
	public GesperrtException(long kontonummer)
	{
		super("Zugriff auf gesperrtes Konto mit Kontonummer " + kontonummer);
	}
	

}
