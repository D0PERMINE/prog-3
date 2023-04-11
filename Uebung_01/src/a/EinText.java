package a;

import java.awt.Font;
import java.awt.Graphics;

/**
 * Text, der ausgedruckt werden soll
*/
public class EinText{
	/** Text für Seite 1  im Ausdruck
	*/
	private String textAufSeite1 = "Ein langer langer Text...";
	/** Text für Seite 2  im Ausdruck
	*/
	private String textAufSeite2 = "Und noch was Geschriebenes...";
	
	/**
	 * schreibt den text in die Seite hinein, die vom übergebenen
	 * graphics-Objekt dargestellt wird
	 * @param text der zu schreibenden Text
	 * @param graphics eine auszudruckende Seite, nicht null
	*/
	private void schreiben(Graphics graphics, String text)
	{
		graphics.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
		graphics.drawString(text, 50, 70);
	}
	
}