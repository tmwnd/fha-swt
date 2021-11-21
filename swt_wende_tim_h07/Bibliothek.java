import java.util.ArrayList;

/**
 * Bibliothek Klasse
 * 
 * @author Tim Wende
 *
 */
public class Bibliothek {
	// .. Hier die entsprechenden Attribute einpflegen
	private String bezeichnung; // unique
	private ArrayList<Buch> buecher = new ArrayList<>(); // ordered
	private ArrayList<Studierender> studierende = new ArrayList<>();

	/**
	 * default ctor
	 * 
	 * @param bezeichnung Bezeichnung der Bibliothek
	 */
	public Bibliothek(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	/**
	 * Fügt ein Buch in die Bibliothek hinzu
	 * 
	 * @param buch Buch
	 */
	public void add(Buch buch) {
		buecher.add(buch);
	}

	/**
	 * Leiht ein Buch aus
	 * 
	 * @param buch         Buch
	 * @param ausleihender Ausleihender
	 */
	public void ausleihen(Buch buch, Studierender ausleihender) {
		System.out.println(ausleihender.getName() + " hat " + buch.getBezeichnung() + " ausgeliehen");
		buch.ausleihen(ausleihender);
	}

	/**
	 * Gibt ein Buch zurück
	 * 
	 * @param buch Buch
	 */
	public void zurueckgeben(Buch buch) {
		System.out.println(buch.getBezeichnung() + " wurde zurückgegeben");
		buch.zurueckgeben();
		benachrichtigeSobaldBuchXYverfuegbarIst(buch);
	}

	/**
	 * Fügt einen Wartenden zur Warteliste des Buches hinzu
	 * 
	 * @param buch         Buch
	 * @param vormerkender Vormerkender
	 */
	public void addWartender(Buch buch, Studierender vormerkender) {
		System.out.println(vormerkender.getName() + " hat sich " + buch.getBezeichnung() + " vorgemerkt");
		buch.addWartender(vormerkender);
	}

	/**
	 * Benachrichtige sobald BuchXY verfuegbar ist
	 * 
	 * @param buchXY Buch
	 */
	public void benachrichtigeSobaldBuchXYverfuegbarIst(Buch buchXY) {
		buchXY.benachrichtige();
	}

	/**
	 * default toString() in schön
	 */
	public String toString() {
		String ret = "|" + " ".repeat((Test.MAX_LENGTH - 2 - bezeichnung.length()) / 2) + bezeichnung;
		ret += "\n|\n|  Bezeichnung: " + bezeichnung;
		ret += "\n|\n|  Bücher:";
		ret += "\n|  +" + "-".repeat(Test.MAX_LENGTH - 8) + "+";
		String div = "";
		for (Buch buch : buecher) {
			ret += div + "\n|  | " + buch.toString().replace("\n", "\n|  | ");
			div = "\n|  |";
		}
		ret += "\n|  +" + "-".repeat(Test.MAX_LENGTH - 8) + "+";

		String out = "+" + "-".repeat(Test.MAX_LENGTH - 2) + "+";
		for (String line : ret.split("\n")) {
			if (line.startsWith("|  |"))
				out += "\n" + line + " ".repeat(Test.MAX_LENGTH - 4 - line.length()) + "|  |";
			else
				out += "\n" + line + " ".repeat(Test.MAX_LENGTH - 1 - line.length()) + "|";
		}

		return out + "\n+" + "-".repeat(Test.MAX_LENGTH - 2) + "+";
	}
}
