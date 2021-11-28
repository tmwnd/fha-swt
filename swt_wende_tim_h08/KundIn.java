import java.util.ArrayList;

/**
 * Kunde Klasse
 * 
 * @author Tim Wende
 *
 */
public class KundIn {
	private static ArrayList<KundIn> kundInnen = new ArrayList<>(); // wieso sollte Main hierf�r verantwortlich sein?
	
	/**
	 * Gibt die static ArrayList mit allen KundInnen zur�ck
	 * Wenn man auf Datenkapselung achten würde, könnte man kundInnen clonen,
	 * so einen Schabernack machen wir hier aber natürlich nicht.
	 * 
	 * @return alle KundInnen
	 */
	public static ArrayList<KundIn> getKundInnen() {
		return kundInnen;
	}
	
	private String name;
	private int kapital;
	
	/**
	 * default ctor, welcher genutzt wird, um chancengleich allen KundInnen dasselbe
	 * Startkapital zur Verfuegung zu stellen
	 * 
	 * @param name
	 */
	KundIn(String name){
		this(name, 5); // default kapital: 5 Geld
	}
	
	/**
	 * ctor, welcher genutzt wird, falls man kapitalistisch die Armutsschere aufreissen moechte,
	 * durch den manche KundInnen einen privilegierteren Start in die Abonnementwelt erhalten
	 * 
	 * @param name
	 * @param kapital
	 */
	KundIn(String name, int kapital){
		this.name = name;
		this.kapital = kapital;
		kundInnen.add(this);
	}
	
	/**
	 * Gibt den Namen des/r KundIn zurueck
	 * 
	 * @return Name des/r KundIn
	 */
	public String getName() {
		return name;
	}
	



	/**
	 * Platzhalter; normale KundInnen wuerden hier lesen
	 * 
	 * @param nachricht Nachricht des Nachrichtenkanals
	 */
	public void werdeBenachrichtigt(String nachricht) {}
	
	/**
	 * Bezahle
	 * 
	 * @param betrag Betrag
	 * @return true, falls bezahlt werden kann; false, wenn nicht
	 */
	public boolean bezahle(int betrag) {
		if (kapital + betrag >= 0) {
			kapital += betrag;
			System.out.println("    @" + name + ": " + betrag);
			return true;
		}
		return false;
	}
	
	/**
	 * toString
	 */
	public String toString() {
		return name;
	}
	
	/**
	 * toString in schoen
	 */
	public void print() {
		System.out.println(Test.box("Name: " + " ".repeat(3) + this.name + "\nKapital: " + this.kapital + "�"));
	}
}
