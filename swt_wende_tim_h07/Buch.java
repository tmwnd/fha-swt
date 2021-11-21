import java.util.ArrayDeque;

/**
 * Buch Klasse
 * 
 * @author Tim Wende
 *
 */
public class Buch {
	// .. Hier die entsprechenden Attribute einpflegen
	private String bezeichnung;
	private ArrayDeque<Studierender> warteliste = new ArrayDeque<>(); // ordered
	private boolean gesperrt = false;

	/**
	 * default ctor
	 * 
	 * @param bezeichnung Bezeichnung des Buches
	 */
	public Buch(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	/**
	 * Gibt die Bezeichnung des Buches zurück
	 * 
	 * @return Bezeichnung
	 */
	public String getBezeichnung() {
		return bezeichnung;
	}

	/**
	 * Leiht das Buch aus
	 * 
	 * @param ausleihender Ausleihender
	 */
	public void ausleihen(Studierender ausleihender) {
		if (gesperrt)
			throw new ArithmeticException("Buch " + bezeichnung + " gesperrt");
		if (warteliste.size() == 0) {
			gesperrt = true;
			return;
		}
		if (warteliste.getFirst() == ausleihender)
			warteliste.pop();
		else
			throw new ArithmeticException(
					"Buch " + bezeichnung + " von " + warteliste.getFirst().getName() + " vorgemerkt");
		gesperrt = true;
	}

	/**
	 * Gibt das Buch zurück
	 */
	public void zurueckgeben() {
		gesperrt = false;
	}

	/**
	 * Fügt einen Wartenden zur Warteliste hinzu
	 * 
	 * @param wartender Wartender
	 */
	public void addWartender(Studierender wartender) {
		warteliste.offer(wartender);
	}

	/**
	 * Benachrichtigt ersten Wartenden
	 */
	public void benachrichtige() {
		if (warteliste.size() == 0)
			return;
		Studierender vormerkender = warteliste.getFirst();
		vormerkender.benachrichtige();
		System.out.println("@" + vormerkender.getName() + ": " + bezeichnung + " ist verfügbar");
	}

	/**
	 * default toString()
	 */
	public String toString() {
		String ret = "Bezeichnung: " + " ".repeat(4) + bezeichnung;
		if (warteliste.size() == 0)
			return ret;
		ret += "\nWartende: " + " ".repeat(7);
		String div = "";
		for (int i = 0; i <= 3; i++) {
			if (i >= warteliste.size())
				break;
			ret += div + ((Studierender) (warteliste.toArray()[i])).getName();
			div = ", ";
		}
		if (warteliste.size() > 4)
			ret += ", ...";
		ret += "\nAnzahl Wartende: " + warteliste.size();
		return ret;
	}
}
