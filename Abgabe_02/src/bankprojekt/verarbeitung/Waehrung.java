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
 * Enum Waehung beinhaltet eine bestimmte Menge von Waehrungen mit ihren jeweiligen Umrechnungskurs zum Euro 
 * und dazu relevante Methoden zum Umrechnen.
 * @author timoji
 *
 */
public enum Waehrung {

	EUR(1.0000), BGN(1.9558), MKD(62.6200), DKK(7.4604);
	
	private final double umrechnungskursZumEuro;
	
	/**
	 * Konstruktor 
	 * @param umrechnungskursZumEuro der jeweilige Umrechnungskurs zum Euro
	 */
	private Waehrung(double umrechnungskursZumEuro) {
		this.umrechnungskursZumEuro = umrechnungskursZumEuro;
	}
	
	/**
	 * Rechnet den betrag in Euro in die jeweils angegebene Waehrung um.
	 * @param betrag betrag in Euro
	 * @return umgerechneter Betrag in neuer Waehrung
	 */
	public double euroInWaehrungUmrechnen(double betrag) {
		return betrag * this.umrechnungskursZumEuro;
	}
	
	/**
	 * Rechnet den betrag in der der momentanen Waehrung in Euro um.
	 * @param betrag betrag in der momentanen Waehrung
	 * @return umgerechneter Betrag in Euro
	 */
	public double waehrungInEuroUmrechnen(double betrag) {
		return betrag / this.umrechnungskursZumEuro;
	}
	
	/**
	 * Rechnet den Betrag in alter Waehrung, in neuer Waehrung um
	 * @param betrag Betrag in alter Waehrung
	 * @param w neue Waehrung
	 * @return gibt den Betrag in neuer Waehrung zurueck
	 */
	public double waehrungInWaehrungUmrechnen(double betrag, Waehrung w) {
		return w.euroInWaehrungUmrechnen(this.waehrungInEuroUmrechnen(betrag));
	}
	
	/**
	 * Prueft, ob die angegebene Waehrung existiert.
	 * @return true, wenn Waehrung existiert, sonst false
	 */
	public boolean waehrungsExistiert() {
		for(Waehrung waehrung: Waehrung.values()) {
			if (this == waehrung) {
				return true;
			}
		}
		return false;
	}
	
}
