/**
 * Interface um IAbrechnungsart weg zu Lambda'en
 * So muss man nicht fuer jede weiter Abrechnungsart eine neue Klasse erstellen
 * Dies ist vermutlich die einfachste Moeglichkeit eine sehr simple Abrechnungsart hinzuzufuegen.
 * 
 * @author Tim Wende
 *
 */
public interface IBerechne {
	/**
	 * Erstelle eine Rechung
	 * 
	 * @param kosten Kosten pro Nachricht
	 * @return Betrag der Rechnung
	 */
	int makeRechnung(int kosten);
}
