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

package abgabe_03;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import bankprojekt.verarbeitung.GesperrtException;
import bankprojekt.verarbeitung.Girokonto;
import bankprojekt.verarbeitung.Konto;
import bankprojekt.verarbeitung.Kunde;
import bankprojekt.verarbeitung.Waehrung;

/**
 * Test Klasse um Methoden aus Klasse Konto zu testen
 * @author timoji
 *
 */
class KontoTest {
	
	Kunde kunde;
	Konto konto;
	
	/**
	 * Am Anfang von jedem Test wird ein Konto erstellt und 1000 EUR eingezahlt
	 */
	@BeforeEach
	void setup() {
		kunde = new Kunde("Benjamin", "Patch", "BR Volleys Str.", LocalDate.parse("1994-06-21"));
		konto = new Girokonto(kunde, 123456, 1000.0);
		konto.einzahlen(1000);
	}

	/**
	 * Testet ob der waehrungswechsel von EUR zu DKK funktioniert
	 */
	@Test
	void waehrungswechselEurInDkkTest() {
		assertEquals(Waehrung.EUR, konto.getAktuelleWaehrung());
		konto.waehrungswechsel(Waehrung.DKK);
		assertEquals(Waehrung.DKK, konto.getAktuelleWaehrung());
	}
	
	/**
	 * Testet ob der Kontostand richtig ist, nachdem die Waehrung von EUR nach DKK gewechselt wird
	 */
	@Test
	void waehrungswechselEurInDkkMitRichtigemKontostandTest() {
		assertEquals(Waehrung.EUR, konto.getAktuelleWaehrung());
		assertEquals(1000, konto.getKontostand());
		konto.waehrungswechsel(Waehrung.DKK);
		assertEquals(Waehrung.DKK, konto.getAktuelleWaehrung());
		assertEquals(7460.4, konto.getKontostand());
//		assertTrue(konto.getKontostandFormatiert().indexOf("DKK") > -1);
	}
	
	/**
	 * Testet ob der Kontostand richtig ist, nachdem 100 EUR abgehoben wurde
	 * @throws IllegalArgumentException wenn ein ungeeigneter betrag abgehoben werden soll
	 * @throws GesperrtException wenn konto gesperrt ist
	 */
	@Test
	void abhebenInEurTest() throws IllegalArgumentException, GesperrtException {
		assertEquals(1000, konto.getKontostand());
		konto.abheben(100, konto.getAktuelleWaehrung());
		assertEquals(900, konto.getKontostand());
	}
	
	/**
	 * Testet ob Kontostand richtig ist, nachdem 100 DKK abgehoben wurde
	 * @throws IllegalArgumentException wenn ein ungeeigneter betrag abgehoben werden soll
	 * @throws GesperrtException wenn Konto gesperrt ist
	 */
	@Test
	void abhebenInDkkTest() throws IllegalArgumentException, GesperrtException {
		assertEquals(1000, konto.getKontostand());
		konto.abheben(100, Waehrung.DKK);
		assertEquals(986.6, konto.getKontostand());
	}
}
