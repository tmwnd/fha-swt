/**
 * Abrechnungsart Interface
 * 
 * @author Tim Wende
 *
 */
public interface IAbrechnungsart {
	/**
	 * Setze die Kosten pro Nachricht
	 * 
	 * @param kosten Kosten pro Nachricht
	 */
	public void setKosten(int kosten);
	
	/**
	 * Erstelle eine Rechung
	 * 
	 * @return Betrag der Rechnung
	 */
	public int makeRechnung();
	
	/**
	 * Gibt den Namen der Abrechnungsart zurueck
	 * .getType() moeglich, hier aber nicht genutzt
	 * 
	 * @return NAme der Abrechnungsart
	 */
	public String getAbrechnungsart();
}
