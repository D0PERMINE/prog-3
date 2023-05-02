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
 * alle Kontoarten, die im Programm zur Verfügung stehen
 * @author Admin
 *
 */
public enum Kontoart {
	GIROKONTO("ganz hoher Dispo"),
	SPARBUCH("ganz viele Zinsen"),
	FESTGELDKONTO("ist in Arbeit");
	
	private final String werbebotschaft;
	
	Kontoart(String werbung) //default-Sichtbarkeit: private
	{
		this.werbebotschaft = werbung;
	}

	/**
	 * Werbebotschaft dieser Kontoart
	 * @return the werbebotschaft
	 */
	public String getWerbebotschaft() {
		return this.werbebotschaft;
	}
	
	
}
