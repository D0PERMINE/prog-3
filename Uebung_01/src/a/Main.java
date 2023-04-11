//package a;
//
///**
// * Test für EndlicherAutomat
// * 
// * @author Dorothea Hubrich
// *
// */
//public class Main {
//	/**
//	 * Testet mit Hilfe des Variablennamen-Automatens die Gültigkeit einiger
//	 * Namen für Variablen,
//	 * im Anschluss wird ein allgemeiner Automat für die Sprache "Wörter
//	 * aus den Buchstaben a und b, die auf a enden" gebaut; einige Wörter
//	 * werden damit geprüft.
//	*/
//	public static void main(String[] args)
//	{
//		EndlicherAutomat va = new VariablennameAutomat();
//		//der Automat prüft auf gültige Variablennamen in C
//		System.out.println("abc: " + va.testen("abc"));  //true
//		System.out.println("1abc: " + va.testen("1abc"));  //false
//		System.out.println("a: " + va.testen("a"));  //true
//		System.out.println("_a_b_c: " + va.testen("_a_b_c"));  //true
//		System.out.println("ha.llo: " + va.testen("ha.llo"));  //false
//		
//		va = new AllgemeinerAutomat(new String[] {"a->1, b->0","a->1, b->0"}, new int[] {1});
//		//der Automat prüft, ob ein Wort nur aus den Buchstaben a und b besteht und auf a endet
//		System.out.println("ab " + va.testen("ab")); //false
//		System.out.println("aba " + va.testen("aba"));  //true
//		System.out.println("a " + va.testen("a"));  //true
//		System.out.println("aabbaa " + va.testen("aabbaa"));  //true
//		System.out.println("acb " + va.testen("acb"));   //false
//		
//	}
//
//}
