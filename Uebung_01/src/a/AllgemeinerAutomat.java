package a;

import java.util.HashMap;
import java.util.Map;

/**
 * ein allgemeiner endlicher Automat, bei dem man die 
 * Zustandsübergangsfunktion im Konstruktor angeben kann
 * @author Doro
 *
 */
public class AllgemeinerAutomat implements EndlicherAutomat {

	private int zustand;
	private int[] akzeptierend;
	private Map<Integer, Map<Character, Integer>> funktion
		= new HashMap<>();
	
	/**
	 * erstellt den Automaten, Startzustand ist immer 0
	 * @param uebergang Übergangsfunktion in folgendem Format:
	 * 					uebergang[i] enthält die Übergänge für den Zustand i
	 * 					Aufbau von uebergang[i]:
	 * 						zeichen1->folgezustand, zeichen2->folgezustand, zeichen3->folgezustand,...
	 * 					-1 kann dabei als Fehlerzustand ohne Folgezustände angegeben werden
	 * 					fehlende Übergänge für nicht im zu prüfenden String erlaubte Zeichen dürfen weggelassen werden
	 * @param akzeptierend Liste der akzeptierenden Zustände
	 * @throws IndexoutOfBoundsException, falls die Strings der
	 * 									Übergangsfunktion nicht korrekt aufgebaut sind
	 * @throws NumberFormatException, falls ein Folgeszustand nicht als Int-Zahl angegeben wurde
	 */
	public AllgemeinerAutomat(String[] uebergang, int[] akzeptierend)
	{
		this.akzeptierend = akzeptierend;
		for(int z = 0; z < uebergang.length; z++)
		{
			Map<Character, Integer> vonZAus = new HashMap<>();
			String[] zerlegt = uebergang[z].split(", ");
			for(int einzeln =0; einzeln < zerlegt.length; einzeln++)
			{
				char zeichen = zerlegt[einzeln].charAt(0);
				int folgezustand = Integer.parseInt(zerlegt[einzeln].substring(3));
				vonZAus.put(zeichen, folgezustand);
			}
			funktion.put(z, vonZAus);
		}
		
	}
	
	@Override
	public void starten() {
		zustand = 0;
	}

	@Override
	public void zustandswechsel(char zeichen) {
		try {
			zustand = funktion.get(zustand).get(zeichen);
		} catch (NullPointerException e)
		{
			zustand = -1;
		}

	}

	@Override
	public boolean akzeptiert() {
		for(int i=0; i< akzeptierend.length; i++)
			if(zustand == akzeptierend[i])
				return true;
		return false;
	}

}
