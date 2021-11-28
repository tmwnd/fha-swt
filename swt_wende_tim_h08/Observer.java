public class Observer {
	KundIn kundIn;
	IAbrechnungsart abrechnungsart;
	Nachrichtenkanal nachrichtenkanal;
	
	/**
	 * default ctor
	 * 
	 * @param kundIn KundIn
	 * @param abrechnungsart Objekt des Interfaces Abrechnungsart
	 * @param nachrichtenkanal Nachrichtenkanal
	 */
	public Observer(KundIn kundIn, IAbrechnungsart abrechnungsart, Nachrichtenkanal nachrichtenkanal) {
		this.kundIn = kundIn;
		this.abrechnungsart = abrechnungsart;
		this.nachrichtenkanal = nachrichtenkanal;
	}

	/**
	 * Benachrichtige den/r KundIn
	 * 
	 * @param nachricht Nachricht
	 */
	public void benachrichtige(String nachricht) {
		if (kundIn.bezahle(abrechnungsart.makeRechnung()))
			kundIn.werdeBenachrichtigt(nachricht);
		else {
			nachrichtenkanal.removeObserver(this);
			System.out.println("    !" + kundIn.getName() +
				" hat nicht bezahlt. Das Abonnement wird aufgel�st!");
		}
	}
	
	/**
	 * toString
	 */
	public String toString() {
		return "KundIN: " + " ".repeat(8) + kundIn.getName() + "\nAbrechnungsart: " + abrechnungsart.getAbrechnungsart();
	}
}
