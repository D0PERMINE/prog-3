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
 * Bei @Override keine Javadoc oder? Weil die Methoden im jeweiligen Interface 
 * schon beschrieben/dokumentiert sind. Oder sollen wir trotzdem spezifizieren?
 */

package bruch;

import java.math.BigInteger;

/**
 * Klasse Bruch dient zur Speicherung eines mathematischen Bruchs: 
 * bestehend aus Zaehler und Nenner
 * @author timoji
 *
 */
public class Bruch implements Comparable<Bruch>{
	
	private int zaehler;
	private int nenner;
	private int ganzeZahl;
	
	/**
	 * Konstruktor
	 * @param zaehler Zaehler vom Bruch
	 * @param nenner Nenner vom Bruch
	 */
	public Bruch(int zaehler, int nenner) {
		this.zaehler = zaehler;
		setNenner(nenner);
	}
	
	/**
	 * Konstruktor
	 * @param ganzeZahl Ganze Zahl als "Bruch"
	 */
	public Bruch(int ganzeZahl) {
		this.ganzeZahl = ganzeZahl;
	}

	@Override
	public int compareTo(Bruch o) {
		double thisBruch = this.zaehler / Double.valueOf(this.nenner);
		double otherBruch = o.zaehler / Double.valueOf(o.nenner);
		
		if (thisBruch > otherBruch) {
			return 1;
		} else if (thisBruch < otherBruch) {
			return -1;
		} 
		return 0;
	}
	
	/**
	 * Multipliziert zwei Brueche miteinander.
	 * @param b Bruch mit dem multipliziert werden soll
	 * @return Das Produkt als Bruch.
	 */
	public Bruch multiplizieren(Bruch b) {
		Bruch produkt = new Bruch(this.zaehler * b.zaehler, this.nenner * b.nenner);
		return produkt;
	}
	
	/**
	 * Rechnet den Bruch in eine Kommazahl um.
	 * @return Den Bruch als Kommazahl.
	 */
	public double ausrechnen() {
		double bruchAlsKommazahl = this.zaehler / this.nenner;
		return bruchAlsKommazahl;
	}
	
	/**
	 * Kuerzt this mit dem groessten gemeinsamen Teiler.
	 */
	public void kuerzen() {
		BigInteger zaehlerBigInteger = new BigInteger(String.valueOf(zaehler));
		BigInteger nennerBigInteger = new BigInteger(String.valueOf(nenner));
		int gcd = zaehlerBigInteger.gcd(nennerBigInteger).intValue();
		if (gcd != 0) {
			zaehler = zaehler / gcd;
			nenner = nenner /gcd;
		}
	}
	
	/**
	 * Gibt den Kehrwert von this zurueck.
	 * @return Kehrwert von this
	 */
	public Bruch kehrwert() {
		Bruch kehrwertBruch = new Bruch(nenner, zaehler);
		return kehrwertBruch;
	}
	
	/**
	 * Dividiert zwei Brueche miteinander.
	 * @param b Bruch mit dem dividiert werden soll
	 * @return Quotient aus den beiden Bruechen
	 */
	public Bruch dividieren(Bruch b) {
		Bruch quotientBruch = new Bruch(kehrwert().multiplizieren(b).zaehler, kehrwert().multiplizieren(b).nenner);
		return quotientBruch;
	}
	
	/**
	 * Gibt den Zaehler des Bruchs zurueck.
	 * @return Zaehler des Bruchs
	 */
	public int getZaehler() {
		return zaehler;
	}
	
	/**
	 * Gibt den Nenner des Bruchs zurueck.
	 * @return Nenner des Bruchs
	 */
	public int getNenner() {
		return nenner;
	}

	/**
	 * Gibt die ganze Zahl des "Bruchs" zurueck.
	 * @return Ganze Zahl des "Bruchs"
	 */
	public int getGanzeZahl() {
		return ganzeZahl;
	}

	/**
	 * Setzt den Nenner des Bruchs.
	 * @param nenner Nenner des Bruchs
	 * @throws IllegalArgumentException wenn man Nenner 0 setzen moechte
	 */
	public void setNenner(int nenner) throws IllegalArgumentException{
		if (nenner != 0) {
			this.nenner = nenner;			
		} else {
			throw new IllegalArgumentException("Nenner darf nicht 0 sein.");
		}
	}
	
	/**
	 * Gibt den Bruch in einer String-Darstellung zurueck.
	 */
	public String toString() {
		return "Der Bruch ist: " + zaehler + "/" + nenner;
	}	
	
}
